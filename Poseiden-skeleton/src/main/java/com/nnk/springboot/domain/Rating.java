package com.nnk.springboot.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "rating")
public class Rating {
    // TODO: Map columns in data table RATING with corresponding java fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //private Byte Id;
    private int id;
    private String moodysRating;
    private String sandPRating;
    private String fitchRating;
    //private Byte orderNumber;
    private int orderNumber;

    public Rating(String moodysRating, String sandPRating, String fitchRating, int orderNumber) {
        this.moodysRating = moodysRating; this .sandPRating = sandPRating; this.fitchRating = fitchRating; this.orderNumber = orderNumber;
    }
    public Rating() {
    }
}
