package CodeChallenge.toDoList.Controllers;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CodeChallenge.toDoList.DTO.LoginRequestDTO;
import CodeChallenge.toDoList.DTO.RegisterRequestDTO;
import CodeChallenge.toDoList.DTO.ResponseDTO;
import CodeChallenge.toDoList.Model.User;
import CodeChallenge.toDoList.Repositories.UserRepository;
import CodeChallenge.toDoList.infra.Security.TokenService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(@RequestBody LoginRequestDTO body) {
        User user = this.repository.findByEmail(body.email().toLowerCase())
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (passwordEncoder.matches(body.password(), user.getPassword())) {
            String token = this.tokenService.genereteToken(user);
            return ResponseEntity.ok(new ResponseDTO(user.getEmail(), token));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> register(@RequestBody RegisterRequestDTO body) {
        Optional<User> user = this.repository.findByEmail(body.email().toLowerCase());
        if (user.isEmpty()) {
            User newUser = new User();
            newUser.setPassword(passwordEncoder.encode(body.password()));
            newUser.setEmail(body.email().toLowerCase());
            newUser.setName(body.name());
            this.repository.save(newUser);
            String token = this.tokenService.genereteToken(newUser);
            return ResponseEntity.ok(new ResponseDTO(newUser.getEmail(), token));
        }
        return ResponseEntity.badRequest().body(new ResponseDTO("Email já em uso", null));
    }

}