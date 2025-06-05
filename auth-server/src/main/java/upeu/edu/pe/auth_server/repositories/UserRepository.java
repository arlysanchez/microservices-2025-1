package upeu.edu.pe.auth_server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import upeu.edu.pe.auth_server.entities.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
 Optional<UserEntity> findByUsername(String username);
}
