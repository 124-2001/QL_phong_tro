package com.example.ql_phong_tro.model.DTO;

import com.example.ql_phong_tro.model.enums.StatusContract;
import lombok.Data;

import java.util.Date;

@Data
public class ContractDTO {
    private LandLordDTO landLordDTO;
    private RenterDTO renterDTO;
    private RoomDTO roomDTO;
    private Date time_create;
    private Date end_create;
    private StatusContract statusContract;
}
