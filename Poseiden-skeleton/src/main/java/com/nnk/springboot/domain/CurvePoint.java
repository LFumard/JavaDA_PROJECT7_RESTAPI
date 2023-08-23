package com.nnk.springboot.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Getter
@Setter
@Table(name = "curvepoint")
public class CurvePoint {
    // TODO: Map columns in data table CURVEPOINT with corresponding java fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //private Byte Id;
    private int id;
    @Column(name = "CurveId")
    private int curveId;
    private Date asOfDate;
    private double term;
    private double value;
    private Date creationDate;

    public CurvePoint(int curveId, double term, double value) {
        this.id = curveId; this.term = term; this.value = value;
    }
    public CurvePoint() {
    }

}
