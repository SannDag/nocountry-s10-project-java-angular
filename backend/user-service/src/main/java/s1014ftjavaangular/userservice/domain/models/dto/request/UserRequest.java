package s1014ftjavaangular.userservice.domain.models.dto.request;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import s1014ftjavaangular.userservice.domain.models.entity.CivilState;
import s1014ftjavaangular.userservice.domain.models.entity.PhoneDetails;
import s1014ftjavaangular.userservice.domain.models.entity.Sex;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {
    private UUID id;
    private String identifier;
    private String number;
    private String type;
    private Sex sex;
    private String name;
    private String lastName;
    private CivilState civilState;
    private LocalDate birthDay;
    private List<PhoneDetails> phoneDetails;
    private Boolean blackList;
}
