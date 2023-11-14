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
        Ong ong1 = new Ong(1L, "2324455", "Agencia cachorro lovers", "dogLovers@gmail.com", "5555-5555", "@doglove");
        Ong ong2 = new Ong(2L, "2324455", "PET MALUCO", "dogCrazyes@gmail.com", "5555-5555", "@dogcrazy");
        
        save(ong1);
        save(ong2);
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
    
    public static void update(Ong o){
        for (Ong oAux: ongs){
            if (oAux.getId().equals(o.getId())){
                oAux.setCnpj(o.getCnpj());
                oAux.setName(o.getName());
                oAux.setLogin(o.getLogin());
                oAux.setPassword(o.getPassword());
                oAux.setEmail(o.getEmail());
                oAux.setPhone(o.getPhone());
                oAux.setInstagram(o.getInstagram());
                return;
            }
        }                 
    }
    
    public static void delete (Ong o){
        ongs.remove(o);
    }
    
}
