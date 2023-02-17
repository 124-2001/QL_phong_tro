package com.example.ql_phong_tro.controller;

import com.example.ql_phong_tro.model.DTO.ContractDTO;
import com.example.ql_phong_tro.model.entity.Contract;
import com.example.ql_phong_tro.service.ContractSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContractController {
    @Autowired
    ContractSevice contractSevice;

    @PostMapping("/contract/insert")
    public ResponseEntity<Contract> insertContract(@RequestBody ContractDTO dto){
        return ResponseEntity.ok(contractSevice.createContract(dto));
    }
}
