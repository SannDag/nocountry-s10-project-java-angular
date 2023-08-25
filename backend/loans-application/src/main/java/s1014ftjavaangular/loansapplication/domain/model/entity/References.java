package s1014ftjavaangular.loansapplication.domain.model.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class References {
    private String referencesId;
    private String spousesName;
    private String spousesPhone;
    private String personalReferencesName;
    private String personalReferencesPhone;

}
