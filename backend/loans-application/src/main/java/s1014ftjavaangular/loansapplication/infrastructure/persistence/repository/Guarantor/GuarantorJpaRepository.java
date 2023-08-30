package s1014ftjavaangular.loansapplication.infrastructure.persistence.repository.Guarantor;

import org.springframework.data.jpa.repository.JpaRepository;
import s1014ftjavaangular.loansapplication.infrastructure.persistence.entities.GuarantorEntity;

public interface GuarantorJpaRepository extends JpaRepository<GuarantorEntity, String> {
}
