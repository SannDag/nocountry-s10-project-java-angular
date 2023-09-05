package s1014ftjavaangular.loansapplication.infrastructure.persistence.repository.loanApplication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import s1014ftjavaangular.loansapplication.infrastructure.persistence.entities.LoanApplicationEntity;

import java.util.Optional;

public interface LoanApplicationJpaRepository extends JpaRepository<LoanApplicationEntity, String> {

    Optional<LoanApplicationEntity> findById(String id);

    @Query(value = "SELECT MAX(l.loan_application_number) FROM loans_application AS l", nativeQuery = true)
    Optional<String> findLastLoanApplicationNumber();

    @Query(value = """ 
            SELECT COUNT(*) 
            FROM loans_application AS la 
            INNER JOIN general_data AS gd ON  la.loan_application_id = gd.loan_application_id 
            WHERE la.status IN (0, 1)  AND gd.identification = :identification
            """, nativeQuery = true)
    Integer countIncompleteOrAuditingStatusLoanApplication(String identification);
}
