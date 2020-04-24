package by.kasakovich.springwebapp.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority{
    ADMIN_ROLE,
    NONAME_ROLE;

    @Override
    public String getAuthority() {
        return name();
    }
}
