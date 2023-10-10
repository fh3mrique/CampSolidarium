/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.filipeatividade.entities;

/**
 *
 * @author adm
 */
public class Emergency {
    
    private Long id;
    private String local;
    private String type;
    private String description;
    private String severityLevel;
    
    public Emergency(){
        
    }

    public Emergency(Long id, String local, String type, String description, String severityLevel) {
        this.id = id;
        this.local = local;
        this.type = type;
        this.description = description;
        this.severityLevel = severityLevel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSeverityLevel() {
        return severityLevel;
    }

    public void setSeverityLevel(String severityLevel) {
        this.severityLevel = severityLevel;
    }
}
