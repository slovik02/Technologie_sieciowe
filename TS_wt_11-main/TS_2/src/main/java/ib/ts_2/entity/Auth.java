package ib.ts_2.entity;

import ib.ts_2.CommonTypes.UserRole;
import jakarta.persistence.*;

@Entity
public class Auth {
    /**
     * Represents an auth entity in the system, contains authorization info
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer auth_id;

    private String username;

    private String password;


    @Enumerated(EnumType.STRING)  // role of the user
    private UserRole role;

    @OneToOne
    @JoinColumn(name="user_id")  // id of the user
    private User user;

    public Integer getAuth_id() {
        return auth_id;
    }

    public void setAuth_id(Integer auth_id) {
        this.auth_id = auth_id;
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

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
