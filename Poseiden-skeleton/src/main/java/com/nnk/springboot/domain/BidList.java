package com.nnk.springboot.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.sql.Date;

@Entity
@Getter
@Setter
@Table(name = "bidlist")
public class BidList {
    // TODO: Map columns in data table BIDLIST with corresponding java fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //private Byte BidListId;
    private Integer bidListId;
    @NotBlank(message = "Account is mandatory")
    private String account;
    @NotBlank(message = "Type is mandatory")
    private String type;
    @Digits(message = "Bid quantity should have 2 digits before comma and 2 digits after comma", integer = 3, fraction = 2)
    private double bidQuantity;
    private double askQuantity;
    private double bid;
    private double ask;

    private String benchmark;
    private Date bidListDate;
    private String commentary;
    private String security;
    private String status;
    private String trader;
    private String book;
    private String creationName;
    private Date creationDate;
    private String revisionName;
    private Date revisionDate;
    private String dealName;
    private String dealType;
    private String sourceListId;
    private String side;


    public BidList(String accountTest, String typeTest, double v) {
        this.account = accountTest;
        this.type = typeTest;
        this.askQuantity = v;
    }
    public BidList() {
    }

    public Integer getBidListId() {
        return bidListId;
    }
}
