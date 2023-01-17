package com.nology.holidayItinerary.repository;

import com.nology.holidayItinerary.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findByImageId(Long id);

    @Transactional
    void deleteByHolidayId(long imageId);
}
