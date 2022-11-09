package com.example.rrairline.service;

import com.example.rrairline.model.Destination;
import com.example.rrairline.repository.DestinationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DestinationService {

    private DestinationRepo destinationRepo;

    @Autowired
    public DestinationService(DestinationRepo destinationRepo){
        this.destinationRepo = destinationRepo;
    }

    public Destination addDestination(Destination destination){
        return destinationRepo.save(destination);
    }

    public Destination getDestinationByCity(String city){
        Optional<Destination> destination = destinationRepo.findDestinationByCity(city);

        if (!destination.isEmpty()){
            return destination.get();
        }
        return null;
    }
}
