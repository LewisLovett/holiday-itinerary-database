package com.nology.holidayitinerarydatabase;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidayRepository extends CrudRepository<Holiday, Long> {
}
