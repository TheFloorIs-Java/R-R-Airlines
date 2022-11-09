package com.example.rrairline.Destination;

import com.example.rrairline.model.Destination;
import com.example.rrairline.service.DestinationService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DestinationServiceTest {

    @Autowired
    DestinationService destinationService;

    @Disabled
    public void testAddDestination(){
        Destination destination = Destination.builder()
                .state("Nevada")
                .city("Las Vegas")
                .country("USA")
                .build();

        System.out.println(destination);
        destinationService.addDestination(destination);

    }
}
