package com.example.ql_phong_tro.model.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "type")
    private List<Room> roomList;
}
