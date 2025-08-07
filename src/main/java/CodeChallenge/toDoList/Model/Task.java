package CodeChallenge.toDoList.Model;

import java.time.LocalDateTime;

import CodeChallenge.toDoList.Enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String name;
    private LocalDateTime start;
    private LocalDateTime ending;
    private String description;
    private Status status;
    private User user;
}
