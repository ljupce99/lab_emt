package finki.ukim.mk.lab_emt.repository;

import finki.ukim.mk.lab_emt.model.User;
import finki.ukim.mk.lab_emt.model.UserProjection;
import finki.ukim.mk.lab_emt.model.enums.Role;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsernameAndPassword(String username, String password);

    Optional<User> findByUsername(String username);



}
