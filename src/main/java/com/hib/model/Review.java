package com.hib.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name="review")
@Table(name = "T_review")
public class Review {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rev_id")
    private Long id;

    @Column(name = "rev_comment")
    private String comment ;

    @Column(name = "rev_date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "rev_crs_id" )
    private Course course ;

    public Review() {
    }


    public Review(String comment) {
        this.comment = comment;
    }

    public Review(String comment, Course course) {
        this.comment = comment;
        this.course = course;
    }

    public Review(String comment, Date date, Course course) {
        this.comment = comment;
        this.date = date;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", course=" + course +
                '}';
    }
}
