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
public class Insumo {
    
    private Long id;
    private String name;
    private String brand;
    private String category;
    private Integer qtd;
    
    public Insumo(){
        
    }

    public Insumo(Long id, String name, String brand, String category, Integer qtd) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.qtd = qtd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }
     
}
