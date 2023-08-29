package s1014ftjavaangular.loan.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import s1014ftjavaangular.loan.domain.model.enums.LoanStatus;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@Entity
@Table(
        name = "loan",
        uniqueConstraints = @UniqueConstraint(name = "uk_loan_number", columnNames = "loan_number")
)
public class LoanEntity {

    @Id
    @Column(name = "loan_id")
    private String loanId;

    @Column(name = "loan_application_id", nullable = false)
    private String loanApplicationId;

    @Column(name = "loan_number", nullable = false, unique = true)
    private String loanNumber;

    @Column(name = "create_at", nullable = false)
    private LocalDate createAt;

    @Column(name = "amount_approved", nullable = false, scale = 2)
    private Double amountApproved;

    @Column(name = "calculation_type")
    private String calculationType;

    @Column(name = "number_installments", length = 3)
    private String numberInstallments;

    @Column(name = "frequency_payment")
    private String frequencyPayment;

    @Column(name = "status", nullable = false)
    private LoanStatus status;

    @OneToMany(mappedBy = "loan", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AmortizationScheduleEntity> amortizationSchedule;

    @OneToOne(mappedBy = "loan")
    private LatePaymentRateLoanEntity latePaymentRateLoan;

    @OneToOne(mappedBy = "loan")
    private InterestRateLoanEntity interestRateLoan;

}
