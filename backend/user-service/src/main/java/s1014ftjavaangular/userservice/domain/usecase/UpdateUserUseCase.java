package s1014ftjavaangular.userservice.domain.usecase;

import s1014ftjavaangular.userservice.domain.models.dto.request.UserRequest;
import s1014ftjavaangular.userservice.domain.models.dto.response.UserResponse;
import s1014ftjavaangular.userservice.domain.models.entity.User;

public interface UpdateUserUseCase {
    public UserResponse updateUser(UserRequest request);
}
