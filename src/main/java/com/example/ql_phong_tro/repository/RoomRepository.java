package com.example.ql_phong_tro.repository;

import com.example.ql_phong_tro.model.entity.LandLord;
import com.example.ql_phong_tro.model.entity.Room;
import com.example.ql_phong_tro.model.enums.StatusRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room,Integer> {
    Room findByStatusRoomAndAndLandLord(StatusRoom statusRoom, LandLord landLord);
}
