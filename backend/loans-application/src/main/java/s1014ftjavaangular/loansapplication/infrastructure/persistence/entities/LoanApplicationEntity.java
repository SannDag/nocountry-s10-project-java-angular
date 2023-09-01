package s1014ftjavaangular.loansapplication.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import s1014ftjavaangular.loansapplication.domain.model.entity.LoanApplication;
import s1014ftjavaangular.loansapplication.domain.model.enums.Status;

import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="loans_application")
public class LoanApplicationEntity {
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

    @OneToOne(mappedBy = "loansApplicationId", cascade = CascadeType.ALL, orphanRemoval = true)
    private GuarantorEntity guarantor;

    @OneToOne(mappedBy = "loansApplicationId")
    private GeneralDataEntity generalData;

    @OneToOne(mappedBy = "loansApplicationId", cascade = CascadeType.ALL, orphanRemoval = true)
    private CreditAuditEntity creditAuditId;

    @Column(name = "status", nullable = false)
    private Status status;

    public static LoanApplicationEntity modelToEntity(LoanApplication model){
        return LoanApplicationEntity.builder()
                .loanApplicationId(model.getLoanApplicationId())
                .loanApplicationNumber(model.getLoanApplicationNumber())
                .requestedAmount(model.getRequestedAmount())
                .createAt(model.getCreateAt())
                .jobInformation(JobInformationEntity.modelToEntity.apply(model.getJobInformation()))
                .guarantor(GuarantorEntity.modelToEntity.apply(model.getGuarantor()))
                .generalData(GeneralDataEntity.modelToEntity.apply(model.getGeneralData()))
                .creditAuditId(CreditAuditEntity.modelToEntity.apply(model.getCreditAuditorId()))
                .status(model.getStatus())
                .build();
    }

}
