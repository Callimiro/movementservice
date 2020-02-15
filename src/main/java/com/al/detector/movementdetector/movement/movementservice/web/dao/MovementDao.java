package com.al.detector.movementdetector.movement.movementservice.web.dao;

import com.al.detector.movementdetector.movement.movementservice.web.model.Movement;
import org.springframework.data.repository.CrudRepository;

public interface MovementDao extends CrudRepository<Movement,Integer> {
}
