/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import gruppe03_electroshoppen.Payment;
import gruppe03_electroshoppen.Customer;
import gruppe03_electroshoppen.Mediator;
import gruppe03_electroshoppen.Order;
import gruppe03_electroshoppen.Reclamation;
import gruppe03_electroshoppen.Commodity;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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

	private List<Customer> kunde_list;
	private List<Order> order_list;
	private List<Reclamation> reklamation_list;
	private List<Payment> betaling_list;
	Mediator mediator;

	@Override
	public void load(Mediator ref_m) {
		this.mediator = ref_m;
		this.kunde_list = new ArrayList(); //husk at init variabler
		this.order_list = new ArrayList();
		this.reklamation_list = new ArrayList();
		this.betaling_list = new ArrayList();
		File file = new File("kunder.txt");
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException ex) {
			try {

				file.createNewFile();
			} catch (IOException ex1) {
				Logger.getLogger(LoadCustomers.class.getName()).log(Level.SEVERE, null, ex1);
				return;
			}
		}

		while (scanner.hasNextLine()) {
			switch (scanner.nextLine()) {
				case "[Kunde]:":
					String fuldnavn = scanner.nextLine();
					;
					String adresse = scanner.nextLine();
					;
					String login = scanner.nextLine();
					;
					String adgangskode = scanner.nextLine();
					;
					int telefonnr = Integer.parseInt(scanner.nextLine());
					Customer kunde = new Customer(fuldnavn, adresse, login, adgangskode, telefonnr);
					kunde_list.add(kunde);
					break;
				case "[Order]:":
					String[] key = scanner.nextLine().split(",");
					//int id =Integer.parseInt( scanner.nextLine());
					Customer kundetilorder = mediator.getKundeByLogin(key[0]);
					int orderid = Integer.parseInt((key[1]));
					double orderPrice = Double.parseDouble((key[2]));
					List<Commodity> listOfVarer = mediator.getListOfVarerById(scanner.nextLine());
					String placetiludlevering = scanner.nextLine();
					Order order = new Order(orderid, placetiludlevering, kundetilorder, listOfVarer);
					order_list.add(order);
					break;
				case "[Betaling]:":
					double beløb = Double.parseDouble(scanner.nextLine());
					Date dato = this.readDate(scanner);
					Customer kunde0 = mediator.getKundeByLogin(scanner.nextLine());
					;
					Order orderek = mediator.getOrderByid(scanner.nextLine());
					Payment betaling = new Payment(beløb, dato, kunde0, orderek);
					betaling_list.add(betaling);
					break;
				case "[Reklamation]:":
					String årsag = scanner.nextLine();
					Date dato0 = this.readDate(scanner);
					boolean erÅbnet = Boolean.parseBoolean(scanner.nextLine());
					String byttevare = scanner.nextLine();
					int id = Integer.parseInt(scanner.nextLine());
					Customer kund = mediator.getKundeByLogin(scanner.nextLine());
					List<Commodity> var = mediator.getListOfVarerById(scanner.nextLine());
					Order ord = mediator.getOrderByid(scanner.nextLine());
					Reclamation reklamation = new Reclamation(årsag, dato0, erÅbnet, byttevare, id, kund, var, ord);
					reklamation_list.add(reklamation);
					break;

				default:
					break;
			}
		}
	}

	public List<Customer> getListOfKunder() {
		return this.kunde_list;
	}

	public List<Order> getListOfOrder() {
		return this.order_list;
	}

	public List<Payment> getListOfBetalinger() {
		return this.betaling_list;
	}

	public List<Reclamation> getListOfReklamationer() {
		return this.reklamation_list;
	}
}
