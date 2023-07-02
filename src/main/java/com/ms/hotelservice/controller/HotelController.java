package com.ms.hotelservice.controller;

import com.ms.hotelservice.entity.Hotel;
import com.ms.hotelservice.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hotel-service/api/hotels")
public class HotelController {

    @Autowired
    private IHotelService hotelService;

    @PostMapping("/hotel")
    public ResponseEntity<String> saveHotel(@RequestBody Hotel hotel){
        String responseMsg="";
        boolean isSaved = hotelService.saveHotel(hotel);
        if(isSaved)
            responseMsg="Hotel saved ....";
        else
            responseMsg="Hotel not saved ....";

        return ResponseEntity.status(HttpStatus.CREATED).body(responseMsg);
    }

    @GetMapping("/")
    public ResponseEntity<List<Hotel>> hotels(){
        List<Hotel> allHotels = hotelService.getAllHotels();
        if(!allHotels.isEmpty())
            return ResponseEntity.ok(allHotels);
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<Hotel> viewHotel(@PathVariable Long hotelId){
        Hotel hotelById = hotelService.getHotelById(hotelId);
        return ResponseEntity.ok(hotelById);
    }

    @DeleteMapping("/hotel/{hotelId}")
    public ResponseEntity<String> deleteHotel(@PathVariable Long hotelId){
        String responseMsg="";
        boolean isDeleted = hotelService.deleteHotelById(hotelId);
        if(isDeleted)
            responseMsg="Hotel deleted .....";
        else
            responseMsg="Hotel not deleted ....";
        return ResponseEntity.ok(responseMsg);
    }

    @PutMapping("/hotel/{hotelId}")
    public ResponseEntity<String> updateHotel(@PathVariable Long hotelId,@RequestBody Hotel hotel){
        String responseMsg="";
        boolean isUpdated = hotelService.updateHotel(hotelId, hotel);
        if(isUpdated)
            responseMsg="Hotel updated ....";
        else
            responseMsg="Hotel not updated ....";
        return ResponseEntity.ok(responseMsg);
    }
}
