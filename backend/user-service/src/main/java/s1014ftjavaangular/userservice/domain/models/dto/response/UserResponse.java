package s1014ftjavaangular.userservice.domain.models.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import s1014ftjavaangular.userservice.domain.models.entity.Genre;
import s1014ftjavaangular.userservice.domain.models.enums.CivilState;
import s1014ftjavaangular.userservice.domain.models.entity.PhoneDetails;

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
    private CivilState civilState;
    private LocalDate birthDay;
    private List<PhoneDetails> phoneDetails;
    private Boolean blackList;
}
