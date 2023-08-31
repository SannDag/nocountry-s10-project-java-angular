package s1014ftjavaangular.loansapplication.domain.repository;

import s1014ftjavaangular.loansapplication.domain.model.dto.request.GuarantorDto;
import s1014ftjavaangular.loansapplication.domain.model.dto.request.JobInformationDto;

public interface GuarantorRepository {
    void updateGuarantor(final GuarantorDto dto);
}
