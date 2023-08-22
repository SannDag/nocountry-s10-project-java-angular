package s1014ftjavaangular.userservice.domain.models.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import s1014ftjavaangular.userservice.domain.models.enums.CivilState;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
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
