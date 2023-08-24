package s1014ftjavaangular.userservice.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import s1014ftjavaangular.userservice.infrastructure.persistence.entities.UserEntity;

import java.util.List;
import java.util.Optional;


public interface UserJpaRepository extends JpaRepository<UserEntity, String> {

    List<UserEntity> findAll();
    List<UserEntity> findAllByType(String type);
    Optional<UserEntity> findById(String id);

    Boolean existsByUserUuid(String userUuid);

    @Query(value = "SELECT MAX(u.number) FROM [user].dbo.users u WHERE u.[type] = :type", nativeQuery = true)
    String findByNumber(String type);
}
