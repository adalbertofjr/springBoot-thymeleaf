package com.adalbertofjr.WebApp.repository;

import com.adalbertofjr.WebApp.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
