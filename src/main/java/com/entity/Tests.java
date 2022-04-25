package com.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "tests")
@Data
public class Tests {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    @NotEmpty(message = "Please enter question's title!!")
    private String title;

    @Column(name = "times")
    @NotEmpty(message = "Please enter limit time: ")
    private String times;

    @Column(name = "question")
    private String question;

    @Column(name = "max_mark")
    @Range(min = 1, max = 100, message = "Max mark must from 1 to 100")
    private float maxFloat;

    @OneToOne
    @JoinColumn(name = "lesson",referencedColumnName = "id")
    private Lesson lesson;

    @ManyToOne
    @JoinColumn(name = "student_id",referencedColumnName = "id")
    private Students students;

    @OneToOne(mappedBy = "tests")
    private Threads threads;
}
