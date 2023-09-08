package s1014ftjavaangular.userservice.infrastructure.controller;

import io.github.resilience4j.retry.annotation.Retry;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import s1014ftjavaangular.userservice.domain.model.dto.request.UserRequest;
import s1014ftjavaangular.userservice.domain.usecase.UpdateUserUseCase;


@Slf4j
@RequestMapping("/api/v1/users")
@RestController
public class UpdateUserController {

    private final UpdateUserUseCase updUser;

    @Autowired
    public UpdateUserController(UpdateUserUseCase updateUser){
        this.updUser = updateUser;
    }

    @Retry(name = "userRetry")
    @PutMapping()
    private HttpEntity<Void> userUpdate(@Valid @RequestBody UserRequest request){
        log.info("ENTRE AL METODO");
        log.info("Request: {}",request);

        this.updUser.update(request);

        return ResponseEntity.noContent().build();
    }
}
