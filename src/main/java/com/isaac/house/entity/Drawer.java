package com.isaac.house.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Drawer")
@Table(name = "Drawer", schema = "isaac_house")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Drawer {

    @Id
    @Column(name = "drawerID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int drawerID;

    @Column(name = "category")
    private String category;

    @Column(name = "roomID")
    private int roomID;

}
