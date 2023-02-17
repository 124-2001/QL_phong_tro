package com.example.ql_phong_tro.service;

import com.example.ql_phong_tro.repository.RenterRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RenterService {
    @Autowired
    RenterRepository renterRepository;
}
