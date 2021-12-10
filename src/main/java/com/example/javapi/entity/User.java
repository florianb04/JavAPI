package com.example.javapi.entity;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    //@Column(name = "id_user ")
    private Long id_user ;
    private String firstName_user;
    private String lastName_user;
    private String email_user;
    private String hash_user;

    public User() {
    }

    public User(Long id_user,
                String firstName_user,
                String lastName_user,
                String email_user,
                String hash_user) {
        this.id_user = id_user;
        this.firstName_user = firstName_user;
        this.lastName_user = lastName_user;
        this.email_user = email_user;
        this.hash_user = hash_user;
    }

    public User(String firstName_user,
                String lastName_user,
                String email_user,
                String hash_user) {
        this.firstName_user = firstName_user;
        this.lastName_user = lastName_user;
        this.email_user = email_user;
        this.hash_user = hash_user;
    }


    //Getter and Setter
    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public String getFirstName_user() {
        return firstName_user;
    }

    public void setFirstName_user(String firstName_user) {
        this.firstName_user = firstName_user;
    }

    public String getLastName_user() {
        return lastName_user;
    }

    public void setLastName_user(String lastName_user) {
        this.lastName_user = lastName_user;
    }

    public String getEmail_user() {
        return email_user;
    }

    public void setEmail_user(String email_user) {
        this.email_user = email_user;
    }

    public String getHash_user() {
        return hash_user;
    }

    public void setHash_user(String hash_user) {
        this.hash_user = hash_user;
    }

    @Override
    public String toString() {
        return "userEntity{" +
                "id_user=" + id_user +
                ", firstName_user='" + firstName_user + '\'' +
                ", lastName_user='" + lastName_user + '\'' +
                ", email_user='" + email_user + '\'' +
                ", hash_user='" + hash_user + '\'' +
                '}';
    }
}
