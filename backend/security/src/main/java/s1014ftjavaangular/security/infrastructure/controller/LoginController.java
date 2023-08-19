package s1014ftjavaangular.security.infrastructure.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import s1014ftjavaangular.security.domain.usecase.LoginUseCase;

@RestController("/api/accounts/login")
@RequiredArgsConstructor
public class LoginController {
    private final LoginUseCase loginUseCase;

    @PostMapping()
    public ResponseEntity<?> login(){


        return ResponseEntity.ok().build();
    }
}
