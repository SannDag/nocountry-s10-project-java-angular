package s1014ftjavaangular.userservice.application;

import org.springframework.stereotype.Service;
import s1014ftjavaangular.userservice.domain.models.dto.request.UserRequest;
import s1014ftjavaangular.userservice.domain.models.dto.response.UserResponse;
import s1014ftjavaangular.userservice.domain.usecase.UpdateUserUseCase;

@Service
public class UpdateUserUseCaseImpl implements UpdateUserUseCase {
    @Override
    public UserResponse updateUser(UserRequest request) {
        return null;
    }
}
