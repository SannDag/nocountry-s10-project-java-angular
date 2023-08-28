package s1014ftjavaangular.loansapplication.domain.model.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ParentsReferences {

    private String loansApplicationId;
    private String spousesName;
    private String spousesPhone;
    private String familyName;
    private String familyPhone;

}
