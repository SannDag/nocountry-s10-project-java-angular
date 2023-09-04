package s1014ftjavaangular.userservice.infrastructure.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
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
                .id(this.getResidenceUuid())
                .state(this.getState())
                .city(this.getCity())
                .zipCode(this.getZipCode())
                .address(this.getAddress())
                .apartment(this.getApartment())
                .build();
    }
}
