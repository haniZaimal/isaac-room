package com.isaac.house.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Thing")
@Table(name = "Thing", schema = "isaac_house")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class Thing {

    @Id
    @Column(name = "thingID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long thingID;

    @Column(name = "thingsName")
    private String thingsName;

    @Column(name = "size")
    private int size;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "status")
    private String status;

    @Column(name = "drawerID")
    private long drawerID;
}
