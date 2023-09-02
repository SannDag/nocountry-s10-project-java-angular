package s1014ftjavaangular.loansapplication.infrastructure.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import s1014ftjavaangular.loansapplication.domain.model.dto.request.GuarantorDto;
import s1014ftjavaangular.loansapplication.domain.model.dto.request.JobInformationDto;
import s1014ftjavaangular.loansapplication.domain.model.entity.LoansApplication;
import s1014ftjavaangular.loansapplication.domain.usecase.UpdateGuarantorUseCase;
import s1014ftjavaangular.loansapplication.domain.usecase.UpdateJobInformationUseCase;
import s1014ftjavaangular.loansapplication.domain.usecase.UpdateStatusUseCase;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/loanapplication")
public class UpdateLoanApplicationController {
    private final UpdateStatusUseCase updateStatusUseCase;
    private final UpdateJobInformationUseCase updateJobInformationUseCase;
    private final UpdateGuarantorUseCase updateGuarantorUseCase;

    @PutMapping("/jobinformation")
    private ResponseEntity<JobInformationDto> updateJobInformation(@Valid @RequestBody JobInformationDto request){
        updateJobInformationUseCase.updateJobInformation(request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/status")
    private ResponseEntity<LoansApplication> updateStatus(@Valid @RequestBody LoansApplication request){
        updateStatusUseCase.updateStatus(request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/guarantor")
    private ResponseEntity<GuarantorDto> updateGuarantor(@Valid @RequestBody GuarantorDto request){
        updateGuarantorUseCase.updateGuarantor(request);
        return ResponseEntity.ok().build();
    }
}
