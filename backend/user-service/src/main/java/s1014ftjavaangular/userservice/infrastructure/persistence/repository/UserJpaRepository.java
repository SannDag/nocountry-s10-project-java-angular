package s1014ftjavaangular.userservice.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import s1014ftjavaangular.userservice.infrastructure.persistence.entities.UserEntity;

import java.util.List;
import java.util.Optional;


public interface UserJpaRepository extends JpaRepository<UserEntity, String> {

    List<UserEntity> findAll();
    List<UserEntity> findAllByType(String type);
    Optional<UserEntity> findById(String id);
}
