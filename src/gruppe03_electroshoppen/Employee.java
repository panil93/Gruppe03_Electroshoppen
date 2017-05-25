/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppe03_electroshoppen;

/**
 *
 * @author Termproject - SI2-ORG-U1 - Group 3 (Spring 2017)
 */
public class Employee {

	private String fuldnavn;
	private String login;
	private String adgangskode;
	private String type;

	public Employee(String fuldnavn, String login, String adgangskode, String type) {
		this.fuldnavn = fuldnavn;
		this.login = login;
		this.adgangskode = adgangskode;
		this.type = type;
	}

	public String getLogin() {
		return this.login;
	}

	public String getAdgangskode() {
		return this.adgangskode;
	}

}
