package s1014ftjavaangular.loansapplication.infrastructure.persistence.repository.JobInformation;

import org.springframework.data.jpa.repository.JpaRepository;
import s1014ftjavaangular.loansapplication.infrastructure.persistence.entities.JobInformationEntity;

import java.util.Optional;

public interface JobInformationJpaRepository extends JpaRepository<JobInformationEntity, String> {
    Optional<JobInformationEntity> findById(String id);

}