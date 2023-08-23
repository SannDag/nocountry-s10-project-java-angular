package s1014ftjavaangular.userservice.application;

import lombok.RequiredArgsConstructor;
import s1014ftjavaangular.userservice.domain.models.dto.request.UserSaveMessage;
import s1014ftjavaangular.userservice.domain.repository.UserRepository;
import s1014ftjavaangular.userservice.domain.usecase.CreateUserUseCase;

@RequiredArgsConstructor
public class CreateUserUseCaseImpl implements CreateUserUseCase {
    private final UserRepository repository;

    @Override
    public void saveUser(UserSaveMessage message){
        repository.saveUser(message);
    }
}
