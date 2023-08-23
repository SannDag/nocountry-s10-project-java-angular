package s1014ftjavaangular.userservice.infrastructure.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import s1014ftjavaangular.userservice.domain.model.enums.HousingStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "residence_details")
public class ResidenceDetailsEntity {
    @Id
    @Column(name = "residence_id")
    private String residenceUuid;

    @Enumerated(EnumType.STRING)
    @Column(name = "housing_status", columnDefinition = "enum('OWNED', 'RENTED')")
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
    @OneToOne(mappedBy = "residenceDetails", fetch = FetchType.LAZY)
    private UserEntity userEntity;
}
