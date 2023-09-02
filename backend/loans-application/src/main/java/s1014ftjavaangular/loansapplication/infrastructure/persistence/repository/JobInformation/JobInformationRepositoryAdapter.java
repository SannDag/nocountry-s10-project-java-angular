package s1014ftjavaangular.loansapplication.infrastructure.persistence.repository.JobInformation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import s1014ftjavaangular.loansapplication.domain.model.entity.JobInformation;
import s1014ftjavaangular.loansapplication.domain.repository.JobInformationRepository;
import s1014ftjavaangular.loansapplication.infrastructure.persistence.entities.JobInformationEntity;
import s1014ftjavaangular.loansapplication.infrastructure.persistence.entities.LoanApplicationEntity;
import s1014ftjavaangular.loansapplication.infrastructure.persistence.repository.LoanApplication.LoanApplicationJpaRepository;

import java.util.Optional;
import java.util.function.Function;

@Repository
@AllArgsConstructor
public class JobInformationRepositoryAdapter implements JobInformationRepository {
    private final JobInformationJpaRepository jpaRepository;
    private final LoanApplicationJpaRepository loanApplicationJpaRepository;

    private final Function<JobInformation, JobInformationEntity> modelToEntity = (model) -> {
        JobInformationEntity entity = new JobInformationEntity();
        entity.setLoanApplicationId(model.getLoanApplicationId());
        entity.setCompany(model.getCompany());
        entity.setOccupation(model.getOccupation());
        entity.setYearsInCompany(model.getYearsInCompany());
        entity.setMonthlyIncome(model.getMonthlyIncome());
        entity.setCity(model.getCity());
        entity.setState(model.getState());
        entity.setAddress(model.getAddress());
        entity.setApartment(model.getApartment());
        entity.setZipcode(model.getZipcode());
        entity.setPhone(model.getPhone());

        return entity;
    };

    private final Function<JobInformationEntity, JobInformation> entityToModel = (model) -> new JobInformation(
            model.getLoanApplicationId(),
            model.getCompany(),
            model.getOccupation(),
            model.getWorkShift(),
            model.getYearsInCompany(),
            model.getMonthlyIncome(),
            model.getOtherIncome(),
            model.getCity(),
            model.getState(),
            model.getAddress(),
            model.getApartment(),
            model.getZipcode(),
            model.getPhone()

    );

    @Override
    public void saveJobInformation(JobInformation model) {
        if(model == null) throw new IllegalArgumentException("The request cannot be empty");

        Optional<LoanApplicationEntity> loanApplication = loanApplicationJpaRepository.findById(model.getLoanApplicationId());

        if (!loanApplication.isPresent()) {
            throw new IllegalArgumentException("Loan application not found");
        }

        jpaRepository.save(modelToEntity.apply(model));

    }
}