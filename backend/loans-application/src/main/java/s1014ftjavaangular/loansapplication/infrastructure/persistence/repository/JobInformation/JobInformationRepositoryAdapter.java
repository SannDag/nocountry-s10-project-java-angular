package s1014ftjavaangular.loansapplication.infrastructure.persistence.repository.JobInformation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import s1014ftjavaangular.loansapplication.domain.model.dto.request.JobInformationDto;
import s1014ftjavaangular.loansapplication.domain.repository.JobInformationRepository;
import s1014ftjavaangular.loansapplication.infrastructure.persistence.entities.JobInformationEntity;
import s1014ftjavaangular.loansapplication.infrastructure.persistence.repository.LoanApplication.LoanApplicationJpaRepository;

import java.util.function.Function;

@Repository
@AllArgsConstructor
public class JobInformationRepositoryAdapter implements JobInformationRepository {
    private final JobInformationJpaRepository jpaRepository;

    private final Function<JobInformationDto, JobInformationEntity> modelToEntity = (dto) -> {
        JobInformationEntity entity = new JobInformationEntity();
        entity.setLoanApplicationId(dto.getLoanApplicationId());
        entity.setCompany(dto.getCompany());
        //falta rubro empresa segun dashboard
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

    private final Function<JobInformationEntity, JobInformationDto> entityToModel = (entity) -> new JobInformationDto(
            //falta rubro empresa segun dashboard
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

    @Transactional
    @Override
    public void updateJobInformation(JobInformationDto dto) {
        if(dto == null) throw new IllegalArgumentException("The request cannot be empty");
        var isJobInformationExists = jpaRepository.ExistsByUuid(dto.getLoanApplicationId());
        if(!isJobInformationExists) throw new RuntimeException("Job Information does not exists");

        var entity = jpaRepository.findById(dto.getLoanApplicationId()).get();

        if(dto.getLoanApplicationId() != null) entity.setLoanApplicationId(dto.getLoanApplicationId());
        if(dto.getCompany() != null) entity.setCompany(dto.getCompany());
        if(dto.getOccupation() != null) entity.setOccupation(dto.getOccupation());
        if(dto.getWorkShift() != null) entity.setWorkShift(dto.getWorkShift());
        if(dto.getYearsInCompany() != null) entity.setYearsInCompany(dto.getYearsInCompany());
        if(dto.getMonthlyIncome() != null) entity.setMonthlyIncome(dto.getMonthlyIncome());
        if(dto.getOtherIncome() != null) entity.setOtherIncome(dto.getOtherIncome());
        if(dto.getCity() != null)  entity.setCity(dto.getCity());
        if(dto.getState() != null) entity.setState(dto.getState());
        if(dto.getAddress() != null) entity.setAddress(dto.getAddress());
        if(dto.getApartment() != null) entity.setApartment(dto.getApartment());
        if(dto.getZipcode() != null) entity.setZipcode(dto.getZipcode());
        if(dto.getPhone() != null) entity.setPhone(dto.getPhone());
    }

    @Override
    public void saveJobInformation(JobInformationDto dto) {
        if(dto == null) throw new IllegalArgumentException("The request cannot be empty");

        jpaRepository.save(modelToEntity.apply(dto));

    }
}