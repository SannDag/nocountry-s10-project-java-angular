package s1014ftjavaangular.userservice.domain.repository;

import s1014ftjavaangular.userservice.domain.model.dto.request.AccountCreatedDto;
import s1014ftjavaangular.userservice.domain.model.dto.response.UserResponse;

import java.util.List;

public interface UserRepository  {

    List<UserResponse> findAll();
    List<UserResponse> findAllByType(String type);
    List<UserResponse> findById(String id);
    void saveUser(final AccountCreatedDto dto);
}
