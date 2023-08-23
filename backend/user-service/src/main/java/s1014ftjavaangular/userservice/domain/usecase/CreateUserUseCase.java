package s1014ftjavaangular.userservice.domain.usecase;

import s1014ftjavaangular.userservice.domain.models.dto.request.UserSaveMessage;

public interface CreateUserUseCase {
    void saveUser(UserSaveMessage message);
}
