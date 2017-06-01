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
 * @author Termproject - SI2-ORG-U1 - Group 3 (Spring 2017)
 */
public class LoadCustomers extends Loader {

    private List<Customer> customers_list;
    private List<Order> orders_list;
    private List<Reclamation> reclamations_list;
    private List<Payment> payments_list;
    Mediator mediator;
        PostgreSQLConnection db = null;
        
        /**
	 * Loads customers in the system
	 *
	 * @param Mediator
	 */
    @Override
    public void load(Mediator ref_m) {
        this.mediator = ref_m;
        this.db = new PostgreSQLConnection();
        try {
            this.db.openDB();
            this.customers_list = this.db.getAllCustomers();
            this.orders_list = this.db.GetAllOrders();
            this.reclamations_list = this.db.getAllReclamations(this.mediator);
            this.payments_list = this.db.GetAllPayments(ref_m);
            this.db.closeDB();
        } catch (SQLException ex) {
            Logger.getLogger(LoadCustomers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List <Customer> getListOfCustomers(){ 
        return this.customers_list;
    }
    public List<Order> getListOfOrders(){
        return this.orders_list;
    }
    public List<Payment> getListOfPayments(){
        return this.payments_list;
    }
    public List <Reclamation> getListOfReclamations(){
        return this.reclamations_list;
    }
    public boolean addNewReclamation(Reclamation reclamation) throws SQLException
    {
        this.reclamations_list.add(reclamation);
        this.db.openDB();
        this.db.insertNewReclamation(reclamation);
        this.db.closeDB();
        
        return true;
    }
    public boolean addNewOrder(Order order) throws SQLException
    {
        this.db.openDB();
        this.orders_list.add(order);
        this.db.insertNewOrder(order);
        this.db.closeDB();
        return true;
    }
}
