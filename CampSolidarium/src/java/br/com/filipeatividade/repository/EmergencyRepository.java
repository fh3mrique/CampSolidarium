/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.filipeatividade.repository;

import br.com.filipeatividade.entities.Emergency;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adm
 */
public class EmergencyRepository {
    public static List<Emergency> emergencies = null;
    
    static {
        emergencies = new ArrayList<>();
        Emergency emergency1 = new Emergency(1L, "IFPE", "TIPO 1", "O cachorro matou um aluno", "LEVE");
        Emergency emergency2 = new Emergency(2L, "Minha CASA", "DIABETE TIPO 2", "Meu cachorro está programando em jsp", "ALTO");

        save(emergency1);
        save(emergency2);
    } 
    
    public static Emergency find(Long id){
        for(Emergency eAux: emergencies){
            if (eAux.getId().equals(id)){
                return eAux;
            }
        }
        return null;
    }
    
    public static List<Emergency> findAll(){
        return emergencies;
    }
    
    public static void save (Emergency insumo){
        emergencies.add(insumo);
    }
    
    public static void update(Emergency e){
        for (Emergency eAux: emergencies){
            if (eAux.getId().equals(e.getId())){
                eAux.setLocal(e.getLocal());
                eAux.setType(e.getType());
                eAux.setDescription(e.getDescription());
                eAux.setSeverityLevel(e.getSeverityLevel());
                return;
            }
        }                 
    }
    
    public static void delete (Emergency e){
        emergencies.remove(e);
    }
    
}
