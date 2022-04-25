package com.entity;

import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "students", schema = "dbo", catalog = "course_manager")
@Data
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotEmpty(message = "Please enter student's name...")
    private String name;

    @Column(name = "email",unique = true)
    @Pattern(regexp = "[^@]+@[^\\.]+\\..+", message = "Please enter valid email")
    private String email;

    @Column(name = "phone", unique = true)
    @Pattern(regexp = "[0-9]+", message = "Please enter valid phone")
    private String phone;

    @Column(name = "gender")
//    @NotNull(message = "Please choose gender (Male/Female)..")
    private Boolean gender;

    @Column(name = "birthday")
    @NotEmpty(message = "Please enter your birthday...")
    private String birthday;

    @Column(name = "address")
//    @NotEmpty(message = "Please enter address...")
    private String address;

    @Column(name = "avatar")
    private String avatar;


    @Column(name = "usr_name")
    private String usrName;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "students", fetch = FetchType.EAGER)
    private List<Tests> testsList;

    @OneToMany(mappedBy = "students")
    private List<Threads> threadsList;

    @OneToOne(mappedBy = "students")
    private StudentProgress progress;

    @OneToMany(mappedBy = "students")
    private List<Marks> marksList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Students that = (Students) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(email, that.email) && Objects.equals(phone, that.phone) && Objects.equals(gender, that.gender) && Objects.equals(birthday, that.birthday) && Objects.equals(address, that.address);
    }

}
