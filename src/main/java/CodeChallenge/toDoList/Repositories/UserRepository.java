package CodeChallenge.toDoList.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import CodeChallenge.toDoList.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
