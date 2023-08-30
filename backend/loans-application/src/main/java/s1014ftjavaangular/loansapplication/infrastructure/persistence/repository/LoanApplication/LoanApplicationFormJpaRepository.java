package s1014ftjavaangular.loansapplication.infrastructure.persistence.repository.LoanApplication;

import org.springframework.data.jpa.repository.JpaRepository;
import s1014ftjavaangular.loansapplication.infrastructure.persistence.entities.LoanApplicationEntity;

import java.util.Optional;

public interface LoanApplicationFormJpaRepository extends JpaRepository<LoanApplicationEntity, String> {
}
