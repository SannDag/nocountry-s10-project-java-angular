package s1014ftjavaangular.userservice.infrastructure.persistence.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import s1014ftjavaangular.userservice.domain.model.dto.request.AccountCreatedDto;
import s1014ftjavaangular.userservice.domain.model.dto.request.UserRequest;
import s1014ftjavaangular.userservice.domain.model.dto.response.UserResponse;
import s1014ftjavaangular.userservice.domain.model.entity.ResidenceDetails;
import s1014ftjavaangular.userservice.domain.model.mapper.UserMapper;
import s1014ftjavaangular.userservice.domain.repository.UserRepository;
import s1014ftjavaangular.userservice.infrastructure.persistence.entities.ResidenceDetailsEntity;
import s1014ftjavaangular.userservice.infrastructure.persistence.entities.UserEntity;

import java.util.List;
import java.util.Optional;
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

        user.setUserUuid(dto.getAccountUuid());
        user.setName(dto.getName());
        user.setLastName(dto.getLastname());
        user.setType(dto.getAccountRol());

        jpaRepository.save(user);
    }

    @Transactional
    @Override
    public void update(UserRequest dto) {
        if(dto == null) throw new IllegalArgumentException("The User request cannot be empty");

        var isUserExists = jpaRepository.existsByUserUuid(dto.getId());
        if(isUserExists) throw new RuntimeException("User does not exists");


        var entity = jpaRepository.findById(dto.getId()).get();

        if(dto.getName() != null) entity.setName(dto.getName());
        if(dto.getLastName() != null) entity.setLastName(dto.getLastName());
        if(dto.getIdentifier() != null) entity.setIdentifier(dto.getIdentifier());
        if(dto.getGenre() != null) entity.setIdentifier(dto.getIdentifier());
        if(dto.getBirthDay() != null) entity.setBirthDay(dto.getBirthDay());
        if(dto.getCivilStatus() != null) entity.setCivilStatus(dto.getCivilStatus());

        if(dto.getResidenceDetails() != null && entity.getResidenceDetails() != null ){
            entity.getResidenceDetails().update(dto.getResidenceDetails());
        }
        if(dto.getResidenceDetails() != null && entity.getResidenceDetails() == null){
            var residence = new ResidenceDetailsEntity();
            residence.update(dto.getResidenceDetails());
            entity.setResidenceDetails(residence);
        }

        if(!dto.getPhoneDetails().isEmpty()){

            dto.getPhoneDetails().stream().forEach(phoneDetails ->

                entity.getPhoneDetails().stream()
                        .filter(phoneDetailsEntity -> phoneDetailsEntity.getPhoneUuid() == phoneDetails.getPhoneUuid())
                        .forEach(phoneDetailsEntity -> {
                            if (phoneDetails.getPhoneLabel() != null) phoneDetailsEntity.setPhoneLabel(phoneDetails.getPhoneLabel());
                            if (phoneDetails.getCountryCode()!= null) phoneDetailsEntity.setCountryCode(phoneDetails.getCountryCode());
                            if (phoneDetails.getCityCode()!= null) phoneDetailsEntity.setCityCode(phoneDetails.getCityCode());
                            if (phoneDetails.getPhoneNumber()!= null) phoneDetailsEntity.setPhoneNumber(phoneDetails.getPhoneNumber());
                        })
            );

        }
    }

}
