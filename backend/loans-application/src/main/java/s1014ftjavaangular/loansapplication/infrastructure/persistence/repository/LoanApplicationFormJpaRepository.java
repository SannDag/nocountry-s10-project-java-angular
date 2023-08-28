package s1014ftjavaangular.loansapplication.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import s1014ftjavaangular.loansapplication.infrastructure.persistence.entities.LoanApplicationEntity;

public interface LoanApplicationFormJpaRepository extends JpaRepository<LoanApplicationEntity, String> {
}
