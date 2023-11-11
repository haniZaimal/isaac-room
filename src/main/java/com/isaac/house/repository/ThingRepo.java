package com.isaac.house.repository;

import com.isaac.house.entity.Thing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThingRepo extends JpaRepository<Thing, Long> {


}
