package s1014ftjavaangular.loansapplication.domain.repository;

import s1014ftjavaangular.loansapplication.domain.model.dto.request.GuarantorDto;

public interface GuarantorRepository {

    void saveGuarantor(final GuarantorDto dto);
}
