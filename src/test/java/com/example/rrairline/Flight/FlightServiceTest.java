package com.example.rrairline.Flight;


import com.example.rrairline.model.Destination;
import com.example.rrairline.model.Flight;
import com.example.rrairline.service.FlightService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;

import java.util.Date;

@SpringBootTest
public class FlightServiceTest {

    @Autowired
    FlightService flightService;

    @Disabled
    public void testAddFlights(){
        Date date = new Date();
        Destination depart = Destination.builder().destinationId(1).build();
        Destination arrival = Destination.builder().destinationId(6).build();
        Flight flight =Flight.builder()
                .flightNo("RR858")
                .departure(depart)
                .arrival(arrival)
                .date(date)
                .build();
        System.out.println(flight);
        flightService.addFlight(flight);
    }

    @Test
    public void testGetFlightByDeparture(){
        String city = "Houston";
        System.out.println(flightService.getFlightByDeparture(city));
    }

    @Test
    public void testGetFlightByDepartureAndArrival(){
        String depart = "Houston";
        String arrival = "Las Vegas";
        System.out.println(flightService.getFlightByDepartureAndArrival(depart, arrival));
    }

}
