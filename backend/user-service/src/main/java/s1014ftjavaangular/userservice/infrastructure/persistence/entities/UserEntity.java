package s1014ftjavaangular.userservice.infrastructure.persistence.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import s1014ftjavaangular.userservice.domain.model.dto.request.UserRequest;
import s1014ftjavaangular.userservice.domain.model.enums.CivilStatus;
import s1014ftjavaangular.userservice.domain.model.enums.Genre;
import s1014ftjavaangular.userservice.domain.model.mapper.UserMapper;


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
        private String userUuid;

        @Column(name = "identifier")
        private String identifier;

        @Column(name = "number")
        private String number;

        @Column(name = "type")
        private String type;

        @Enumerated(EnumType.STRING)
        @Column(name = "genre")
        private Genre genre;

        @Column(name = "name")
        private String name;

        @Column(name = "last_name")
        private String lastName;

        @Column(name = "civil_state")
        private CivilStatus civilStatus;

        @Column(name = "birth_day")
        private LocalDate birthDay;

        @JsonBackReference
        @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<PhoneDetailsEntity> phoneDetails;

        @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
        private ResidenceDetailsEntity residenceDetails;

        @Column(name = "blacklist")
        private Boolean blackList;
}
