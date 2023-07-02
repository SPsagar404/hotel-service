package com.ms.hotelservice.service.impl;

import com.ms.hotelservice.entity.Hotel;
import com.ms.hotelservice.repository.IHotelRepository;
import com.ms.hotelservice.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements IHotelService {

    @Autowired
    private IHotelRepository hotelRepository;

    @Override
    public boolean saveHotel(Hotel hotel) {
        Hotel saved = hotelRepository.save(hotel);
        return saved.getId() != null;
    }

    @Override
    public List<Hotel> getAllHotels() {
        List<Hotel> allHotels = hotelRepository.findAll();
        return allHotels;
    }

    @Override
    public Hotel getHotelById(Long hotelId) {
        Optional<Hotel> findById = hotelRepository.findById(hotelId);
        if(findById.isPresent())
            return findById.get();
        return null;
    }

    @Override
    public boolean updateHotel(Long id,Hotel updatehotel) {
        Optional<Hotel> byId = hotelRepository.findById(id);
        if(byId.isPresent()){
            Hotel hotel = byId.get();
            hotel.setName(updatehotel.getName());
            hotel.setLocation(updatehotel.getLocation());
            hotel.setAbout(updatehotel.getAbout());
            hotelRepository.save(hotel);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteHotelById(Long hotelId) {
        boolean status = false;
        try{
            hotelRepository.deleteById(hotelId);
            status=true;
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return status;
    }
}
