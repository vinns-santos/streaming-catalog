package tech.ada.pw2.streaming.titles.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.ada.pw2.streaming.titles.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String login);
}
