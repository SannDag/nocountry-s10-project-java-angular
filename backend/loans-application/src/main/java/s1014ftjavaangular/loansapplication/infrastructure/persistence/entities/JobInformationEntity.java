package s1014ftjavaangular.loansapplication.infrastructure.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import s1014ftjavaangular.loansapplication.domain.model.enums.WorkShift;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="job_information")
public class JobInformationEntity {

    @Id
    @Column(name="loan_application_id")
    private String loanApplicationId;

    @Column(name="company",nullable = false , length = 60)
    private String company;

    @Column(name="occupation",nullable = false, length = 60)
    private String occupation;

    @Column(name="work_shift",nullable = false)
    private WorkShift workShift;

    @Column(name="years_in_company")
    private Integer yearsInCompany;

    @Column(name="monthly_income", nullable = false)
    private Double monthlyIncome;

    @Column(name="other_income")
    private Double otherIncome;

    @Column(name="city", length = 60)
    private String city;

    @Column(name="state", length = 70)
    private String state;

    @Column(name="address1", length = 80)
    private String address1;

    @Column(name="address2", length = 80)
    private String address2;

    @Column(name="phone", length = 30)
    private String phone;

    @JsonIgnore
    @ToString.Exclude
    @MapsId
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "loan_application_id", referencedColumnName = "loan_application_id")
    private LoansApplicationEntity loansApplication;
}
