/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import gruppe03_electroshoppen.Betaling;
import gruppe03_electroshoppen.Butik;
import gruppe03_electroshoppen.Kunde;
import gruppe03_electroshoppen.Medarbejder;
import gruppe03_electroshoppen.Mediator;
import gruppe03_electroshoppen.Order;
import gruppe03_electroshoppen.Reklamation;
import gruppe03_electroshoppen.Salg;
import gruppe03_electroshoppen.Underleverandør;
import gruppe03_electroshoppen.Varer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Laura
 */
public class Loader {
     
   public Loader(){
       
       
   }
    public void load() {
        new LoadKunder();
        new LoadVarer();
        new LoadButikker();
    }
    public void load(Mediator ref_m)
    {
        
    }
     public Date readDate(Scanner scanner) {
    String dateFormat = "dd/MM/yyyy";
    
        try {
            return new SimpleDateFormat(dateFormat).parse(scanner.nextLine());
        } catch (ParseException ex) {
            Logger.getLogger(LoadVarer.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }}
}
