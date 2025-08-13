package CodeChallenge.toDoList.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import CodeChallenge.toDoList.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
