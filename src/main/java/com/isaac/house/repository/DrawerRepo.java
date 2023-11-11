package com.isaac.house.repository;

import com.isaac.house.entity.Drawer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrawerRepo extends JpaRepository<Drawer,Long> {
}
