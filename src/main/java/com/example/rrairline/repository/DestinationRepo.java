package com.example.rrairline.repository;

import com.example.rrairline.model.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DestinationRepo extends JpaRepository<Destination, Integer> {

    Optional<Destination> findDestinationByCity(String city);

}
