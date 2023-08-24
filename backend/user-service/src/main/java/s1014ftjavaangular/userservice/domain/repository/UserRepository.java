package s1014ftjavaangular.userservice.domain.repository;

import s1014ftjavaangular.userservice.domain.model.dto.request.AccountCreatedDto;
import s1014ftjavaangular.userservice.domain.model.dto.response.UserResponse;

import java.util.List;
import java.util.Optional;

public interface UserRepository  {

    List<UserResponse> findAll();
    List<UserResponse> findAllByType(String type);
    Optional<UserResponse> findById(String id);
    void saveUser(final AccountCreatedDto dto);
}
