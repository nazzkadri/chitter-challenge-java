package com.makers.chitterchallenge.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column(nullable = false, length = 30, unique = true)
    private String username;

    @NotNull
    @NotEmpty
    private String fullName;

    @Size(min=1, max=50)
    private String passwordHash;

    @Email
    @Size(max = 100)
    @NotNull
    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "author")
    private List<Chitter> chitterList = new ArrayList<>();

    @OneToMany(mappedBy = "author")
    private List<Comment> commentList = new ArrayList<>();

    private User() {}

    public User(String username, @NotNull @NotEmpty String fullName, @Size(min = 1, max = 50) String passwordHash, @Email @Size(max = 100) @NotNull String email) {
        this.username = username;
        this.fullName = fullName;
        this.passwordHash = passwordHash;
        this.email = email;
    }

    public Long getUser_id() {
        return user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Chitter> getChitterList() {
        return chitterList;
    }

    public void setChitterList(List<Chitter> chitterList) {
        this.chitterList = chitterList;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }


}
