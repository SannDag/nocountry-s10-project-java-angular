package s1014ftjavaangular.userservice.domain.models.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PhoneDetails {
    private UUID id;
    private String label;
    private String countryCode;
    private String cityCode;
    private String phoneNumber;
}
