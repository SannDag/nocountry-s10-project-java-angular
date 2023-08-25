package s1014ftjavaangular.loansapplication.domain.model.entity;

import lombok.Builder;
import lombok.Data;
import s1014ftjavaangular.loansapplication.domain.model.enums.IdentificationType;

@Data
@Builder
public class Guarantor {

    private String guarantorId;
    private String name;
    private String lastname;
    private IdentificationType identificationType;
    private String identification;
    private String city;
    private String state;
    private String address1;
    private String address2;
    private String zipcode;
    private String phone1;
    private String phone2;
}
