package com.example.dtotoentityconversion.entity;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Data
@Entity
@Table
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate = new Date();

    private String name;

    private String username;

    private String password;
}
