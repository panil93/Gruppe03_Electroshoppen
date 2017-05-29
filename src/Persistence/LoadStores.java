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
 * @author Laura
 */
public class LoadStores extends Loader {

    private List<Store> butikker_list;
    private List<Employee> medarbejder_list;
    //private List<Stock> lager_list;
    Mediator mediator;
    PostgreSQLConnection db = null;
    @Override
    public void load(Mediator ref_m) {
        this.db = new PostgreSQLConnection();
        this.mediator = ref_m;
        try {
            this.db.openDB();
            this.butikker_list = this.db.getAllShops();
            this.medarbejder_list = this.db.getAllEmploee();
            this.db.closeDB();
        } catch (SQLException ex) {
            Logger.getLogger(LoadStores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Store> getListOfShops() {
        if (this.butikker_list == null) {
            return new ArrayList<Store>();
        }
        return this.butikker_list;
    }

    public List<Employee> getListOfEmploee() {
        return this.medarbejder_list;
    }
}
