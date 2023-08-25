package s1014ftjavaangular.loansapplication.infrastructure.persistence.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import s1014ftjavaangular.loansapplication.domain.model.entity.JobInformation;
import s1014ftjavaangular.loansapplication.domain.model.enums.Status;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="loans_application")
public class LoansApplicationEntity {
    @Id
    @Column(name = "loan_application_id")
    private String loanApplicationId;

    @Column(name = "customer_id", nullable = false)
    private String customersUuid;

    @Column(name = "loan_application_number", nullable = false)
    private String loanApplicationNumber;

    @Column(name = "request_amount", nullable = false)
    private Double requestedAmount;

    @Column(name = "create_at", nullable = false)
    private LocalDate createAt;

    @OneToOne(mappedBy = "loansApplication", cascade = CascadeType.ALL, orphanRemoval = true)
    private JobInformationEntity jobInformation;

    @JsonBackReference
    @OneToMany(mappedBy = "loansApplication", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReferencesEntity> references;

    @OneToOne(mappedBy = "loansApplication", cascade = CascadeType.ALL, orphanRemoval = true)
    private GuarantorEntity guarantor;

    @OneToOne(mappedBy = "loansApplication", cascade = CascadeType.ALL, orphanRemoval = true)
    private ReviewerEntity reviewer;

    @Column(name = "request_amount", nullable = false)
    private Status status;
}
