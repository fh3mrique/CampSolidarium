/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.filipeatividade.entities;

import java.util.Date;

/**
 *
 * @author adm
 */
public class Campaign {
    
    private Long id;
    private Date start;
    private Date end;
    private String objective;
    private String description;
    private Ong ong;
    private Insumo insumo;
    private Emergency emergency;
    
    public Campaign(){
        
    }

    public Campaign(Long id, Date start, Date end, String objective, String description, Ong ong, Insumo insumo, Emergency emergency) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.objective = objective;
        this.description = description;
        this.ong = ong;
        this.insumo = insumo;
        this.emergency = emergency;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Ong getOng() {
        return ong;
    }

    public void setOng(Ong ong) {
        this.ong = ong;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public Emergency getEmergency() {
        return emergency;
    }

    public void setEmergency(Emergency emergency) {
        this.emergency = emergency;
    }
    
}
