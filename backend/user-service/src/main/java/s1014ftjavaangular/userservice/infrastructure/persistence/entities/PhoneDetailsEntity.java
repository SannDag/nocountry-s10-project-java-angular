package s1014ftjavaangular.userservice.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import s1014ftjavaangular.userservice.domain.models.enums.PhoneLabel;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "")
public class PhoneDetailsEntity {

    @Id
    @Column(name="phone_uuid")
    private String phoneUuid;
    @Enumerated(EnumType.STRING)
    private PhoneLabel phoneLabel;
    @Column(name = "country_code")
    private String countryCode;
    @Column(name = "city_code")
    private String cityCode;
    @Column(name = "phone_number")
    private String phoneNumber;
}
