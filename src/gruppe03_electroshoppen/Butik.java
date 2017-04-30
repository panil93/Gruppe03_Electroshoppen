/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppe03_electroshoppen;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Laura
 */
public class Butik {
    private String adresse;
    private String mail;
    private List<Medarbejder> medarbejderList;

    public Butik(String adresse, String mail,List<Medarbejder> medarbejderList) {
        this.adresse = adresse;
        this.mail = mail;
        
    }
    public String getAdresse(){
        return this.adresse;
    }
    
}
