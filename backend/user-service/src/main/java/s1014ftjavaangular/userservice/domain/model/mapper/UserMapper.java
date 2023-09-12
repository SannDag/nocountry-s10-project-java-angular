package s1014ftjavaangular.userservice.domain.model.mapper;

import org.springframework.stereotype.Component;
import s1014ftjavaangular.userservice.domain.model.dto.request.ResidenceDetailsDto;
import s1014ftjavaangular.userservice.domain.model.dto.request.UserRequest;
import s1014ftjavaangular.userservice.domain.model.dto.response.UserResponse;
import s1014ftjavaangular.userservice.domain.model.entity.ResidenceDetails;
import s1014ftjavaangular.userservice.domain.model.entity.User;

@Component
public class UserMapper {

    public User userDtoToModel(UserRequest request) {
        return User.builder()
                .id(request.getId())
                .identifier(request.getIdentifier())
                .identifierNumber(request.getIdentifierNumber())
                .genre(request.getGenre())
                .name(request.getName())
                .lastName(request.getLastName())
                .nationality(request.getNationality())
                .birthDay(request.getBirthDay())
                .phone(request.getPhone())
                .residenceDetails(this.residenceDetailsDtoToModel(request.getResidenceDetails()))
                .build();
    }

    public UserResponse userModelToResponse(User user){
        return UserResponse.builder()
                .id(user.getId())
                .identifier(user.getIdentifier())
                .identifierNumber(user.getIdentifierNumber())
                .genre(user.getGenre())
                .name(user.getName())
                .lastName(user.getLastName())
                .nationality(user.getNationality())
                .birthDay(user.getBirthDay())
                .phone(user.getPhone())
                .residenceDetails(this.residenceDetailsModelToDto(user.getResidenceDetails()))
                .build();
    }

    public ResidenceDetails residenceDetailsDtoToModel(ResidenceDetailsDto residenceDetailsDto){
        return ResidenceDetails.builder()
                .city(residenceDetailsDto.getCity())
                .state(residenceDetailsDto.getState())
                .address(residenceDetailsDto.getAddress())
                .apartment(residenceDetailsDto.getApartment())
                .zipCode(residenceDetailsDto.getZipCode())
                .build();
    }

    public ResidenceDetailsDto residenceDetailsModelToDto(ResidenceDetails residenceDetails){
        return ResidenceDetailsDto.builder()
                .city(residenceDetails.getCity())
                .state(residenceDetails.getState())
                .address(residenceDetails.getAddress())
                .apartment(residenceDetails.getApartment())
                .zipCode(residenceDetails.getZipCode())
                .build();
    }
}
