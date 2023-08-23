package s1014ftjavaangular.userservice.domain.usecase;

import s1014ftjavaangular.userservice.domain.model.dto.request.UserSaveMessage;

public interface CreateUserUseCase {
    void saveUser(UserSaveMessage message);
}
