package com.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Objects;

@Entity
@Table(name = "employee", schema = "dbo", catalog = "course_manager")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotEmpty(message = "Name not null!!")
    private String name;

    @Column(name = "gender")
    @NotNull(message = "Please choose gender...")
    private Boolean gender;

    @Column(name = "email")
    @Pattern(regexp = "[^@]+@[^\\.]+\\..+",message = "Please enter valid email!!")
    private String email;

    @Column(name = "address")
    @NotEmpty(message = "Please enter your address!!!")
    private String address;

    @Column(name = "image")
    private String avatar;
}
