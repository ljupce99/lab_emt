package finki.ukim.mk.lab_emt.service.DomainServices;

import finki.ukim.mk.lab_emt.model.User;
import finki.ukim.mk.lab_emt.model.enums.Role;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends UserDetailsService {
    User register(String username, String password, String repeatPassword, String name, String surname, Role role);

    User login(String username, String password);

    User findByUsername(String username);

}
