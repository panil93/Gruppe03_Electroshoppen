/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import gruppe03_electroshoppen.Customer;
import gruppe03_electroshoppen.Product;
import gruppe03_electroshoppen.Service;
import gruppe03_electroshoppen.Commodity;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
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
public class LoadCommodities extends Loader {
                   
    private List<Commodity> product_list = new ArrayList();
    PostgreSQLConnection db = null;
    
                  /**
	 * Loads commodities in the system
	 *
	 * 
	 */
    @Override
    public void load() {
        this.db = new PostgreSQLConnection();
        try {
            this.db.openDB();
            this.product_list = this.db.GetAllCommodities();
            this.db.closeDB();
        } catch (SQLException ex) {
            Logger.getLogger(LoadCommodities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Commodity> getProductKatalog() {
        return this.product_list;
    }
}
