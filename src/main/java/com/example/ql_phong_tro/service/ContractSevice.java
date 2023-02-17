package com.example.ql_phong_tro.service;

import com.example.ql_phong_tro.exception.NotFoundException;
import com.example.ql_phong_tro.model.DTO.ContractDTO;
import com.example.ql_phong_tro.model.entity.Contract;
import com.example.ql_phong_tro.model.entity.LandLord;
import com.example.ql_phong_tro.model.entity.Renter;
import com.example.ql_phong_tro.model.entity.Room;
import com.example.ql_phong_tro.model.enums.StatusContract;
import com.example.ql_phong_tro.model.enums.StatusRoom;
import com.example.ql_phong_tro.repository.ContractRepository;
import com.example.ql_phong_tro.repository.LandLordRepository;
import com.example.ql_phong_tro.repository.RenterRepository;
import com.example.ql_phong_tro.repository.RoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Service
@Slf4j
public class ContractSevice {
    @Autowired
    ContractRepository contractRepository;
    @Autowired
    RenterRepository renterRepository;
    @Autowired
    LandLordRepository landLordRepository;
    @Autowired
    RoomRepository roomRepository;

    @Transactional
    public Contract createContract(ContractDTO contractDTO){
        Contract contract = new Contract();
        ModelMapper mapper = new ModelMapper();
        Optional<Renter> renter = renterRepository.findById(contractDTO.getRenterDTO().getId());
        if(!renter.isPresent()){
            if(contractDTO.getRenterDTO().getName().isEmpty()){
                throw new RuntimeException("Ten nguoi thue de trong");
            }
            if (contractDTO.getRenterDTO().getPhone().isEmpty()){
                throw new RuntimeException("So dien thoai nguoi thue chua co");
            }
            renterRepository.save(renter.get());
            contract.setRenter(renter.get());
        }
        else {
            Renter renterNew = mapper.map(contractDTO.getRenterDTO(),Renter.class);
            if(renterNew.getRoom()!=null){
                throw new NotFoundException("Nguoi thue da co nha thue roi");
            }
            else {
                contract.setRenter(renterNew);
            }
        }
        Optional<LandLord> landLord = landLordRepository.findByPhone(contractDTO.getLandLordDTO().getPhone());
        if(landLord.isPresent()){
            contract.setLandLord(landLord.get());
            if(roomRepository.findById(contractDTO.getRoomDTO().getId()).get().getLandLord().getId()==landLord.get().getId()
                    &&roomRepository.findById(contractDTO.getRoomDTO().getId()).get().getStatusRoom()== StatusRoom.AVAILABLE){
                contract.setRoom(roomRepository.findById(contractDTO.getRoomDTO().getId()).get());
            }
            else {
                throw new NotFoundException("Chu phong khong co phong nay hoac da full");
            }
        }
        else {
            /*LandLord landLordNew = mapper.map(contractDTO.getLandLordDTO(),LandLord.class);
            landLordRepository.save(landLordNew);
            contract.setLandLord(landLordNew);*/
            throw new RuntimeException("Khong ton tai chu nha cho thue ");
        }
        Date currentDate = new Date(System.currentTimeMillis());
        contract.setTimeCreate(currentDate);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.MONTH, 6);
        currentDate = calendar.getTime();
        contract.setTimeEnd(currentDate);
        contract.setStatusContract(StatusContract.START);
        contractRepository.save(contract);
        return contract;
    }

    public void changeStatusContract(Contract contract){
        Date currentDate = new Date(System.currentTimeMillis());
        if(currentDate==contract.getTimeEnd()){
            contract.setStatusContract(StatusContract.END);
            contractRepository.save(contract);
        }
    }

    @Transactional
    public Contract deleteContract(Contract contract){
        if(!contractRepository.findById(contract.getId()).isPresent()){
            throw new NotFoundException("Hop dong khong ton tai");
        }
        else {
            changeStatusContract(contract);
            if(contract.getStatusContract()== StatusContract.START){
                throw  new NotFoundException("Hop dong chua het han, Chua di duoc dau :))");
            }
            else {
                Renter renter = contract.getRenter();
                renter.setRoom(null);
                Room room = contract.getRoom();
                room.setStatusRoom(StatusRoom.AVAILABLE);
                contractRepository.delete(contract);
            }
        }
        return contract;
    }

}
