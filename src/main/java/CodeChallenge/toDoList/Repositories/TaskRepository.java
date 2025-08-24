package CodeChallenge.toDoList.Repositories;

import CodeChallenge.toDoList.Model.Task;
import CodeChallenge.toDoList.Model.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByUser(User user);

    List<Task> findByUserAndStatus(User user, String status);
}