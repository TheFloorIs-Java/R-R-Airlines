package com.example.rrairline.service;

import com.example.rrairline.model.Destination;
import com.example.rrairline.model.Flight;
import com.example.rrairline.repository.FlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    private FlightRepo flightRepo;
    private DestinationService destinationService;

    @Autowired
    public FlightService(FlightRepo flightRepo, DestinationService destinationService){
        this.flightRepo = flightRepo;
        this.destinationService = destinationService;

    }

    public Flight addFlight(Flight flight){
        return flightRepo.save(flight);
    }

    public List<Flight> getFlightByDeparture(String departure){
        Destination destination = destinationService.getDestinationByCity(departure);
        if (destination == null){
            return null;
        }
        return flightRepo.findAllByDeparture(destination); //make changes
    }

    public List<Flight> getFlightByDepartureAndArrival(String departure, String arrival){
        Destination dep = destinationService.getDestinationByCity(departure);
        Destination arr = destinationService.getDestinationByCity(arrival);

        if (dep == null || arr == null){
            return null;
        }

        return flightRepo.findAllByArrivalAndDeparture(arr, dep);
    }


}
