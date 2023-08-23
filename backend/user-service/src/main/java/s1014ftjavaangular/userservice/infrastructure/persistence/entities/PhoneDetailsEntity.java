package s1014ftjavaangular.userservice.infrastructure.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import s1014ftjavaangular.userservice.domain.model.enums.PhoneLabel;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "phone_details")
public class PhoneDetailsEntity {

    @Id
    @Column(name="phone_id")
    private String phoneUuid;

    @Enumerated(EnumType.STRING)
    @Column(name = "phone_label", columnDefinition = "enum('HOME', 'CELLPHONE')")
    private PhoneLabel phoneLabel;

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "city_code")
    private String cityCode;

    @Column(name = "phone_number")
    private String phoneNumber;

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", updatable = false)
    private UserEntity user;

}
