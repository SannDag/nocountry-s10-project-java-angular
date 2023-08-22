package s1014ftjavaangular.userservice.infrastructure.persistence.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import s1014ftjavaangular.userservice.domain.models.dto.response.UserResponse;
import s1014ftjavaangular.userservice.domain.models.entity.User;
import s1014ftjavaangular.userservice.domain.models.mapper.UserMapper;
import s1014ftjavaangular.userservice.domain.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepository {
    private final UserJpaRepository jpaRepository;
    private final UserMapper mapper;

    @Override
    public List<UserResponse> findAll() {
        var entity = jpaRepository.findAll();

        List<UserResponse> userResponse = entity.stream()
                .map(mapper::entityToModel)
                .collect(Collectors.toList());

        return userResponse;
    }

    @Override
    public List<UserResponse> findAllByType(String type) {
        var entity = jpaRepository.findAllByType(type);

        List<UserResponse> userResponse = entity.stream()
                .map(mapper::entityToModel)
                .collect(Collectors.toList());

        return userResponse;
    }

    @Override
    public List<UserResponse> findById(String id) {
        if(id.isEmpty()) {
            throw new IllegalArgumentException("The id cannot be empty");
        }

        var entity = jpaRepository.findById(id);

        List<UserResponse> userResponse = entity.stream()
                .map(mapper::entityToModel)
                .collect(Collectors.toList());

        return userResponse;
    }
}
