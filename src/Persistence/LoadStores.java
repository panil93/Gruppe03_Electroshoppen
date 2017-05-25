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

	private List<Store> butikker_list;
	private List<Employee> medarbejder_list;
	private List<Storage> lager_list;
	Mediator mediator;

	@Override
	public void load(Mediator ref_m) {
		this.mediator = ref_m;
		this.lager_list = new ArrayList();
		this.medarbejder_list = new ArrayList();
		this.lager_list = new ArrayList();
		this.butikker_list = new ArrayList();
		File file = new File("butikker.txt");
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
			String test = scanner.nextLine();
			switch (test) {
				case "[Medarbejder]:":
					String fuldnavn = scanner.nextLine();
					String login = scanner.nextLine();
					String adgangskode = scanner.nextLine();
					String type = scanner.nextLine();

					Employee medarbejder = new Employee(fuldnavn, login, adgangskode, type);
					medarbejder_list.add(medarbejder);
					break;
				case "[Butik]:":
					String adresse = scanner.nextLine();
					String mail = scanner.nextLine();
					List<Employee> medarbejderList = mediator.getListOfMedarbejderByLogin(scanner.nextLine());
					Store butik = new Store(adresse, mail, medarbejderList);
					butikker_list.add(butik);

					break;
				case "[Lager]:":
					Store butik0 = mediator.getButikByAdresse(scanner.nextLine());
					List<Commodity> varerpålager = mediator.getListOfVarerById(scanner.nextLine());
					Storage lager = new Storage(butik0, varerpålager);
					lager_list.add(lager);
				default:
					break;
			}
		}
	}

	public List<Store> getListOfButikker() {

		if (this.butikker_list == null) {

			return new ArrayList<Store>();

		}

		return this.butikker_list;
	}

	public List<Employee> getListOfMedarbejder() {

		return this.medarbejder_list;
	}
}
