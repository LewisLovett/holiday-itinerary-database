package com.nology.holidayitinerarydatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HolidayService {

    @Autowired
    HolidayRepository holidayRepository;

    public void addHoliday(Holiday holiday){
        holidayRepository.save(holiday);
    }

    public Holiday getHolidayById(long id){
        Optional<Holiday> holiday = holidayRepository.findById(id);

        if(holiday.isEmpty()){
            //EXEPTION!!!!!!!
        }
        return holiday.get();
    }

    public List<Holiday> getAllHolidays(int limit){
        return holidayRepository.findAll().stream().limit(limit).collect((Collectors.toList()));
    }


}
