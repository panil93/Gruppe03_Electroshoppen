/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;


import gruppe03_electroshoppen.Customer;
import gruppe03_electroshoppen.Mediator;
import gruppe03_electroshoppen.Order;
import gruppe03_electroshoppen.Payment;
import gruppe03_electroshoppen.Reclamation;
import gruppe03_electroshoppen.Commodity;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Laura
 */
public class LoadCustomers extends Loader {

    private List<Customer> kunde_list;
    private List<Order> order_list;
    private List<Reclamation> reklamation_list;
    private List<Payment> betaling_list;
    Mediator mediator;
        PostgreSQLConnection db = null;
    @Override
    public void load(Mediator ref_m) {
        this.mediator = ref_m;
        this.db = new PostgreSQLConnection();
        try {
            this.db.openDB();
            this.kunde_list = this.db.getAllClients();
            this.order_list = this.db.GetAllOrders();
            this.reklamation_list = this.db.getAllComplaints(this.mediator);
            this.betaling_list = this.db.GetAllPayments(ref_m);
            this.db.closeDB();
        } catch (SQLException ex) {
            Logger.getLogger(LoadCustomers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List <Customer> getListOfClients(){ 
        return this.kunde_list;
    }
    public List<Order> getListOfOrder(){
        return this.order_list;
    }
    public List<Payment> getListOfPayments(){
        return this.betaling_list;
    }
    public List <Reclamation> getListOfComplaints(){
        return this.reklamation_list;
    }
    public boolean addNewReclamation(Reclamation r) throws SQLException
    {
        this.reklamation_list.add(r);
        this.db.openDB();
        this.db.insertNewReclamation(r);
        this.db.closeDB();
        
        return true;
    }
    public boolean addNewOrder(Order o) throws SQLException
    {
        this.db.openDB();
        this.order_list.add(o);
        this.db.insertNewOrder(o);
        this.db.closeDB();
        return true;
    }
}
