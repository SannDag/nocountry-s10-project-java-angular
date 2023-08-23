package s1014ftjavaangular.userservice.domain.usecase;

import s1014ftjavaangular.userservice.domain.model.dto.request.UserRequest;
import s1014ftjavaangular.userservice.domain.model.dto.response.UserResponse;

public interface UpdateUserUseCase {
    public UserResponse updateUser(UserRequest request);
}
