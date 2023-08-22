package s1014ftjavaangular.userservice.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import s1014ftjavaangular.userservice.domain.models.entity.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
