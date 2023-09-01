package s1014ftjavaangular.loansapplication.infrastructure.persistence.repository.GeneralData;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import s1014ftjavaangular.loansapplication.domain.model.entity.GeneralData;
import s1014ftjavaangular.loansapplication.domain.repository.GeneralDataRepository;
import s1014ftjavaangular.loansapplication.infrastructure.persistence.entities.GeneralDataEntity;

import java.util.function.Function;

@Repository
@RequiredArgsConstructor
public class GeneralDataRepositoryAdapter implements GeneralDataRepository{
    private final GeneralDataJpaRepository jpaRepository;

    private final Function<GeneralData, GeneralDataEntity> modelToEntity = (model) -> {
        GeneralDataEntity entity = new GeneralDataEntity();
        entity.setLoanApplicationId(model.getLoanApplicationId());
        entity.setHousingStatus(model.getHousingStatus());
        entity.setYearsInHouse(model.getYearsInHouse());
        entity.setMonthsInHouse(model.getMonthsInHouse());
        entity.setCity(model.getCity());
        entity.setState(model.getState());
        entity.setAddress(model.getAddress());
        entity.setApartment(model.getApartment());
        entity.setZipcode(model.getZipcode());

        return entity;
    };

    @Override
    public void saveGeneralData(GeneralData model) {
        if(model == null) throw new IllegalArgumentException("The general data cannot be empty");

        jpaRepository.save(modelToEntity.apply(model));

    }


}
