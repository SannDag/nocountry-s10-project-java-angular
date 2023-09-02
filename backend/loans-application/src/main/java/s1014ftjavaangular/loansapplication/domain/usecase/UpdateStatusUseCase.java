package s1014ftjavaangular.loansapplication.domain.usecase;

import s1014ftjavaangular.loansapplication.domain.model.dto.request.JobInformationDto;
import s1014ftjavaangular.loansapplication.domain.model.entity.LoansApplication;

public interface UpdateStatusUseCase {
    void updateStatus(LoansApplication request);
}
