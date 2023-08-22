package s1014ftjavaangular.userservice.domain.models.entity;

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
@Entity(name = "users")
public class User {
    @Id
    @Column(name = "id_user")
    private UUID id;

    @Column(name = "identifier")
    private String identifier;

    @Column(name = "number")
    private String number;

    @Column(name = "type")
    private String type;

    @Enumerated(EnumType.STRING)
    @Column(name = "sex", columnDefinition = "enum('MALE', 'FEMALE', 'OTHER')")
    private Sex sex;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "civil_state")
    private CivilState civilState;

    @Column(name = "birth_day")
    private LocalDate birthDay;

    @OneToMany
    private List<PhoneDetails> phoneDetails;

    @Column(name = "blacklist")
    private Boolean blackList;
}
