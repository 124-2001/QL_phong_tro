package com.example.ql_phong_tro.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    @ManyToOne
    @JoinColumn(name = "land_lord_id")
    private LandLord landLord;
    @OneToOne
    @JoinColumn(name = "room_id")
    private Room room;
}
