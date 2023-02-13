package hb.spring.evaluation.models;

import org.springframework.security.core.GrantedAuthority;

import java.util.List;

public class LocalUser {

    private Integer id;
    private String username;
    private String password;
    private String categories;

    private String role;

    public LocalUser() {
    }

    public LocalUser(Integer id, String username, String password, String categories, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.categories = categories;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
