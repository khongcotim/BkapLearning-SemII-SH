package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "admin", schema = "dbo", catalog = "course_manager")
@Data
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "usr_name")
    private String usrName;

    @Column(name = "password")
    private String password;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "phone",unique = true)
    private String phone;

    @Column(name = "address", nullable = false, length = 120)
    private String address;

    @Column(name = "role")
    private String role;

    @Column(name = "status", nullable = true)
    private Boolean status;

    public Admin() {
    }

    public Admin(int id, String name, String usrName, String password, String email, String phone, String address, String role, Boolean status) {
        this.id = id;
        this.name = name;
        this.usrName = usrName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.role = role;
        this.status = status;
    }
}
