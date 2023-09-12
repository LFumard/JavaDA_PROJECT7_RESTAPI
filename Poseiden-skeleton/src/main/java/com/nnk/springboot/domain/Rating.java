package com.nnk.springboot.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Positive;

@Entity
@Getter
@Setter
@Table(name = "rating")
public class Rating {
    // TODO: Map columns in data table RATING with corresponding java fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //private Byte Id;
    private Integer id;
    private String moodysRating;
    private String sandPRating;
    private String fitchRating;
    //private Byte orderNumber;
    @Positive
    private Integer orderNumber;

    public Rating(String moodysRating, String sandPRating, String fitchRating, Integer orderNumber) {
        this.moodysRating = moodysRating; this .sandPRating = sandPRating; this.fitchRating = fitchRating; this.orderNumber = orderNumber;
    }
    public Rating() {
    }
}
