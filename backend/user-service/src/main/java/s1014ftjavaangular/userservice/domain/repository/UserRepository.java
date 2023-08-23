package s1014ftjavaangular.userservice.domain.repository;

import s1014ftjavaangular.userservice.domain.models.dto.request.UserSaveMessage;
import s1014ftjavaangular.userservice.domain.models.dto.response.UserResponse;
import s1014ftjavaangular.userservice.domain.models.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository  {

    List<UserResponse> findAll();
    List<UserResponse> findAllByType(String type);
    List<UserResponse> findById(String id);
    void saveUser(final UserSaveMessage dto);
}
