package s1014ftjavaangular.userservice.infrastructure.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import s1014ftjavaangular.userservice.domain.model.dto.request.UserRequest;
import s1014ftjavaangular.userservice.domain.model.dto.response.UserResponse;
import s1014ftjavaangular.userservice.domain.usecase.UpdateUserUseCase;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/users/")
public class UpdateUserController {
    private final UpdateUserUseCase useCase;

    @PutMapping("updateUser")
    private ResponseEntity<UserResponse> updateUser(@Valid @RequestBody UserRequest request){
        UserResponse response = useCase.updateUser(request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
