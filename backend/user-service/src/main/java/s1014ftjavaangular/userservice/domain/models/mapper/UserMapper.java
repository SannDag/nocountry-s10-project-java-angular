package s1014ftjavaangular.userservice.domain.models.mapper;

import org.springframework.stereotype.Component;
import s1014ftjavaangular.userservice.domain.models.dto.request.UserRequest;
import s1014ftjavaangular.userservice.domain.models.dto.response.UserResponse;
import s1014ftjavaangular.userservice.domain.models.entity.PhoneDetails;
import s1014ftjavaangular.userservice.domain.models.entity.ResidenceDetails;
import s1014ftjavaangular.userservice.domain.models.entity.User;
import s1014ftjavaangular.userservice.infrastructure.persistence.entities.PhoneDetailsEntity;
import s1014ftjavaangular.userservice.infrastructure.persistence.entities.ResidenceDetailsEntity;
import s1014ftjavaangular.userservice.infrastructure.persistence.entities.UserEntity;

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
                .id(userEntity.getUserId())
                .identifier(userEntity.getIdentifier())
                .number(userEntity.getNumber())
                .type(userEntity.getType())
                .genre(userEntity.getGenre())
                .name(userEntity.getName())
                .lastName(userEntity.getLastName())
                .civilState(userEntity.getCivilState())
                .birthDay(userEntity.getBirthDay())
                .residenceDetails(residenceEntityToModel(userEntity.getResidenceDetails()))
                .phoneDetails(userEntity.getPhoneDetails().stream().map(this::phoneDetailsEntityToModel).toList())
                .blackList(userEntity.getBlackList())
                .build();
    }

    public ResidenceDetails residenceEntityToModel(ResidenceDetailsEntity residenceDetailsEntity){
        return ResidenceDetails.builder()
                .residenceUuid(residenceDetailsEntity.getResidenceUuid())
                .state(residenceDetailsEntity.getState())
                .city(residenceDetailsEntity.getCity())
                .housingStatus(residenceDetailsEntity.getHousingStatus())
                .yearsInHouse(residenceDetailsEntity.getYearsInHouse())
                .monthsInHouse(residenceDetailsEntity.getMonthsInHouse())
                .address1(residenceDetailsEntity.getAddress1())
                .address2(residenceDetailsEntity.getAddress2())
                .zipCode(residenceDetailsEntity.getZipCode())
                .build();
    }
    
    public PhoneDetails phoneDetailsEntityToModel(PhoneDetailsEntity phoneDetailsEntity){
        return PhoneDetails.builder()
                .phoneUuid(phoneDetailsEntity.getPhoneUuid())
                .phoneLabel(phoneDetailsEntity.getPhoneLabel())
                .phoneNumber(phoneDetailsEntity.getPhoneNumber())
                .countryCode(phoneDetailsEntity.getCountryCode())
                .cityCode(phoneDetailsEntity.getCityCode())
                .phoneNumber(phoneDetailsEntity.getPhoneNumber())
                .build();
    }
}
