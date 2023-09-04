package s1014ftjavaangular.loansapplication.infrastructure.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import s1014ftjavaangular.loansapplication.domain.model.dto.request.LoanApplicationDto;
import s1014ftjavaangular.loansapplication.domain.usecase.FindByIdLoanAppUseCase;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/loanapplication")
public class LoanAppFindByIdController {
    private final FindByIdLoanAppUseCase useCase;

    @GetMapping("/{id}")
    public ResponseEntity<LoanApplicationDto> getAllById(@PathVariable String id){
        var response = useCase.findById(id);

        return response == null
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(response);
    }
}
