package com.example.hr.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    private String userName;


    private String email;


    private String Password;




    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name ="person_role",joinColumns =@JoinColumn(name="id"),inverseJoinColumns =@JoinColumn(name = "role_id") )
    private Set<Role> roles;

    public Person() {
        super();
    }



    public Person(Person persons) {
        this.id=persons.getId();
        this.userName = persons.userName;
        this.email = persons.email;
        this.Password = persons.Password;
        this.roles = persons.roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }



    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", Password='" + Password + '\'' +
                ", Role='" + roles + '\'' +
                '}';
    }
}
