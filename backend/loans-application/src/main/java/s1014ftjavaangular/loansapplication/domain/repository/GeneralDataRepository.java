package s1014ftjavaangular.loansapplication.domain.repository;

import org.springframework.stereotype.Component;
import s1014ftjavaangular.loansapplication.domain.model.dto.request.GeneralDataDto;

public interface GeneralDataRepository {
    void saveGeneralData(final GeneralDataDto dto);
}
