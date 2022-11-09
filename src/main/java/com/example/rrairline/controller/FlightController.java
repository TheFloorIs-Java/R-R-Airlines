package com.example.rrairline.controller;

import com.example.rrairline.dto.FlightInfo;
import com.example.rrairline.model.Flight;
import com.example.rrairline.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class FlightController {

    private FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService){
        this.flightService = flightService;
    }

    @GetMapping("/api/flights/departure/{departure}")
    public List<Flight> getAllDeparturesByCity(@PathVariable("departure") String departure){
        return flightService.getFlightByDeparture(departure);
    }

    @GetMapping("/api/flights")
    public List<Flight> getAllDeparturesAndArrivalsByCity(@RequestBody FlightInfo flightInfo){
        return flightService.getFlightByDepartureAndArrival(flightInfo.getDeparture(), flightInfo.getArrival());
    }

}
