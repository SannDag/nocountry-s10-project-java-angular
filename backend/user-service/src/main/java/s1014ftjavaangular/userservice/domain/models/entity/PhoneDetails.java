package s1014ftjavaangular.userservice.domain.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "phone_details")
public class PhoneDetails {
    @Id
    @Column(name = "phone_id")
    private UUID id;

    @Column(name = "label")
    private String label;

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "city_code")
    private String cityCode;

    @Column(name = "phone_number")
    private String phoneNumber;
}
