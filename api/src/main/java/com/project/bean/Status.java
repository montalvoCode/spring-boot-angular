package com.project.bean;

import lombok.*;

import javax.persistence.*;

@Data
@Entity(name = "status")
@Table(name = "status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_status")
    private Integer idStatus;

    @Column(name = "description")
    private String description;

}
