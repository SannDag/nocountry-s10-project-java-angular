package s1014ftjavaangular.loansapplication.application;

import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import s1014ftjavaangular.loansapplication.domain.model.dto.request.LoanApplicationDto;
import s1014ftjavaangular.loansapplication.domain.model.entity.LoanApplication;
import s1014ftjavaangular.loansapplication.domain.repository.LoanApplicationRepository;
import s1014ftjavaangular.loansapplication.domain.usecase.FindByIdLoanAppUseCase;

import java.util.function.Function;
@RequiredArgsConstructor
@Service
public class findByIdLoanAppUseCaseImpl implements FindByIdLoanAppUseCase {

    private final LoanApplicationRepository repository;

    private final Function<LoanApplication, LoanApplicationDto> entityToModel = (entity) ->
            new LoanApplicationDto(
                    entity.getLoanApplicationId(),
                    entity.getCustomersUuid(),
                    entity.getLoanApplicationNumber(),
                    entity.getRequestedAmount(),
                    entity.getCreateAt(),
                    entity.getJobInformation(),
                    entity.getGuarantor(),
                    entity.getGeneralData(),
                    entity.getCreditAuditorId(),
                    entity.getStatus()
            );

    private final Function<LoanApplicationDto, LoanApplication> modelToEntity = (dto) -> {
        LoanApplication entity = new LoanApplication();
        entity.setLoanApplicationId(dto.getLoanApplicationId());
        entity.setCustomersUuid(dto.getCustomersUuid());
        entity.setLoanApplicationNumber(dto.getLoanApplicationNumber());
        entity.setRequestedAmount(dto.getRequestedAmount());
        entity.setCreateAt(dto.getCreateAt());
        entity.setJobInformation(dto.getJobInformation());
        entity.setGuarantor(dto.getGuarantor());
        entity.setGeneralData(dto.getGeneralData());
        entity.setCreditAuditorId(dto.getCreditAuditorId());
        entity.setStatus(dto.getStatus());

        return entity;

    };

    @Override
    public LoanApplicationDto findById(String id) {
        LoanApplication entity = repository.findById(id);
        if(entity == null){
            throw new NotFoundException("Loan Application was not found");
        } else {
            return entityToModel.apply(entity);
        }
    }
}
