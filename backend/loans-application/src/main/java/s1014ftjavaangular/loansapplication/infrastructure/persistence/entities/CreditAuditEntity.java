package s1014ftjavaangular.loansapplication.infrastructure.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="credit_audit")
public class CreditAuditEntity {

    @Id
    @Column(name="credit_audit_id", nullable = false)
    private String creditAuditId;

    @Column(name="audit_date", nullable = false)
    private LocalDate auditDate;

    @Column(name="credit_auditor_id", nullable = false)
    private String creditAuditorId;

    @JsonIgnore
    @ToString.Exclude
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "loan_application_id", referencedColumnName = "loan_application_id")
    private LoanApplicationEntity loansApplicationId;
}
