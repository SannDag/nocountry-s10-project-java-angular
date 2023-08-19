package s1014ftjavaangular.security.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import s1014ftjavaangular.security.domain.enums.Rol;
import s1014ftjavaangular.security.domain.model.dto.RegisterCustomer;
import s1014ftjavaangular.security.domain.model.entities.Account;
import s1014ftjavaangular.security.domain.repository.AccountRepositoryPort;
import s1014ftjavaangular.security.domain.usecase.RegisterAccountUseCase;

@Component
@RequiredArgsConstructor
public class RegisterAccountUseCaseImpl implements RegisterAccountUseCase {
    private final AccountRepositoryPort repository;

    @Override
    public Account createCustomer(RegisterCustomer registerCustomer){

        String email = registerCustomer.getEmail();
        String password = registerCustomer.getPassword();

        var savedAccount = repository.registerAccount(email, password, Rol.CUSTOMER);

        return savedAccount;
    }

}
