package s1014ftjavaangular.loansapplication.infrastructure.persistence.repository.JobInformation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import s1014ftjavaangular.loansapplication.domain.model.dto.request.JobInformationDto;
import s1014ftjavaangular.loansapplication.domain.repository.JobInformationRepository;
import s1014ftjavaangular.loansapplication.infrastructure.persistence.repository.LoanApplication.LoanApplicationFormJpaRepository;

@Repository
@AllArgsConstructor
public class JobInformationrepositoryAdapter implements JobInformationRepository {
    private final JobInformationJpaRepository jpaRepository;

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
        if(dto.getPhone() != null) entity.setPhone(dto.getPhone());
    }
}
