package com.example.demo.db.infoserv;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Query {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(columnDefinition="varchar(2000)")
    private String query;

    @Column(columnDefinition="varchar(2000)")
    private String responce;

}
