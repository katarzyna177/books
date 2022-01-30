package pl.kate.bookaro.user.db;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kate.bookaro.user.domain.UserEntity;

import java.util.Optional;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsernameIgnoreCase(String username);
}
