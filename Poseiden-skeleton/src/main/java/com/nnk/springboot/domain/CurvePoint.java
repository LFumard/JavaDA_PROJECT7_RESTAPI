package com.nnk.springboot.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Getter
@Setter
@Table(name = "curvepoint")
public class CurvePoint {
    // TODO: Map columns in data table CURVEPOINT with corresponding java fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "CurveId")
    private int curveId;
    private Timestamp asOfDate;
    private double term;
    private double value;
    private Timestamp creationDate;

    public CurvePoint(int curveId, double term, double value) {
        this.id = curveId; this.term = term; this.value = value;
    }
    public CurvePoint() {
    }

}
