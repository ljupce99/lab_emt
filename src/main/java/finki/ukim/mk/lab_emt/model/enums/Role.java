package finki.ukim.mk.lab_emt.model.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_USER, ROLE_Host;


    @Override
    public String getAuthority() {
        return "";
    }
}
