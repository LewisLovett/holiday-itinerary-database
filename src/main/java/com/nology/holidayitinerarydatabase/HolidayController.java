package com.nology.holidayitinerarydatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8080"})
public class HolidayController {

    @Autowired
    HolidayService holidayService;

    @GetMapping("/holidays")
    public ResponseEntity<List<Holiday>> getHolidays( @RequestParam(defaultValue = "10") int limit){


        return ResponseEntity.status(HttpStatus.OK).body(holidayService.getHolidays(limit));

    }

    @GetMapping("/holidays/{id}")
    public ResponseEntity<Holiday> findHolidayById(@PathVariable(value = "id") long id){
        return ResponseEntity.status(HttpStatus.OK).body(holidayService.getHolidayById(id));



    }

    @PostMapping("/holiday")
    public ResponseEntity<Holiday> saveHoliday(@RequestBody Holiday holiday){
        holidayService.addHoliday(holiday);
        return ResponseEntity.status(HttpStatus.CREATED).body(holiday);

    }
}
