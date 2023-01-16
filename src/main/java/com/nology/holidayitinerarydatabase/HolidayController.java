package com.nology.holidayitinerarydatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/holiday")
public class HolidayController {

    @Autowired
    private HolidayRepository holidayRepository;

    @GetMapping
    public List<Holiday> findAllHolidays(){
        return (List<Holiday>) holidayRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Holiday> findHolidayById(@PathVariable(value = "id") long id){
        Optional<Holiday> holiday = holidayRepository.findById(id);

        if(holiday.isPresent()){
            return ResponseEntity.ok().body(holiday.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Holiday saveHoliday(@Validated @RequestBody Holiday holiday){
        return holidayRepository.save(holiday);
    }
}
