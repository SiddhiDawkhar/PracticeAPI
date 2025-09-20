package com.example.realapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="tbl_student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private Integer Age;

    private String Name;

    private String Email;

    private String Password;

    private String Phone;

}
