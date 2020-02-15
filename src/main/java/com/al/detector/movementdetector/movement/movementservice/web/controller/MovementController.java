package com.al.detector.movementdetector.movement.movementservice.web.controller;

import com.al.detector.movementdetector.movement.movementservice.web.dao.MovementDao;
import com.al.detector.movementdetector.movement.movementservice.web.model.Movement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class MovementController {

    @Autowired
    public MovementDao movementDao;

    @RequestMapping(value = "/Movement",method = GET)
    public boolean getMovement(){
        Iterable<Movement> all = movementDao.findAll();
        int id = 0;
        Date date ;
        boolean state = false;
        for (Movement movement : all) {
            if (id == 0) {
                id = movement.getId();
                date = movement.getUpdatetime();
                state = movement.isState();
            } else {
                if (movement.getId()>id){
                    id = movement.getId();
                    date = movement.getUpdatetime();
                    state = movement.isState();
                }
            }
        }

        return state;
    }

    @RequestMapping(value = "/Movement/{state}",method = POST)
    public void setMovement(@PathVariable String state){
        long millis=System.currentTimeMillis();
        Date date = new Date(millis);
        boolean s ;
        if(state.equals("true")){
            s = true;
        } else{
            s = false;
        }
        System.out.println(s);
        Movement movement = new Movement(s,date);
        movementDao.save(movement);
    }

}
