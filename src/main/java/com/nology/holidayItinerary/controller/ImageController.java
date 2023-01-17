package com.nology.holidayItinerary.controller;

import com.nology.holidayItinerary.model.Image;
import com.nology.holidayItinerary.repository.HolidayRepository;
import com.nology.holidayItinerary.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8080"})
@RestController
@RequestMapping("/api")
public class ImageController {
    @Autowired
    private HolidayRepository holidayRepository;

    @Autowired
    private ImageRepository imageRepository;

    @GetMapping("/holidays/{holidayId}/images")
    public ResponseEntity<List<Image>> getAllImagesByHolidayId(@PathVariable(value = "holidayId") Long holidayId) {
        if (!holidayRepository.existsById(holidayId)) {
            throw new ResourceAccessException("Not found Tutorial with id = " + holidayId);
        }

        List<Image> images = imageRepository.findByHolidayId(holidayId);
        return new ResponseEntity<>(images, HttpStatus.OK);
    }

    @PostMapping("/holidays/{holidayId}/images")
    public ResponseEntity<Image> createImage(@PathVariable(value = "holidayId") Long holidayId,
                                                 @RequestBody Image imageRequest) {
        Image image = holidayRepository.findById(holidayId).map(holiday -> {
            imageRequest.setHoliday(holiday);
            return imageRepository.save(imageRequest);
        }).orElseThrow(() -> new ResourceAccessException("Not found Tutorial with id = " + holidayId));

        return new ResponseEntity<>(image, HttpStatus.CREATED);
    }


}

