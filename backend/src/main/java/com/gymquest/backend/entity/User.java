package com.gymquest.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private int current_xp;
    private int level;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getCurrent_xp() { return current_xp; }
    public void setCurrent_xp(int current_xp) { this.current_xp = current_xp; }

    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }
}
