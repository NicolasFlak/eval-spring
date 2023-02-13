package hb.spring.evaluation.models;

import java.util.List;

public class LocalUser {

    private Integer id;
    private String username;
    private String password;
    private List<String> categories;
    private String role;

    public LocalUser() {
    }

    public LocalUser(Integer id, String username, String password, List<String> categories, String role) {
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

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
