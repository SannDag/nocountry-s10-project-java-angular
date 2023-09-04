package s1014ftjavaangular.userservice.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import s1014ftjavaangular.userservice.domain.model.dto.request.AccountCreatedDto;
import s1014ftjavaangular.userservice.domain.model.entity.User;
import s1014ftjavaangular.userservice.domain.repository.UserRepository;
import s1014ftjavaangular.userservice.domain.usecase.CreateUserUseCase;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class CreateUserUseCaseImpl implements CreateUserUseCase {
    private final UserRepository repository;

    @Override
    public void saveUser(AccountCreatedDto message){
        var lastUserNumber = repository.findLastUserNumber(message.getAccountRol());
        Integer actualYear = LocalDate.now().getYear();
        var nextCustomerNumber = getCustomerActualCustomerNumber(lastUserNumber);
        String customerNumber = actualYear+"-"+nextCustomerNumber;

        var model = User.builder()
                .id(message.getAccountUuid())
                .name(message.getName())
                .lastName(message.getLastname())
                .type(message.getAccountRol())
                .number(customerNumber)
                .blackList(false)
                .build();

        repository.saveUser(model);
    }

    private String getCustomerActualCustomerNumber(String lastUserNumber) {

        if (lastUserNumber == null || lastUserNumber.isEmpty()) {
            return "1";
        } else {
            int separatorIndex = lastUserNumber.indexOf("-");

            if (separatorIndex != -1 && separatorIndex + 1 < lastUserNumber.length()) {
                String numeration = lastUserNumber.substring(separatorIndex + 1);
                int number = Integer.parseInt(numeration.trim());
                number++;
                return String.valueOf(number);
            } else {
                return "1";
            }
        }
    }
}
