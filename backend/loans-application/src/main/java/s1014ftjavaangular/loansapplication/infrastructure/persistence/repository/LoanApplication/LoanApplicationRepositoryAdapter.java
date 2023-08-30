package s1014ftjavaangular.loansapplication.infrastructure.persistence.repository.LoanApplication;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import s1014ftjavaangular.loansapplication.domain.repository.LoanApplicationRepository;


@Repository
@AllArgsConstructor
public class LoanApplicationRepositoryAdapter implements LoanApplicationRepository {

    private final LoanApplicationJpaRepository jpaRepository;




}
