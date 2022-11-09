package com.example.rrairline.repository;

import com.example.rrairline.model.Destination;
import com.example.rrairline.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface FlightRepo extends JpaRepository<Flight, Integer> {

    List<Flight> findAllByDeparture(Destination departure);

    List<Flight> findAllByArrivalAndDeparture(Destination arrival, Destination departure);


}
