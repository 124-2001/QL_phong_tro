package com.example.ql_phong_tro.model.DTO;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class RenterDTO {
    private int id;
    @NotNull
    private String name;
    @NotNull
    private String phone;
}
