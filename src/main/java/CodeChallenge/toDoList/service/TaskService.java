package CodeChallenge.toDoList.service;



import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

import CodeChallenge.toDoList.Model.Task;
import CodeChallenge.toDoList.Model.User;
import CodeChallenge.toDoList.Repositories.TaskRepository;
import CodeChallenge.toDoList.service.UserService;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserService userService; // para buscar usuário autenticado

    public TaskService(TaskRepository taskRepository, UserService userService) {
        this.taskRepository = taskRepository;
        this.userService = userService;
    }

    private User getAuthenticatedUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName(); // pega email/login do token
        return userService.findByUsername(username);
    }

    public Task createTask(Task task) {
        User user = getAuthenticatedUser();
        task.setUser(user);
        return taskRepository.save(task);
    }

    public List<Task> getTasks(String status) {
        User user = getAuthenticatedUser();
        if (status == null || status.equalsIgnoreCase("ALL")) {
            return taskRepository.findByUser(user);
        }
        return taskRepository.findByUserAndStatus(user, status);
    }

    public void deleteTask(Long id) {
        User user = getAuthenticatedUser();
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
        if (!task.getUser().getId().equals(user.getId())) {
            throw new RuntimeException("Acesso negado!");
        }
        taskRepository.delete(task);
    }
}
