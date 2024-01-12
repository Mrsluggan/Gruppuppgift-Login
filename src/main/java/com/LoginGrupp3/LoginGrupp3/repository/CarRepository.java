package com.LoginGrupp3.LoginGrupp3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.LoginGrupp3.LoginGrupp3.model.Car;

public interface CarRepository extends CrudRepository<Car, Integer> {
    
    //inte super på hur denna funkar? hittade den på stackoverflow... men den funkar :=) men som jag förstår WHERE c.id <> :currentCarId betyder typ kolla alla id som inte har akutella bilens id
    @Query(value = "SELECT c FROM Car c WHERE c.id <> :currentCarId ORDER BY RAND() LIMIT :numberOfCars")
    List<Car> findRandomCarsIncludingCurrent(@Param("numberOfCars") int numberOfCars, @Param("currentCarId") int currentCarId);

}