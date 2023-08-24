package s1014ftjavaangular.userservice.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import s1014ftjavaangular.userservice.domain.model.dto.response.UserResponse;
import s1014ftjavaangular.userservice.domain.repository.UserRepository;
import s1014ftjavaangular.userservice.domain.usecase.UserListFindAllUseCase;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserListFindAllUseCaseImpl implements UserListFindAllUseCase {

    private final UserRepository userRepository;

    @Override
    public List<UserResponse> findAll() {
        List<UserResponse> userDto = userRepository.findAll();

        return userDto;
    }




}
