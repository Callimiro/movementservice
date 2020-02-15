
package com.al.detector.movementdetector.movement.movementservice.web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Movement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean state;
    private Date updatetime;

    public Movement() {
    }

    public Movement(boolean state, Date updatetime) {
        this.setState(state);
        this.setUpdatetime(updatetime);
    }
    public Movement(int id,boolean state,Date updatetime) {
        this.setId(id);
        this.setState(state);
        this.setUpdatetime(updatetime);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}
