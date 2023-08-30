package s1014ftjavaangular.loansapplication.infrastructure.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import s1014ftjavaangular.loansapplication.domain.model.enums.HousingStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="general_data")
public class GeneralDataEntity {

    @Id
    @Column(name="loan_application_id")
    private String loanApplicationId;

    @Column(name = "housing_status", nullable = false)
    private HousingStatus housingStatus;

    @Column(name = "years_in_house", nullable = false)
    private Integer yearsInHouse;

    @Column(name = "months_in_house", nullable = false)
    private Integer monthsInHouse;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name="apartment", nullable = false)
    private String apartment;

    @Column(name = "zipcode", nullable = false)
    private String zipcode;

    @Column(name = "phone", nullable = false)
    private String phone;

    @JsonIgnore
    @ToString.Exclude
    @MapsId
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "loan_application_id", referencedColumnName = "loan_application_id")
    private LoanApplicationEntity loansApplicationId;


}
