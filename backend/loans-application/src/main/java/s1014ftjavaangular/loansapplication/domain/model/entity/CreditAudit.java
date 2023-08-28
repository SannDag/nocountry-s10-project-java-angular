package s1014ftjavaangular.loansapplication.domain.model.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class CreditAudit {
    private String creditAuditId;
    private LocalDate auditDate;
    private String creditAuditorId;
}
