package s1014ftjavaangular.userservice.domain.models.entity;

import jakarta.persistence.*;
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
@Entity(name = "users")
public class UserEntity {
        @Id
        @Column(name = "id_user")
        private String id;

        @Column(name = "identifier")
        private String identifier;

        @Column(name = "number")
        private String number;

        @Column(name = "type")
        private String type;

        @Enumerated(EnumType.STRING)
        @Column(name = "genre", columnDefinition = "enum('MALE', 'FEMALE', 'OTHER')")
        private Genre genre;

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
