package s1014ftjavaangular.loansapplication.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import s1014ftjavaangular.loansapplication.infrastructure.persistence.entities.LoansApplicationEntity;

public interface LoansApplicationJpaRepository extends JpaRepository<LoansApplicationEntity, String> {
}
