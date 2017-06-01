/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import gruppe03_electroshoppen.Store;
import gruppe03_electroshoppen.Customer;
import gruppe03_electroshoppen.Storage;
import gruppe03_electroshoppen.Employee;
import gruppe03_electroshoppen.Mediator;
import gruppe03_electroshoppen.Order;
import gruppe03_electroshoppen.Commodity;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Termproject - SI2-ORG-U1 - Group 3 (Spring 2017)
 */
public class LoadStores extends Loader {

    private List<Store> stores_list;
    private List<Employee> employees_list;
    //private List<Stock> lager_list;
    Mediator mediator;
    PostgreSQLConnection db = null;
    
    /**
	 * Loads customers in the system
	 *
	 * @param Mediator
	 */
    @Override
    public void load(Mediator ref_m) {
        this.db = new PostgreSQLConnection();
        this.mediator = ref_m;
        try {
            this.db.openDB();
            this.stores_list = this.db.getAllStores();
            this.employees_list = this.db.getAllEmployees();
            this.db.closeDB();
        } catch (SQLException ex) {
            Logger.getLogger(LoadStores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Store> getListOfStores() {
        if (this.stores_list == null) {
            return new ArrayList<Store>();
        }
        return this.stores_list;
    }

    public List<Employee> getListOfEmploee() {
        return this.employees_list;
    }
}
