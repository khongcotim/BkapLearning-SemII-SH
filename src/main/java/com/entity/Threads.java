package com.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "thread")
@Data
public class Threads {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "answer_file")
    @NotEmpty(message = "Please submit your test!!!")
    private String answer_file;

    @ManyToOne
    @JoinColumn(name = "student_id",referencedColumnName = "id")
    private Students students;

    @OneToOne
    @JoinColumn(name = "test_id", referencedColumnName = "id")
    private Tests tests;
}
