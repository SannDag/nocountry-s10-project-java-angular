package s1014ftjavaangular.userservice.domain.models.mapper;

import org.springframework.stereotype.Component;
import s1014ftjavaangular.userservice.domain.models.dto.request.UserRequest;
import s1014ftjavaangular.userservice.domain.models.dto.response.UserResponse;
import s1014ftjavaangular.userservice.domain.models.entity.User;
import s1014ftjavaangular.userservice.domain.models.entity.UserEntity;

@Component
public class UserMapper {

    public User updateToEntity(UserRequest request) {
        return User.builder()
                .id(request.getId())
                .identifier(request.getIdentifier())
                .number(request.getNumber())
                .type(request.getType())
                .genre(request.getGenre())
                .name(request.getName())
                .lastName(request.getLastName())
                .civilState(request.getCivilState())
                .birthDay(request.getBirthDay())
                .phoneDetails(request.getPhoneDetails())
                .blackList(request.getBlackList())
                .build();
    }

    public UserResponse entityToModel(UserEntity userEntity){
        return UserResponse.builder()
                .id(userEntity.getId())
                .identifier(userEntity.getIdentifier())
                .number(userEntity.getNumber())
                .type(userEntity.getType())
                .genre(userEntity.getGenre())
                .name(userEntity.getName())
                .lastName(userEntity.getLastName())
                .civilState(userEntity.getCivilState())
                .birthDay(userEntity.getBirthDay())
                .phoneDetails(userEntity.getPhoneDetails())
                .blackList(userEntity.getBlackList())
                .build();
    }
}
