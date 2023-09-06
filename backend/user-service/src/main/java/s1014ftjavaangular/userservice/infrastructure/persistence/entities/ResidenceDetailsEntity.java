package s1014ftjavaangular.userservice.infrastructure.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.util.StringUtils;
import s1014ftjavaangular.userservice.domain.model.entity.ResidenceDetails;

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

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "address")
    private String address;

    @Column(name = "apartment")
    private String apartment;

    @Column(name = "zipcode")
    private String zipCode;

    @JsonIgnore
    @ToString.Exclude
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @MapsId
    private UserEntity user;

    public ResidenceDetails entityToModel(){
        return ResidenceDetails.builder()
                .id(StringUtils.hasText(this.getResidenceUuid()) ?  this.getResidenceUuid() : null)
                .state(StringUtils.hasText(this.getState()) ? this.getState() : null)
                .city(StringUtils.hasText(this.getCity()) ? this.getCity() : null)
                .zipCode(StringUtils.hasText(this.getZipCode()) ? this.getZipCode() : null)
                .address(StringUtils.hasText(this.getAddress()) ? this.getAddress() : null)
                .apartment(StringUtils.hasText(this.getApartment()) ? this.getApartment() : null)
                .build();
    }
}
