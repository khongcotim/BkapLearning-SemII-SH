package com.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "course", schema = "dbo", catalog = "course_manager")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotEmpty(message = "Please enter course's name !!!")
    private String name;

    @Column(name = "title")
    @NotEmpty(message = "Please fill your title!!")
    @Length(max = 50, message = "Max length is 50 character. Please try again!!!")
    private String title;

    @Column(name = "image")
//    @NotEmpty(message = "Ảnh không được để rỗng !!!")
    private String image;

    @Column(name = "times")
    @NotEmpty(message = "Please fill course's times !!")
    private String times;

    @Column(name = "description")
    @NotEmpty(message = "Please fill your description !!")
    private String description;

    @Column(name = "stastus")
    @NotNull(message = "Please choose your status!!")
    private Boolean status;

    @Column(name = "link_video")
    @NotEmpty(message = "Please enter video's link")
    private String linkVideo;

    @Column(name = "sale_price")
    @Range(min =0, max = 10000,message = "Sale price must from 0$ -> 10000$")
    private Double salePrice;

    @ManyToOne
    @JoinColumn(name = "cate_id",referencedColumnName = "id")
    @NotNull(message = "Please choose category!!")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "author", referencedColumnName = "id")
    @NotNull(message = "Please choose author..")
    private Teachers teachers;

    @OneToOne(mappedBy = "course")
    private StudentProgress progress;

    @OneToMany(mappedBy = "course")
    private List<Lesson> lesson;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getLinkVideo() {
        return linkVideo;
    }

    public void setLinkVideo(String linkVideo) {
        this.linkVideo = linkVideo;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Teachers getTeachers() {
        return teachers;
    }

    public void setTeachers(Teachers teachers) {
        this.teachers = teachers;
    }

    public StudentProgress getProgress() {
        return progress;
    }

    public void setProgress(StudentProgress progress) {
        this.progress = progress;
    }

    public List<Lesson> getLesson() {
        return lesson;
    }

    public void setLesson(List<Lesson> lesson) {
        this.lesson = lesson;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", times='" + times + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", linkVideo='" + linkVideo + '\'' +
                ", salePrice=" + salePrice +
                '}';
    }
}
