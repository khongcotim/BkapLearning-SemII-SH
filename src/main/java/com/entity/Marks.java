package com.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "marks", schema = "dbo", catalog = "course_manager")
@Data
public class Marks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "score")
    private Double score;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Students students;

    @OneToOne
    @JoinColumn(name = "lesson_id", referencedColumnName = "id")
    private Lesson lesson;

}
