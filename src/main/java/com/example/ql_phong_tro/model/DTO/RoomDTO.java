package com.example.ql_phong_tro.model.DTO;

import com.example.ql_phong_tro.model.entity.LandLord;
import com.example.ql_phong_tro.model.entity.Renter;
import com.example.ql_phong_tro.model.entity.Type;
import com.example.ql_phong_tro.model.enumDescription.StatusRoom;
import com.sun.istack.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class RoomDTO {
    @NotNull
    private int id;
    private Type type;
    private LandLord landLord;
    private StatusRoom statusRoom;
    private float price;
    private List<Renter> renters;
}
