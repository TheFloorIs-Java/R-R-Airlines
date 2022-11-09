package com.example.rrairline.model;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int flightId;

    @Column
    private Date date;

    @ManyToOne
    @JoinColumn(
            name = "departureId",
            referencedColumnName = "destinationId"
    )
    private Destination departure;

    @ManyToOne
    @JoinColumn(
            name = "arrivalId",
            referencedColumnName = "destinationId"
    )
    private Destination arrival;

    @Column
    private String flightNo;

}
