/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import gruppe03_electroshoppen.Payment;

import gruppe03_electroshoppen.Store;
import gruppe03_electroshoppen.Customer;
import gruppe03_electroshoppen.Employee;
import gruppe03_electroshoppen.Mediator;
import gruppe03_electroshoppen.Order;
import gruppe03_electroshoppen.Campaign;

import gruppe03_electroshoppen.Subsupplier;
import gruppe03_electroshoppen.Commodity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Termproject - SI2-ORG-U1 - Group 3 (Spring 2017)
 */
public class Loader {

	public Loader() {

	}

	public void load() {
		new LoadStores();
		new LoadCommodities();
		new LoadCustomers();
	}

	public void load(Mediator ref_m) {

	}

	public Date readDate(Scanner scanner) {
		String dateFormat = "dd/MM/yyyy";

		try {
			return new SimpleDateFormat(dateFormat).parse(scanner.nextLine());
		} catch (ParseException ex) {
			Logger.getLogger(LoadCommodities.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}
}
