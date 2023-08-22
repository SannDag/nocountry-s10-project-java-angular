package s1014ftjavaangular.userservice.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import s1014ftjavaangular.userservice.domain.models.Exception.UserNotFoundException;
import s1014ftjavaangular.userservice.domain.models.dto.response.UserResponse;
import s1014ftjavaangular.userservice.domain.repository.UserRepository;
import s1014ftjavaangular.userservice.domain.usecase.UserListByIdUseCase;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserListFindByIdUseCaseImpl implements UserListByIdUseCase {

    private final UserRepository userRepository;

    @Override
    public List<UserResponse> findById(String id) {
        List<UserResponse> userDto = userRepository.findById(id);
        if(userDto.isEmpty()){
            throw new UserNotFoundException("The user was not found");
        }

        return userDto;
    }
}
