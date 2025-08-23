package CodeChallenge.toDoList.service;


import org.springframework.stereotype.Service;
import CodeChallenge.toDoList.Model.User;
import CodeChallenge.toDoList.Repositories.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUsername(String username) {
        return userRepository.findByEmail(username) // supondo que login seja pelo email
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado: " + username));
    }
}
