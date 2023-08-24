package s1014ftjavaangular.userservice.infrastructure.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import s1014ftjavaangular.userservice.domain.model.entity.ResidenceDetails;
import s1014ftjavaangular.userservice.domain.model.enums.HousingStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "residence_details")
public class ResidenceDetailsEntity {
    @Id
    @Column(name = "user_id")
    private String residenceUuid;

    @Enumerated(EnumType.STRING)
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

    @Column(name = "address1")
    private String address1;

    @Column(name = "address2")
    private String address2;

    @Column(name = "zipcode")
    private String zipCode;

    @JsonIgnore
    @ToString.Exclude
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @MapsId
    private UserEntity user;

    public void update(ResidenceDetails residenceDetails){
        if(residenceDetails.getState() != null) this.setState( residenceDetails.getState() );
        if(residenceDetails.getCity() != null) this.setCity( residenceDetails.getCity() );
        if(residenceDetails.getHousingStatus() != null) this.setHousingStatus( residenceDetails.getHousingStatus() );
        if(residenceDetails.getYearsInHouse() != null) this.setYearsInHouse( residenceDetails.getYearsInHouse() );
        if(residenceDetails.getMonthsInHouse() != null) this.setMonthsInHouse( residenceDetails.getMonthsInHouse() );
        if(residenceDetails.getAddress1() != null) this.setAddress1( residenceDetails.getAddress1() );
        if(residenceDetails.getAddress2() != null) this.setAddress2( residenceDetails.getAddress2() );
        if(residenceDetails.getZipCode() != null) this.setZipCode( residenceDetails.getZipCode() );
    }
}
