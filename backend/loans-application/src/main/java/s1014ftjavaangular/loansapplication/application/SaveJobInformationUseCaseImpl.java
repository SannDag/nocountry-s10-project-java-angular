package s1014ftjavaangular.loansapplication.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import s1014ftjavaangular.loansapplication.domain.model.dto.request.JobInformationDto;
import s1014ftjavaangular.loansapplication.domain.model.entity.JobInformation;
import s1014ftjavaangular.loansapplication.domain.repository.JobInformationRepository;
import s1014ftjavaangular.loansapplication.domain.usecase.SaveJobInformationUseCase;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class SaveJobInformationUseCaseImpl implements SaveJobInformationUseCase {

    private final JobInformationRepository repository;

    private final Function<JobInformationDto, JobInformation> modelToEntity = (dto) -> {
        JobInformation entity = new JobInformation();
        entity.setLoanApplicationId(dto.getLoanApplicationId());
        entity.setCompany(dto.getCompany());
        entity.setOccupation(dto.getOccupation());
        entity.setYearsInCompany(dto.getYearsInCompany());
        entity.setMonthlyIncome(dto.getMonthlyIncome());
        entity.setCity(dto.getCity());
        entity.setState(dto.getState());
        entity.setAddress(dto.getAddress());
        entity.setApartment(dto.getApartment());
        entity.setZipcode(dto.getZipcode());
        entity.setPhone(dto.getPhone());

        return entity;
    };

    private final Function<JobInformation, JobInformationDto> entityToModel = (entity) -> new JobInformationDto(
            entity.getLoanApplicationId(),
            entity.getCompany(),
            entity.getOccupation(),
            entity.getWorkShift(),
            entity.getYearsInCompany(),
            entity.getMonthlyIncome(),
            entity.getOtherIncome(),
            entity.getCity(),
            entity.getState(),
            entity.getAddress(),
            entity.getApartment(),
            entity.getZipcode(),
            entity.getPhone()

    );

    @Override
    public void saveJobInformation(JobInformationDto request) {
        repository.saveJobInformation(modelToEntity.apply(request));
    }
}
