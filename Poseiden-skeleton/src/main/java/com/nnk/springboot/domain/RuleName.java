package com.nnk.springboot.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "rulename")
public class RuleName {
    // TODO: Map columns in data table RULENAME with corresponding java fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //private Byte Id;
    private int Id;
    private String name;
    private String description;
    private String json;
    private String template;
    private String sqlStr;
    private String sqlPart;

    public RuleName(String ruleName, String description, String json, String template, String sql, String sqlPart) {
        this.name = ruleName; this.description = description; this.json = json; this.template=template; this.sqlStr = sql; this.sqlPart =sqlPart;
    }
    public RuleName() {
    }
}
