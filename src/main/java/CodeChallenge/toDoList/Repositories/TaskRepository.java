package CodeChallenge.toDoList.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import CodeChallenge.toDoList.Model.Task;
import CodeChallenge.toDoList.Model.User;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByUser(User user);

    List<Task> findByUserAndStatus(User user, String status);
}
