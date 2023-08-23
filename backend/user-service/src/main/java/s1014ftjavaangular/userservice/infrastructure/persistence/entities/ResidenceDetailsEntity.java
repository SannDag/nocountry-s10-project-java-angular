package s1014ftjavaangular.userservice.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import s1014ftjavaangular.userservice.domain.models.entity.User;
import s1014ftjavaangular.userservice.domain.models.enums.HousingStatus;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "")
public class ResidenceDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "residence_uuid")
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
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private UserEntity userEntity;
}
