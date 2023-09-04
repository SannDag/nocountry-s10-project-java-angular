package s1014ftjavaangular.userservice.infrastructure.persistence.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import s1014ftjavaangular.userservice.domain.model.dto.request.AccountCreatedDto;
import s1014ftjavaangular.userservice.domain.model.dto.request.UserRequest;
import s1014ftjavaangular.userservice.domain.model.dto.response.UserResponse;
import s1014ftjavaangular.userservice.domain.model.mapper.UserMapper;
import s1014ftjavaangular.userservice.domain.repository.UserRepository;
import s1014ftjavaangular.userservice.infrastructure.persistence.entities.PhoneDetailsEntity;
import s1014ftjavaangular.userservice.infrastructure.persistence.entities.ResidenceDetailsEntity;
import s1014ftjavaangular.userservice.infrastructure.persistence.entities.UserEntity;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Log4j2
@Repository
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepository {
    private final UserJpaRepository jpaRepository;
    private final UserMapper mapper;

    @Override
    public List<UserResponse> findAll() {
        var entity = jpaRepository.findAll();

        entity.stream().peek(log::info);

        List<UserResponse> userResponse = entity.stream()
                .map(mapper::entityToModel)
                .toList();

        return userResponse;
    }
    //
    @Override
    public List<UserResponse> findAllByType(String type) {
        var entity = jpaRepository.findAllByType(type);

        List<UserResponse> userResponse = entity.stream()
                .map(mapper::entityToModel)
                .collect(Collectors.toList());

        return userResponse;
    }

    @Override
    public Optional<UserResponse> findById(String id) {
        if(id.isEmpty()) {
            throw new IllegalArgumentException("The id cannot be empty");
        }

        var entity = jpaRepository.findById(id);

        var userResponse = entity
                .map(mapper::entityToModel);

        return userResponse;
    }

    @Override
    public void saveUser(final AccountCreatedDto dto){
        if(dto == null) throw new IllegalArgumentException("The model to save the user cannot be empty");

        var user = new UserEntity();

        int anoActual = LocalDate.now().getYear();
        String number = getCustomerActualCustomerNumber(dto.getAccountRol());
        String customerNumber = anoActual + "-" + number;

        user.setUserUuid(dto.getAccountUuid());
        user.setName(dto.getName());
        user.setLastName(dto.getLastname());
        user.setType(dto.getAccountRol());
        user.setNumber(customerNumber);
        user.setBlackList(false);

        jpaRepository.save(user);
    }

    @Transactional
    @Override
    public void update(UserRequest dto) {
        //Valido que el DTO no venga en null
        if(dto == null) throw new IllegalArgumentException("The User request cannot be empty");
        //Valido que el Usuario exista
        var isUserExists = jpaRepository.existsByUserUuid(dto.getId());
        if(!isUserExists) throw new RuntimeException("User does not exists");

        //Si existe busco el ID por el ID
        var entity = jpaRepository.findById(dto.getId()).get();

        //Verifica que datos se deben actualizar (Actualiza solo los que no son nulos en el dto)
        if(dto.getName() != null) entity.setName(dto.getName());
        if(dto.getLastName() != null) entity.setLastName(dto.getLastName());
        if(dto.getIdentifier() != null) entity.setIdentifier(dto.getIdentifier());
        if(dto.getIdentifierNumber() != null) entity.setIdentifierNumber(dto.getIdentifierNumber());
        if(dto.getGenre() != null) entity.setGenre(dto.getGenre());
        if(dto.getBirthDay() != null) entity.setBirthDay(dto.getBirthDay());
        if(dto.getCivilStatus() != null) entity.setCivilStatus(dto.getCivilStatus());

        //Entra si el Residence del DTO no es nulo y el de la entidad tampoco es nulo
        if(dto.getResidenceDetails() != null && entity.getResidenceDetails() != null ){
            //Actualiza el que existe
            entity.getResidenceDetails().update(dto.getResidenceDetails(), entity);
        }
        //Entra si el Residence del DTO no es nulo y el de la entidad si es nulo
        if(dto.getResidenceDetails() != null && entity.getResidenceDetails() == null){
            //Crea uno nuevo
            var residence = new ResidenceDetailsEntity();
            residence.update(dto.getResidenceDetails(), entity);
            entity.setResidenceDetails(residence);
        }

        //Entra si el DTO trae algun phone detail del Front
        if(!dto.getPhoneDetails().isEmpty()){
            //Recorre la lista de Numeros
            dto.getPhoneDetails().stream().forEach(phoneDetails -> {
                //Crea el nuevo PhoneDetailsEntity
                var newPhone = PhoneDetailsEntity.builder()
                        .user(entity)
                        .phoneUuid(UUID.randomUUID().toString())
                        .cityCode(phoneDetails.getCityCode())
                        .phoneLabel(phoneDetails.getPhoneLabel())
                        .countryCode(phoneDetails.getCountryCode())
                        .phoneNumber(phoneDetails.getPhoneNumber())
                        .build();

                //Si el label del newPhone es igual a uno existente lo borra (Evita que el usuario tenga telefonos con Label duplicados)
                entity.getPhoneDetails().removeIf(phoneEntity -> newPhone.getPhoneLabel().equals(phoneEntity.getPhoneLabel()));

                //Agrega el nuevo phoneDetail
                entity.getPhoneDetails().add(newPhone);
            });
        }
    }

    private String getCustomerActualCustomerNumber(String type) {
        String maxNumber = jpaRepository.findByNumber(type);

        if (maxNumber == null || maxNumber.isEmpty()) {
            return "1";
        } else {
            int separatorIndex = maxNumber.indexOf("-");

            if (separatorIndex != -1 && separatorIndex + 1 < maxNumber.length()) {
                String numeration = maxNumber.substring(separatorIndex + 1);
                int number = Integer.parseInt(numeration.trim());
                number++;
                return String.valueOf(number);
            } else {
                return "1";
            }
        }
    }

}