package s1014ftjavaangular.loansapplication.infrastructure.persistence.repository.guarantor;

import org.springframework.data.jpa.repository.JpaRepository;
import s1014ftjavaangular.loansapplication.infrastructure.persistence.entities.GuarantorEntity;
import s1014ftjavaangular.loansapplication.infrastructure.persistence.entities.JobInformationEntity;

import java.util.Optional;

public interface GuarantorJpaRepository extends JpaRepository<GuarantorEntity, String> {
    Optional<GuarantorEntity> findById(String id);
    Boolean existsByUuid(String id);
}
