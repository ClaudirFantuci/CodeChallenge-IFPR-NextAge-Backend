package CodeChallenge.toDoList.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import CodeChallenge.toDoList.Model.User;
import CodeChallenge.toDoList.Repositories.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public User findByUsername(String username) {
        System.out.println("Searching for user with email: " + username);
        return userRepository.findByEmailIgnoreCase(username.toLowerCase())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado: " + username));
    }
}