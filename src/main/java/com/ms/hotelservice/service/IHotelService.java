package com.ms.hotelservice.service;

import com.ms.hotelservice.entity.Hotel;

import java.util.List;

public interface IHotelService {

    public boolean saveHotel(Hotel hotel);

    public List<Hotel> getAllHotels();

    public Hotel getHotelById(Long hotelId);

    public boolean updateHotel(Long id,Hotel hotel);

    public boolean deleteHotelById(Long hotelId);
}
