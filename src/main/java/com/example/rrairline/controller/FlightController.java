package com.example.rrairline.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.rrairline.dto.FlightInfo;
import com.example.rrairline.model.Flight;
import com.example.rrairline.service.FlightService;
@RestController
@CrossOrigin(origins = {"http://localhost:4200","https://rrairline.azurewebsites.net"})
public class FlightController {

    private FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService){
        this.flightService = flightService;
    }

    @PostMapping("/api/flights/departure")
    public ResponseEntity<List<Flight>> getAllDeparturesByCity(@RequestBody FlightInfo flightInfo){
    	List<Flight> list = new ArrayList<Flight>();
    	list = flightService.getFlightByDeparture(flightInfo.getDeparture());
        return new ResponseEntity<List<Flight>>(list, HttpStatus.OK);
    }

    @PostMapping("/api/flights")
    public ResponseEntity<List<Flight>> getAllDeparturesAndArrivalsByCity(@RequestBody FlightInfo flightInfo){
    	List<Flight> list = new ArrayList<Flight>();
    	list = flightService.getFlightByDepartureAndArrival(flightInfo.getDeparture(), flightInfo.getArrival());
        return new ResponseEntity<List<Flight>>(list, HttpStatus.OK);
    }

}
