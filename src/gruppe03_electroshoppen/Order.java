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
public class Order {
    private int id;
    List<Varer> listonorder;
    private String stedtiludlevering;
    Kunde kunde;
    List<Varer>listOfVarer;
    private double orderPrice;
    
public Order(int id,String stedtiludlevering, Kunde kunde, double orderPrice, List<Varer>listOfVarer){
    this.id = id;
    this.listonorder =  new ArrayList<>();
    this.stedtiludlevering =stedtiludlevering;
    this.orderPrice = orderPrice;
    
}
public List<Varer> getVarer(){
    return this.listonorder;
}
public int getId(){
    return this.id;
}
public double getTotalPris(List <Varer> l){
    double totalPrice=0;
    for(Varer v : l){
        double a= v.getPris();
        totalPrice+=a;
    }
    return totalPrice;
}
public String getStedttilUdlevering(){
    return this.stedtiludlevering;
}
public Kunde getKunde(){
    return this.kunde;
}
@Override
public String toString(){
    return String.valueOf(this.id);
}
}
