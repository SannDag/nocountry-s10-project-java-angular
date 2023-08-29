package s1014ftjavaangular.loan.infrastructure.persistence.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import s1014ftjavaangular.loan.domain.model.enums.AmortizationStatus;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@Entity
@Table(name = "amortization_schedule")
public class AmortizationScheduleEntity {

    @Id
    @Column(name = "amortization_schedule_id")
    private String amortizationScheduleId;

    @Column(name = "loan_id", nullable = false)
    private String loanId;

    @Column(name = "payment_day", nullable = false)
    private LocalDate paymentDay;

    @Column(name = "capital_instalment", nullable = false, scale = 2)
    private Double capitalInstalment;

    @Column(name = "interest", nullable = false, scale = 2)
    private Double interest;

    @Column(name = "capital_balance", nullable = false, scale = 2)
    private Double capitalBalance;

    @Column(name = "total_paid", nullable = false, scale = 2)
    private Double totalPaid;

    @Column(name = "status", nullable = false)
    private AmortizationStatus status;

    @JsonBackReference
    @OneToMany(mappedBy = "amortizationSchedule", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LateFeedDetailsEntity> lateFeedDetailEntities;

    @ToString.Exclude
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "loan_id", referencedColumnName = "loan_id", foreignKey = @ForeignKey(name = "amortization_loan_fk"))
    private LoanEntity loan;
}
