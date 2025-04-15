package finki.ukim.mk.lab_emt.service.DomainServices.imp;

import finki.ukim.mk.lab_emt.model.User;
import finki.ukim.mk.lab_emt.model.enums.Role;
import finki.ukim.mk.lab_emt.model.exceptions.*;
import finki.ukim.mk.lab_emt.repository.UserRepository;
import finki.ukim.mk.lab_emt.service.DomainServices.UserDomainService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserDomainServiceimp implements UserDomainService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public UserDomainServiceimp(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(
                username));
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(
                username));
    }

    @Override
    public User register(
            String username,
            String password,
            String repeatPassword,
            String name,
            String surname,
            Role userRole
    ) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty())
            throw new InvalidUsernameOrPasswordException("greska username/password");
        if (!password.equals(repeatPassword)) throw new PasswordsDoNotMatchException("greska password");
        if (userRepository.findByUsername(username).isPresent())
            throw new UsernameAlreadyExistsException(username);
        User user = new User(username, passwordEncoder.encode(password), name, surname, userRole);
        return userRepository.save(user);
    }

    @Override
    public User login(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new InvalidArgumentsException("greska argumenti");
        }
        return userRepository.findByUsernameAndPassword(username, password).orElseThrow(
                InvalidUserCredentialsException::new);
    }
}
