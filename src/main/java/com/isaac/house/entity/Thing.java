package com.isaac.house.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private int thingID;

    @Column(name = "thingsName")
    private String thingsName;

    @Column(name = "size")
    private int size;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "status")
    private int status;

    @Column(name = "drawerID")
    private int drawerID;
}
