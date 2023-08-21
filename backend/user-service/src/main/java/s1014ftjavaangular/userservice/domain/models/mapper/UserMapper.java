package s1014ftjavaangular.userservice.domain.models.mapper;

import s1014ftjavaangular.userservice.domain.models.dto.request.UserRequest;
import s1014ftjavaangular.userservice.domain.models.entity.User;

public class UserMapper {

    public User updateToEntity(UserRequest request) {
        return User.builder()
                .id(request.getId())
                .identifier(request.getIdentifier())
                .number(request.getNumber())
                .type(request.getType())
                .sex(request.getSex())
                .name(request.getName())
                .lastName(request.getLastName())
                .civilState(request.getCivilState())
                .birthDay(request.getBirthDay())
                .phoneDetails(request.getPhoneDetails())
                .blackList(request.getBlackList())
                .build();
    }
}
