package CodeChallenge.toDoList.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import CodeChallenge.toDoList.Model.Task;
import CodeChallenge.toDoList.Model.User;
import CodeChallenge.toDoList.Repositories.TaskRepository;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserService userService;

    public TaskService(TaskRepository taskRepository, UserService userService) {
        this.taskRepository = taskRepository;
        this.userService = userService;
    }

    private User getAuthenticatedUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || auth.getName() == null) {
            System.out.println("No authenticated user found");
            throw new RuntimeException("Usuário não autenticado");
        }
        String username = auth.getName();
        System.out.println("Authenticated username: " + username);
        User user = userService.findByUsername(username);
        System.out.println("Authenticated user ID: " + user.getId());
        return user;
    }

    public Task createTask(Task task) {
        try {
            User user = getAuthenticatedUser();
            System.out.println("Usuário autenticado: " + user.getEmail());
            task.setUser(user);
            return taskRepository.save(task);
        } catch (Exception e) {
            System.out.println("Erro ao criar tarefa: " + e.getMessage());
            throw e;
        }
    }

    public List<Task> getTasks(String status) {
        User user = getAuthenticatedUser();
        if (status == null || status.equalsIgnoreCase("ALL")) {
            return taskRepository.findByUser(user);
        }
        return taskRepository.findByUserAndStatus(user, status);
    }

    public Task updateTask(Long id, Task taskDetails) {
        try {
            User user = getAuthenticatedUser();
            Task task = taskRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
            if (!task.getUser().getId().equals(user.getId())) {
                throw new RuntimeException("Acesso negado!");
            }
            task.setName(taskDetails.getName());
            task.setDescription(taskDetails.getDescription());
            task.setStatus(taskDetails.getStatus());
            task.setStart(taskDetails.getStart());
            task.setEnding(taskDetails.getEnding());
            return taskRepository.save(task);
        } catch (Exception e) {
            System.out.println("Erro ao atualizar tarefa: " + e.getMessage());
            throw e;
        }
    }

    @Transactional
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