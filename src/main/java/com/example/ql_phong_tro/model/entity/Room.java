package com.example.ql_phong_tro.model.entity;

import com.example.ql_phong_tro.model.enumDescription.StatusRoom;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;
    @ManyToOne
    @JoinColumn(name = "land_lord_id")
    private LandLord landLord;
    private StatusRoom statusRoom;
    private float price;
    @OneToMany(mappedBy = "room")
    private List<Renter> renters;
}
