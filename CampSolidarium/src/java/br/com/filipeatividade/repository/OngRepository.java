/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.filipeatividade.repository;

import br.com.filipeatividade.entities.Ong;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adm
 */
public class OngRepository {
    
    public static List<Ong> ongs = null;
    
    static {
        ongs = new ArrayList<>();
    } 
    
    public static Ong find(Long id){
        for(Ong oAux: ongs){
            if (oAux.getId().equals(id)){
                return oAux;
            }
        }
        return null;
    }
    
    public static List<Ong> findAll(){
        return ongs;
    }
    
    public static void save (Ong ong){
        ongs.add(ong);
    }
    
    public static void update(Ong e){
        for (Ong oAux: ongs){
            if (oAux.getId().equals(e.getId())){
                oAux.setCnpj(e.getCnpj());
                oAux.setName(e.getName());
                oAux.setLogin(e.getLogin());
                oAux.setPassword(e.getPassword());
                oAux.setEmail(e.getEmail());
                oAux.setPhone(e.getPhone());
                oAux.setInstagram(e.getInstagram());
                return;
            }
        }                 
    }
    
    public static void delete (Ong o){
        ongs.remove(o);
    }
    
}
