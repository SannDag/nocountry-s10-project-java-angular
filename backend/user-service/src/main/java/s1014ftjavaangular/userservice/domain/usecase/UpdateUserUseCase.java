package s1014ftjavaangular.userservice.domain.usecase;

import s1014ftjavaangular.userservice.domain.model.dto.request.UserRequest;
import s1014ftjavaangular.userservice.domain.model.dto.response.UserResponse;

public interface UpdateUserUseCase {
    void updateUser(UserRequest request);
}
