package com.telran.phonebookapi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity(name = "Users")
@NoArgsConstructor
@Getter
public class User {

    @Id
    private String email;

    @Setter
    private String password;

    @Setter
    private UserRole userRole;

    @Setter
    private boolean isConfirmed;

    @Setter
    private String name;

    @Setter
    private String lastName;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Contact> contacts = new ArrayList<>();

    public User(String email, String password) {
        this.email = email;
        this.password = password;
        userRole = UserRole.USER;
        isConfirmed = false;
    }

    public List<Contact> getContact() {
        return Collections.unmodifiableList(contacts);
    }
}

