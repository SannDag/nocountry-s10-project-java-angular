package s1014ftjavaangular.userservice.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import s1014ftjavaangular.userservice.domain.model.Exception.UserNotFoundException;
import s1014ftjavaangular.userservice.domain.model.dto.response.UserResponse;
import s1014ftjavaangular.userservice.domain.repository.UserRepository;
import s1014ftjavaangular.userservice.domain.usecase.UserListByTypeUseCase;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserListFindByTypeUseCaseImpl implements UserListByTypeUseCase {

    private final UserRepository userRepository;

    @Override
    public List<UserResponse> findAllByType(String type) {
        List<UserResponse> userDto = userRepository.findAllByType(type);
        if(userDto.isEmpty()){
            throw new UserNotFoundException("The user was not found");
        }

        return userDto;

    }
}
