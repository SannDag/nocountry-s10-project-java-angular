package s1014ftjavaangular.loansapplication.domain.model.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonalReferences {

    private String personalReferenceId;
    private String personalReferenceName;
    private String personalReferencePhone;

}
