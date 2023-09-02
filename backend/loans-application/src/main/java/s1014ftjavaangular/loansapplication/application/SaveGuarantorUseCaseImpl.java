package s1014ftjavaangular.loansapplication.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import s1014ftjavaangular.loansapplication.domain.model.dto.request.GuarantorDto;
import s1014ftjavaangular.loansapplication.domain.model.entity.Guarantor;
import s1014ftjavaangular.loansapplication.domain.repository.GuarantorRepository;
import s1014ftjavaangular.loansapplication.domain.usecase.SaveGuarantorUseCase;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class SaveGuarantorUseCaseImpl implements SaveGuarantorUseCase {

    private final GuarantorRepository guarantorRepository;

    private final Function<Guarantor, GuarantorDto> entityToModel = (entity) -> (
            new GuarantorDto(
                    entity.getLoanApplicationId(),
                    entity.getName(),
                    entity.getLastname(),
                    entity.getIdentificationType(),
                    entity.getIdentification(),
                    entity.getCity(),
                    entity.getState(),
                    entity.getAddress(),
                    entity.getApartment(),
                    entity.getZipcode(),
                    entity.getPhone()
            )

    );

    private final Function<GuarantorDto, Guarantor> modelToEntity = (dto) -> {
        Guarantor entity = new Guarantor();
        entity.setLoanApplicationId(dto.getLoanApplicationId());
        entity.setName(dto.getName());
        entity.setLastname(dto.getLastname());
        entity.setIdentificationType(dto.getIdentificationType());
        entity.setIdentification(dto.getIdentification());
        entity.setCity(dto.getCity());
        entity.setState(dto.getState());
        entity.setAddress(dto.getAddress());
        entity.setApartment(dto.getApartment());
        entity.setZipcode(dto.getZipcode());
        entity.setPhone(dto.getPhone());

        return entity;
    };

    @Override
    public void saveGuarantor(GuarantorDto request) {
        guarantorRepository.saveGuarantor(modelToEntity.apply(request));
    }
}
