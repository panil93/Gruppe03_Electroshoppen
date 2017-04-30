/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppe03_electroshoppen;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Laura
 */
public class Reklamation {
    private String årsag;
    private Date dato;
    private boolean erÅbnet;
    private String byttevare;
    private int id;
    Kunde kunde;
    List<Varer> varerTilBytte;
    Order order;
public Reklamation(String årsag, Date dato, boolean erÅbnet, String byttevare, int id, Kunde kunde,List<Varer> varerTilBytte,Order order){
    this.årsag=årsag;
    this.dato = dato;
    this.erÅbnet = erÅbnet;
    this.byttevare = byttevare;
    this.id = id;
}
    
}
