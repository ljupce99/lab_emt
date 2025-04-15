package finki.ukim.mk.lab_emt.dto;

import finki.ukim.mk.lab_emt.model.User;
import finki.ukim.mk.lab_emt.model.enums.Role;

public record CreateUserDto(
        String username,
        String password,
        String repeatPassword,
        String name,
        String surname,
        Role role
) {

    public User toUser() {
        return new User(username, password, name, surname, role);
    }
}

