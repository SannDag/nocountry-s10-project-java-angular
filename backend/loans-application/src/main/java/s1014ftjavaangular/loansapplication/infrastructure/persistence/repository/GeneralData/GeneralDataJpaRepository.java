package s1014ftjavaangular.loansapplication.infrastructure.persistence.repository.GeneralData;

import org.springframework.data.jpa.repository.JpaRepository;
import s1014ftjavaangular.loansapplication.infrastructure.persistence.entities.GeneralDataEntity;

import java.util.Optional;

public interface GeneralDataJpaRepository extends JpaRepository<GeneralDataEntity, String> {

    Optional<GeneralDataEntity> findById(String id);

}
