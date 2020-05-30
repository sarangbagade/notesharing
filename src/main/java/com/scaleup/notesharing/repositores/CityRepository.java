package com.scaleup.notesharing.repositores;

import com.scaleup.notesharing.models.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
