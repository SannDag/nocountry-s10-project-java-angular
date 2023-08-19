package s1014ftjavaangular.security.infrastructure.out.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import s1014ftjavaangular.security.infrastructure.out.persistence.entities.AccountEntity;

import java.util.Optional;

public interface AccountJpaRepository extends JpaRepository<AccountEntity, String> {
    Optional<AccountEntity> findByEmail(String email);
}
