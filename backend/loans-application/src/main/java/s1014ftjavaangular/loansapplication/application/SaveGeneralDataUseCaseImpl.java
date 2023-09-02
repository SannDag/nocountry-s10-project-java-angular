package s1014ftjavaangular.loansapplication.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import s1014ftjavaangular.loansapplication.domain.model.dto.request.GeneralDataDto;
import s1014ftjavaangular.loansapplication.domain.model.entity.GeneralData;
import s1014ftjavaangular.loansapplication.domain.model.entity.LoanApplication;
import s1014ftjavaangular.loansapplication.domain.repository.GeneralDataRepository;
import s1014ftjavaangular.loansapplication.domain.repository.LoanApplicationRepository;
import s1014ftjavaangular.loansapplication.domain.usecase.SaveGeneralDataUseCase;

import java.util.UUID;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class SaveGeneralDataUseCaseImpl implements SaveGeneralDataUseCase {

    private final GeneralDataRepository generalDataRepository;
    private final LoanApplicationRepository loanApplicationRepository;

    private final Function<GeneralData, GeneralDataDto> entityToModel = (entity) -> (
            new GeneralDataDto(
                    entity.getLoanApplicationId(),
                    entity.getHousingStatus(),
                    entity.getYearsInHouse(),
                    entity.getMonthsInHouse(),
                    entity.getCity(),
                    entity.getState(),
                    entity.getAddress(),
                    entity.getApartment(),
                    entity.getZipcode(),
                    entity.getPhone()
            )
    );

    private final Function<GeneralDataDto, GeneralData> modelToEntity = (dto) -> {
        GeneralData entity = new GeneralData();
        entity.setLoanApplicationId(dto.getLoanApplicationId());
        entity.setHousingStatus(dto.getHousingStatus());
        entity.setYearsInHouse(dto.getYearsInHouse());
        entity.setMonthsInHouse(dto.getMonthsInHouse());
        entity.setCity(dto.getCity());
        entity.setState(dto.getState());
        entity.setAddress(dto.getAddress());
        entity.setApartment(dto.getApartment());
        entity.setZipcode(dto.getZipcode());
        entity.setPhone(dto.getPhone());

        return entity;
    };

    @Override
    public String saveGeneralData(GeneralDataDto request) {
        var loanApplication = LoanApplication.builder()
                .loanApplicationId(UUID.randomUUID().toString())
                // To Do
                .build();

        loanApplicationRepository.saveLoanApplication(loanApplication);
        generalDataRepository.saveGeneralData(modelToEntity.apply(request));

        return loanApplication.getLoanApplicationId();
    }
}
