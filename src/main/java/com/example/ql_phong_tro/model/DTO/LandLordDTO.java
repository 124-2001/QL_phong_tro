package com.example.ql_phong_tro.model.DTO;

import com.example.ql_phong_tro.model.entity.Contract;
import com.example.ql_phong_tro.model.entity.Post;
import com.example.ql_phong_tro.model.entity.Room;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.OneToMany;
import java.util.List;

@Data
public class LandLordDTO {
    @NotNull
    private int id;
    @NotNull
    private String name;
    @NotNull
    private String phone;
    private List<Post> postList;
    private List<Room> roomList;
    private List<Contract> contracts;
}
