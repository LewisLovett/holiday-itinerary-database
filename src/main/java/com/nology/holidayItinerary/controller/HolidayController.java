package com.nology.holidayItinerary.controller;

import com.nology.holidayItinerary.model.Holiday;
import com.nology.holidayItinerary.repository.HolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.ArrayList;
import java.util.List;



@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8080"})
@RequestMapping("/api")
public class HolidayController {

    @Autowired
    HolidayRepository holidayRepository;

    @GetMapping("/holidays")
    public ResponseEntity<List<Holiday>> getHolidays(){

        List<Holiday> holidays = new ArrayList<Holiday>();
        holidayRepository.findAll().forEach(holidays::add);

        if (holidays.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(holidays, HttpStatus.OK);

    }

    @GetMapping("/holidays/{id}")
    public ResponseEntity<Holiday> getHolidayById(@PathVariable("id") long id) {
       Holiday holiday = holidayRepository.findById(id)
               .orElseThrow(() -> new ResourceAccessException("Not found Tutorial with id = " + id));;
        return new ResponseEntity<>(holiday, HttpStatus.OK);
    }

    @PostMapping("/holiday")
    public ResponseEntity<Holiday> createHoliday(@RequestBody Holiday holiday) {
        Holiday _holiday = holidayRepository.save(new Holiday(holiday.getLocation(), holiday.getDate(),holiday.getAuthor(),holiday.getDescription()));
        return new ResponseEntity<>(_holiday, HttpStatus.CREATED);
    }
}
