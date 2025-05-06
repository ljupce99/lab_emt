package finki.ukim.mk.lab_emt.dto;


import finki.ukim.mk.lab_emt.model.User;
import finki.ukim.mk.lab_emt.model.enums.Role;


public record DisplayUserDto(String username, String name, String surname, Role role) {

    public static DisplayUserDto from(User user) {
        return new DisplayUserDto(
                user.getUsername(),
                user.getName(),
                user.getSurname(),
                user.getRole()
        );
    }

    public User toUser() {
        return new User(username, name, surname, role);
    }
}

