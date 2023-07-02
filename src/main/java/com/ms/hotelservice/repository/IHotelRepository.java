package com.ms.hotelservice.repository;

import com.ms.hotelservice.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHotelRepository extends JpaRepository<Hotel,Long> {

}
