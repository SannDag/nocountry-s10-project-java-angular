package s1014ftjavaangular.userservice.infrastructure.persistence.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import s1014ftjavaangular.userservice.domain.model.dto.request.UserRequest;
import s1014ftjavaangular.userservice.domain.model.entity.User;
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
        @Column(name = "identifier_number")
        private String identifierNumber;

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

        @Column(name = "birth_day")
        private LocalDate birthDay;

        @Column(name = "phone")
        private String phone;

        @Column(name = "nationality")
        private String nationality;

        @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
        private ResidenceDetailsEntity residenceDetails;

        @Column(name = "blacklist")
        private Boolean blackList;


        public static UserEntity modelToEntity(User model){
                var entity = new UserEntity();
                entity.setUserUuid(model.getId());
                entity.setIdentifier(model.getIdentifier());
                entity.setIdentifierNumber(model.getIdentifierNumber());
                entity.setNumber(model.getNumber());
                entity.setType(model.getType());
                entity.setGenre(model.getGenre());
                entity.setName(model.getName());
                entity.setLastName(model.getLastName());
                entity.setBirthDay(model.getBirthDay());
                entity.setPhone(model.getPhone());
                entity.setNationality(model.getNationality());
                entity.setBlackList(model.getBlackList());

          return entity;
        }

        public User entityToModel(){
                return User.builder()
                        .id(this.getUserUuid())
                        .number(this.getNumber())
                        .identifier(this.getIdentifier())
                        .identifierNumber(this.getIdentifierNumber())
                        .type(this.getType())
                        .name(this.getName())
                        .lastName(this.getLastName())
                        .genre(this.getGenre())
                        .birthDay(this.getBirthDay())
                        .nationality(this.getNationality())
                        .phone(this.getPhone())
                        .blackList(this.getBlackList())
                        .residenceDetails(this.getResidenceDetails().entityToModel())
                        .build();
        }
}
