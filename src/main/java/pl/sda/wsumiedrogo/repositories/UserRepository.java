package pl.sda.wsumiedrogo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.wsumiedrogo.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
    User findByCity(String city);
    User findByActivationCode(String activationCode);
}
