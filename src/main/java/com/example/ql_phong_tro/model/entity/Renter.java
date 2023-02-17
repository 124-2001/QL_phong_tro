package com.example.ql_phong_tro.model.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
public class Renter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String phone;
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
}
