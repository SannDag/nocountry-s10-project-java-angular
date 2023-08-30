package s1014ftjavaangular.loansapplication.infrastructure.persistence.repository.GeneralData;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import s1014ftjavaangular.loansapplication.domain.model.dto.request.GeneralDataDto;
import s1014ftjavaangular.loansapplication.domain.repository.GeneralDataRepository;
import s1014ftjavaangular.loansapplication.infrastructure.persistence.entities.GeneralDataEntity;

import java.util.function.Function;

@Repository
@RequiredArgsConstructor
public class GeneralDataRepositoryAdapter implements GeneralDataRepository{
    private final GeneralDataJpaRepository jpaRepository;

    private final Function<GeneralDataDto, GeneralDataEntity> modelToEntity = (dto) -> {
        GeneralDataEntity entity = new GeneralDataEntity();
        entity.setLoanApplicationId(dto.getLoanApplicationId());
        entity.setHousingStatus(dto.getHousingStatus());
        entity.setYearsInHouse(dto.getYearsInHouse());
        entity.setMonthsInHouse(dto.getMonthsInHouse());
        entity.setCity(dto.getCity());
        entity.setState(dto.getState());
        entity.setAddress(dto.getAddress());
        entity.setApartment(dto.getApartment());
        entity.setZipcode(dto.getZipcode());

        return entity;
    };

    @Override
    public void saveGeneralData(GeneralDataDto dto) {
        if(dto == null) throw new IllegalArgumentException("The general data cannot be empty");

        jpaRepository.save(modelToEntity.apply(dto));

    }


}
