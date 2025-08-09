package CodeChallenge.toDoList.Model;

import java.time.LocalDateTime;

import CodeChallenge.toDoList.Enums.Status;
import jakarta.persistence.*;
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
    @ManyToOne
    @JoinColumn(name = "user_id") // Maps the foreign key column in the task table
    private User user;
}
