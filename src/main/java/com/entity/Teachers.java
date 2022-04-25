package com.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "teachers", schema = "dbo", catalog = "course_manager")
@Data
public class Teachers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotEmpty(message = "Teacher's name not empty!!")
    private String name;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "email",unique = true)
    @Pattern(regexp = "[^@]+@[^\\.]+\\..+",message = "Email mustn't empty and must valid !!")
    private String email;

    @Column(name = "phone",unique = true)
    @Pattern(regexp = "[0-9]+",message = "Phone must not empty and valid")
    private String phone;

    @Column(name = "gender")
    @NotNull(message = "Please choose gender(Male/Female)...")
    private Boolean gender;

    @Column(name = "address")
    @NotEmpty(message = "Please enter address..")
    private String address;

    @Column(name = "userName")
    private String userName;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "teachers", fetch = FetchType.EAGER)
    private List<Course> lstCourses;
    public List<Course> getLstCourses() {
        return lstCourses;
    }

    public void setLstCourses(List<Course> lstCourses) {
        this.lstCourses = lstCourses;
    }

}
