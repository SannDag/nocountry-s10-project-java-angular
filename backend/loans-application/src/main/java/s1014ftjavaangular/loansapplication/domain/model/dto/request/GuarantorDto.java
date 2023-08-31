package s1014ftjavaangular.loansapplication.domain.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import s1014ftjavaangular.loansapplication.domain.model.enums.IdentificationType;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GuarantorDto {
    private String loanApplicationId;
    private String name;
    private String lastname;
    private IdentificationType identificationType;
    private String identification;
    private String city;
    private String state;
    private String address;
    private String zipcode;
    private String phone;
}
