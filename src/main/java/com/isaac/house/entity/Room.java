package com.isaac.house.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
public class Room {

    @Id
    @Column(name = "roomID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomID;

    @Column(name = "roomName")
    private String roomName;

    @Column(name = "isPublic")
    private Boolean isPublic;


}
