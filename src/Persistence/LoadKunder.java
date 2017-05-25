/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import gruppe03_electroshoppen.Payment;
import gruppe03_electroshoppen.Kunde;
import gruppe03_electroshoppen.Mediator;
import gruppe03_electroshoppen.Order;
import gruppe03_electroshoppen.Reklamation;
import gruppe03_electroshoppen.Varer;
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
public class LoadKunder extends Loader {

	private List<Kunde> kunde_list;
	private List<Order> order_list;
	private List<Reklamation> reklamation_list;
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
				Logger.getLogger(LoadKunder.class.getName()).log(Level.SEVERE, null, ex1);
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
					Kunde kunde = new Kunde(fuldnavn, adresse, login, adgangskode, telefonnr);
					kunde_list.add(kunde);
					break;
				case "[Order]:":
					String[] key = scanner.nextLine().split(",");
					//int id =Integer.parseInt( scanner.nextLine());
					Kunde kundetilorder = mediator.getKundeByLogin(key[0]);
					int orderid = Integer.parseInt((key[1]));
					double orderPrice = Double.parseDouble((key[2]));
					List<Varer> listOfVarer = mediator.getListOfVarerById(scanner.nextLine());
					String placetiludlevering = scanner.nextLine();
					Order order = new Order(orderid, placetiludlevering, kundetilorder, orderPrice, listOfVarer);
					order_list.add(order);
					break;
				case "[Betaling]:":
					double beløb = Double.parseDouble(scanner.nextLine());
					Date dato = this.readDate(scanner);
					Kunde kunde0 = mediator.getKundeByLogin(scanner.nextLine());
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
					Kunde kund = mediator.getKundeByLogin(scanner.nextLine());
					List<Varer> var = mediator.getListOfVarerById(scanner.nextLine());
					Order ord = mediator.getOrderByid(scanner.nextLine());
					Reklamation reklamation = new Reklamation(årsag, dato0, erÅbnet, byttevare, id, kund, var, ord);
					reklamation_list.add(reklamation);
					break;

				default:
					break;
			}
		}
	}

	public List<Kunde> getListOfKunder() {
		return this.kunde_list;
	}

	public List<Order> getListOfOrder() {
		return this.order_list;
	}

	public List<Payment> getListOfBetalinger() {
		return this.betaling_list;
	}

	public List<Reklamation> getListOfReklamationer() {
		return this.reklamation_list;
	}
}
