package com.example.ql_phong_tro.model.entity;

import com.example.ql_phong_tro.model.enumDescription.StatusContract;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Getter
@Setter
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "land_lord_id")
    private LandLord landLord;
    @OneToOne
    @JoinColumn(name = "renter_id")
    private Renter renter;
    @OneToOne
    @JoinColumn(name = "room_id")
    private Room room;
    @Column(name = "time_create")
    private Date timeCreate;
    @Column(name = "time_end")
    private Date timeEnd;
    @Column(name = "status_contract")
    private StatusContract statusContract;
}
