/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppe03_electroshoppen;

import Persistence.LoadButikker;
import Persistence.LoadKunder;
import Persistence.LoadVarer;
import java.util.ArrayList;
import java.util.List;
import Persistence.Loader;
import java.util.HashMap;

/**
 *
 * @author Laura
 */
public class Mediator {
    LoadVarer l= new LoadVarer();
    LoadKunder k=new LoadKunder();
    LoadButikker lB = new LoadButikker();
    LoadButikker lB2 = new LoadButikker();
    List<Varer> produktkatalog = new ArrayList<Varer>();
List<Kunde> listofkunder = new ArrayList<Kunde>();
List<Medarbejder> medarblist = new ArrayList<Medarbejder>();
List<Butik> listofshops= new ArrayList<Butik>();
List<Underleverandør> listofunderleverandor=new ArrayList<Underleverandør>();
List<Order> listoforder= new ArrayList<Order>();
public Mediator(){
    l.load();
    k.load(this);
    lB.load(this);
}
public List<Varer>getListOfVarer(){
    
    return l.getProduktKatalog();
}
public List<Kunde>getListOfKunder(){
   return k.getListOfKunder();
}
public List<Medarbejder>getListOfMedarbeder(){
   return this.lB.getListOfMedarbejder(); 
}
public List<Butik>getListOfButikker(){
    return this.lB.getListOfButikker();
}
public List<Underleverandør>getListOfUnderleverandører(){
    return this.listofunderleverandor;
}
public List<Order> getListOfOrder(){
    return k.getListOfOrder();
}
public List<Betaling> getListOfBetalinger(){
    return k.getListOfBetalinger();
}
public List<Reklamation> getListOfReklamationer(){
    return k.getListOfReklamationer();
}

public Kunde getKundeByLogin(String login){
    List<Kunde> listeofkunde= k.getListOfKunder();
    for (Kunde kunde : listeofkunde){
        if(kunde.getLogin().compareTo(login) == 0){
            return kunde;
        }
    }
    return null;
}
public boolean IsEmpoloeeInSystem(String login, String adgangskode){
   for(Medarbejder m: medarblist) {
       if(m.getLogin().compareTo(login)==0&&m.getAdgangskode().compareTo(adgangskode)==0){
           return true;
       }
   }
   return false;
}
public Varer getVarerByid(String s){
  for (Varer v:produktkatalog){
       
   if(v.getId().compareTo(s) == 0){
       return v;
   }
    
}
return null;
}
public Order getOrderByid(String s){
    for(Order o:listoforder){
        if(o.getId()==Integer.parseInt(s)){
            return o;
        }
    }
    return null;
}
 public Varer getVarerById(String n){
     for(Varer v:produktkatalog){
        if(v.getId().compareTo(n)==0){
        
            return v;
         }
        
    }
    return null;   
    }
 public Medarbejder getMedarbejderByLogin(String l){
     for (Medarbejder m:medarblist){
         if(m.getLogin().compareTo(l)==0){
             return m;
         }
     }
     return null;
 }
 public Butik getButikByAdresse(String a){
     for (Butik b:listofshops){
         if(b.getAdresse().compareTo(a)==0){
             return b;
         }
     }
     return null;
 }
 public List<Varer> getListOfVarerById(String st){
     List <Varer> varelist = this.l.getProduktKatalog();
     String[] stringarray =st.split(",");
     for (int i=0;i<stringarray.length; i++){
         Varer v= this.getVarerById(stringarray[i]);     
     varelist.add(v);
     }
     return varelist;
 }
 public List<Order> getListOfOrder(String intowy){
     List<Order> orderlist = this.k.getListOfOrder();
     String [] strinkowaarray = intowy.split(",");
     for (int i=0;i<strinkowaarray.length;i++){
         Order orderek = this.getOrderByid((strinkowaarray[i]));
         orderlist.add(orderek);
     }
     return orderlist;
 }
public List<Medarbejder> getListOfMedarbejderByLogin(String str){
   List<Medarbejder> medarbliste = new ArrayList<>();
   String[] stringarray =str.split(",");
   for (int i=0;i<stringarray.length; i++){
       Medarbejder m = this.getMedarbejderByLogin(stringarray[i]);
       medarbliste.add(m);
   }
   return medarbliste;
}
public Kunde getKundeByLoginAndPassword(String log, String pass){
    for(Kunde kund: k.getListOfKunder()){
        if((kund.getLogin().compareTo(log) == 0)&&(kund.getAdgangskode().compareTo(pass)==0)){
            return kund;
        }
    }
    return null;
}
public Kunde getKundeByOrder(int ordernrnr){
    for(Order ordi: k.getListOfOrder()){
        if(ordi.getId()==ordernrnr){
            return ordi.getKunde();
        }
    }
    return null;
}
public List<Order> getAllOrdersByKunde(Kunde kundzik){
    List<Order> orderlist0 =new ArrayList<>();
    for(Order ord: this.getListOfOrder()){
        if(ord.getKunde() == kundzik){
        orderlist0.add(ord);
    }
    }
    return orderlist0;
}
}
