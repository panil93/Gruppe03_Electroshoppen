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
 * @author Termproject - SI2-ORG-U1 - Group 3 (Spring 2017)
 */
public class Store {

	private String adresse;
	private String mail;
	private List<Employee> medarbejderList;

	public Store(String adresse, String mail, List<Employee> medarbejderList) {
		this.adresse = adresse;
		this.mail = mail;

	}

	public String getAdresse() {
		return this.adresse;
	}

}
