package com.study.learn;

import jakarta.persistence.*;

@Entity
@Table(name = "login1")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private int mobno;


    @Column
    private String role;  // e.g., "USER" or "ADMIN"

    // Constructors
    public User() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public int getMobno() { return mobno; }
    public void setMobno(int mobno) { this.mobno = mobno; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
