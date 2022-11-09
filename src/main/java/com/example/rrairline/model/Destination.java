package com.example.rrairline.model;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int destinationId;

    @Column()
    private String city;

    @Column()
    private String state;

    @Column()
    private String country;

}
