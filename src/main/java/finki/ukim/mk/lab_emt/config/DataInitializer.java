package finki.ukim.mk.lab_emt.config;

import finki.ukim.mk.lab_emt.model.User;
import finki.ukim.mk.lab_emt.model.enums.Role;
import finki.ukim.mk.lab_emt.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @PostConstruct
    public void initialize() {

        userRepository.save(new User(
                "admin",
                passwordEncoder.encode("admin"),
                "admin",
                "admin",
                Role.ROLE_Host
        ));

        userRepository.save(new User(
                "user",
                passwordEncoder.encode("user"),
                "ljupce",
                "221277",
                Role.ROLE_USER
        ));
    }
//    @PostConstruct
    public void init() {

        userRepository.save(new User(
                "admin",
                passwordEncoder.encode("admin"),
                "admin",
                "admin",
                Role.ROLE_Host
        ));

        userRepository.save(new User(
                "user",
                passwordEncoder.encode("user"),
                "ljupce",
                "221277",
                Role.ROLE_USER
        ));
    }
}

