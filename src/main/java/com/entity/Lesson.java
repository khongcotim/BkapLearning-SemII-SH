package com.entity;

import lombok.Data;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "lesson")
@Data
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotEmpty(message = "Please fill your lesson name!!!")
    private String name;

    @Column(name = "times")
    @NotEmpty(message = "Please choose time for lesson!!!")
    private String times;

    @Column(name = "link_video")
    @NotEmpty(message = "Please enter link video!")
    private String link_video;

    @Column(name = "description")
    @NotEmpty(message = "Please enter description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course;

    @OneToOne(mappedBy = "lesson")
    private Marks marks;

    @OneToOne(mappedBy = "lesson")
    private Tests tests;
}
