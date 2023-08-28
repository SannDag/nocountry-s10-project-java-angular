package s1014ftjavaangular.loansapplication.infrastructure.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import s1014ftjavaangular.loansapplication.domain.model.enums.HousingStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="application_residence")
public class ApplicationResidenceEntity {

    @Id
    @Column(name="loan_application_id")
    private String loanApplicationId;

    @Column(name = "housing_status")
    private HousingStatus housingStatus;

    @Column(name = "years_in_house")
    private Integer yearsInHouse;

    @Column(name = "months_in_house")
    private Integer monthsInHouse;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "address")
    private String address;

    @Column(name = "zipcode")
    private String zipcode;


}
