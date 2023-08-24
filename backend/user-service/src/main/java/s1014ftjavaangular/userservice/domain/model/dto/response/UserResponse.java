package s1014ftjavaangular.userservice.domain.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import s1014ftjavaangular.userservice.domain.model.entity.ResidenceDetails;
import s1014ftjavaangular.userservice.domain.model.enums.Genre;
import s1014ftjavaangular.userservice.domain.model.enums.CivilStatus;
import s1014ftjavaangular.userservice.domain.model.entity.PhoneDetails;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
    private String id;
    private String identifier;
    private String number;
    private String type;
    private Genre genre;
    private String name;
    private String lastName;
    private CivilStatus civilStatus;
    private LocalDate birthDay;
    private List<PhoneDetails> phoneDetails;
    private ResidenceDetails residenceDetails;
    private Boolean blackList;
}
