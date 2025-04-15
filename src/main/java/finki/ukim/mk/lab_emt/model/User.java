package finki.ukim.mk.lab_emt.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import finki.ukim.mk.lab_emt.model.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
@Table(name = "app_user")
public class User implements UserDetails {

    @Id
    private String username;

    @JsonIgnore
    private String password;

    private String name;

    private String surname;
    private Role role;
    @OneToMany
    private List<Smestuvanje> tempReservation  = new ArrayList<>();

    public User(String username, String password, String name, String surname, Role role) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.role = role;
    }

    public User(String username, String name, String surname, Role name1) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.role = name1;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
