package s1014ftjavaangular.userservice.infrastructure.persistence.repository;

import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import s1014ftjavaangular.userservice.domain.model.entity.User;

import s1014ftjavaangular.userservice.domain.model.dto.request.AccountCreatedDto;
import s1014ftjavaangular.userservice.domain.model.dto.request.UserRequest;
import s1014ftjavaangular.userservice.domain.model.dto.response.UserResponse;

import s1014ftjavaangular.userservice.domain.model.mapper.UserMapper;
import s1014ftjavaangular.userservice.domain.repository.UserRepository;
import s1014ftjavaangular.userservice.infrastructure.persistence.entities.UserEntity;

import java.time.LocalDate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Repository
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepository {
    private final UserJpaRepository jpaRepository;

    @Override
    public String findLastUserNumber(String type){
        return jpaRepository.findByNumber(type);
    }

    @Override
    public List<User> findAll() {
        var entities = jpaRepository.findAll();

        List<User> userModel = entities.stream()
                .map((entity)-> entity.entityToModel())
                .toList();

        return userModel;
    }

    @Override
    public List<User> findAllByType(String type) {
        var entities = jpaRepository.findAllByType(type);

        List<User> userModel = entities.stream()
                .map(entity->entity.entityToModel())
                .collect(Collectors.toList());

        return userModel;
    }

    @Override
    public Optional<User> findById(String id) {
        if(id.isEmpty()) throw new IllegalArgumentException("The id cannot be empty");

        var user = jpaRepository.findById(id);

        return user
                .flatMap(entity-> Optional.of( entity.entityToModel() ))
                .or(Optional::empty);
    }

    @Override
    public void saveUser(final User model){
        if(model == null) throw new IllegalArgumentException("The model to save the user cannot be empty");

        var user = new UserEntity();

        user.setUserUuid(model.getId());
        user.setName(model.getName());
        user.setLastName(model.getLastName());
        user.setType(model.getType());
        user.setNumber(model.getNumber());
        user.setBlackList(model.getBlackList());

        jpaRepository.save(user);
    }

    @Transactional
    @Override
    public void update(User model) {
        //Valido que el DTO no venga en null
        if(model == null) throw new IllegalArgumentException("The User cannot be empty in Update");

        var entity = UserEntity.modelToEntity(model);
        jpaRepository.save(entity);

    }

}