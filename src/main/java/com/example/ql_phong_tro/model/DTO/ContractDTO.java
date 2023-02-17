package com.example.ql_phong_tro.model.DTO;

import com.example.ql_phong_tro.model.enumDescription.StatusContract;
import com.fasterxml.jackson.databind.DatabindException;
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
