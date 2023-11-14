/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.filipeatividade.repository;

import br.com.filipeatividade.entities.Insumo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adm
 */
public class InsumoRepository {
    
    public static List<Insumo> insumos = null;
    
    static {
        insumos = new ArrayList<>();
        Insumo insumo1 = new Insumo(1L, "Insumo 1", "Marca 1", "Categoria A", 10);
        Insumo insumo2 = new Insumo(2L, "Insumo 2", "Marca 2", "Categoria B", 20);

        save(insumo1);
        save(insumo2);
    }
    
    
    public static Insumo find(Long id){
        for(Insumo iAux: insumos){
            if (iAux.getId().equals(id)){
                return iAux;
            }
        }
        return null;
    }
    
    public static List<Insumo> findAll(){
        return insumos;
    }
    
    public static void save (Insumo insumo){
        insumos.add(insumo);
    }
    
    public static void update(Insumo i){
        for (Insumo iAux: insumos){
            if (iAux.getId().equals(i.getId())){
                iAux.setName(i.getName());
                iAux.setBrand(i.getBrand());
                iAux.setCategory(i.getCategory());
                iAux.setQtd(i.getQtd());
                return;
            }
        }                 
    }
    
    public static void delete (Insumo i){
        insumos.remove(i);
    }
    
}
