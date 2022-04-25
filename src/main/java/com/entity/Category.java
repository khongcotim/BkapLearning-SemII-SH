package com.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "category", schema = "dbo", catalog = "course_manager")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false, length = 100)
    @NotEmpty(message = "Please enter your name...")
    private String name;

    @Column(name = "status", nullable = true)
    @NotNull(message = "Please choose status...")
    private Boolean status;

    @Column(name = "parent_id", nullable = true)
    private Integer parentId;

    @Column(name = "avatar")
    private String avatar;

    @OneToMany(mappedBy="category")
    private List<Course> lstCourse;

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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<Course> getLstCourse() {
        return lstCourse;
    }

    public void setLstCourse(List<Course> lstCourse) {
        this.lstCourse = lstCourse;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category that = (Category) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(status, that.status) && Objects.equals(parentId, that.parentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, status, parentId);
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", parentId=" + parentId +
                '}';
    }
}
