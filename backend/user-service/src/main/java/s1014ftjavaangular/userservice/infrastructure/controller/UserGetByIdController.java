package s1014ftjavaangular.userservice.infrastructure.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import s1014ftjavaangular.userservice.domain.model.dto.response.UserResponse;
import s1014ftjavaangular.userservice.domain.usecase.UserListByIdUseCase;

@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
@RestController
public class UserGetByIdController {
    private final UserListByIdUseCase userListByIdUseCase;

    @GetMapping("/id/{id}")
    public ResponseEntity<UserResponse> getAllById(@PathVariable String id){
        var response = userListByIdUseCase.findById(id);

        return response == null
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(response);
    }
}
