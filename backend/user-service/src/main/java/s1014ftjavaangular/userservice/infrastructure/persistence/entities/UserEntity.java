package s1014ftjavaangular.userservice.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import s1014ftjavaangular.userservice.domain.models.enums.CivilState;
import s1014ftjavaangular.userservice.domain.models.enums.Genre;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class UserEntity implements Serializable {

        @Id
        @Column(name = "user_id")
        private String userId;

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

        @OneToMany(targetEntity = PhoneDetailsEntity.class, cascade = CascadeType.ALL)
        @JoinColumn(name = "user_id", referencedColumnName = "user_id")
        private List<PhoneDetailsEntity> phoneDetails;

        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "residence_id")
        private ResidenceDetailsEntity residenceDetails;

        @Column(name = "blacklist")
        private Boolean blackList;
}
