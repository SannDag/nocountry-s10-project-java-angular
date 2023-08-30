package s1014ftjavaangular.loansapplication.infrastructure.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import s1014ftjavaangular.loansapplication.domain.model.dto.request.GeneralDataDto;
import s1014ftjavaangular.loansapplication.domain.usecase.SaveGeneralDataUseCase;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/generaldata")
public class SaveGeneralDataController {

    private final SaveGeneralDataUseCase useCase;

    @PostMapping
    private ResponseEntity<?> saveGeneralData(@Valid @RequestBody GeneralDataDto request){
        try {
            useCase.saveGeneralData(request);
            return ResponseEntity.ok("General data saved successfully.");
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error while saving General data " + e.getMessage());
        }
    }
}
