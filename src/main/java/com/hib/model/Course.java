package com.hib.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="course")
@Table(name = "T_course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "crs_id")
    private Long id;

    @Column(name = "crs_title")
    private String Title;

    @Column(name = "crs_level")
    private String level;



    @OneToMany(mappedBy =  "course",cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<Review>() ;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Course( String title, String level) {
        Title = title;
        this.level = level;
    }

    public Course() {
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", Title='" + Title + '\'' +
                ", level='" + level + '\'' +
                ", reviews=" + reviews +
                '}';
    }
}
