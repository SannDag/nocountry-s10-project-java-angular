package s1014ftjavaangular.userservice.domain.models.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import s1014ftjavaangular.userservice.domain.models.enums.PhoneLabel;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PhoneDetails {
    private String phoneUuid;
    private PhoneLabel phoneLabel;
    private String countryCode;
    private String cityCode;
    private String phoneNumber;
}
