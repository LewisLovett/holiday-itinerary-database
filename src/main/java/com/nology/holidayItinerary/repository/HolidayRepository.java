package com.nology.holidayItinerary.repository;

import com.nology.holidayItinerary.model.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HolidayRepository extends JpaRepository<Holiday, Long> {
    List<Holiday> findByLocation(String location);

    List<Holiday> findByAuthor(String author);
}




