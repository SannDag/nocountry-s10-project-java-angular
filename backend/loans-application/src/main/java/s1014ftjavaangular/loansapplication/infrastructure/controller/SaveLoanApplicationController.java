package s1014ftjavaangular.loansapplication.infrastructure.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import s1014ftjavaangular.loansapplication.domain.model.dto.request.LoanApplicationDto;
import s1014ftjavaangular.loansapplication.domain.usecase.SaveLoanApplicationUseCase;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/loanapplication")
public class SaveLoanApplicationController {

    private final SaveLoanApplicationUseCase useCase;

    @PostMapping("/save")
    private ResponseEntity<String> saveJobInformation (@Valid @RequestBody LoanApplicationDto request){
        useCase.saveLoanApplication(request);
        return ResponseEntity.ok().build();
    }
}
