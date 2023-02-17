package com.example.ql_phong_tro.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class LandLord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String phone;
    @OneToMany(mappedBy = "landLord")
    private List<Post> postList;
    @OneToMany(mappedBy = "landLord")
    private List<Room> roomList;
    @OneToMany(mappedBy = "landLord")
    private List<Contract> contracts;
}
