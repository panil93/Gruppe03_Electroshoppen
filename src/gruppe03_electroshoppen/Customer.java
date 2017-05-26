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
public class Customer {

	private String fuldnavn;
	private String adresse;
	private String login;
	private String adgangskode;
	private int telefonnr;

	/**
	 *
	 *
	 * @param
	 */
	public Customer(String fuldnavn, String adresse, String login, String adgangskode, int telefonnr) {

		this.fuldnavn = fuldnavn;
		this.adresse = adresse;
		this.login = login;
		this.adgangskode = adgangskode;
		this.telefonnr = telefonnr;
	}

	/**
	 *
	 *
	 */
	public String getLogin() {

		return this.login;

	}

	/**
	 *
	 *
	 */
	public String getName() {
		
		return this.fuldnavn;
		
	}

	/**
	 *
	 *
	 */
	public String getAdresse() {
		
		return this.adresse;
		
	}

	/**
	 *
	 *
	 */
	public String getAdgangskode() {
		
		return this.adgangskode;
		
	}

	/**
	 *
	 *
	 */
	public int getTelefonnr() {
		
		return this.telefonnr;
		
	}

	/**
	 *
	 *
	 * @param
	 */
	public void setTelefonnr(int telly) {
		
		this.telefonnr = telly;
		
	}

	/**
	 *
	 *
	 * @param
	 */
	public void setAdgangskode(String adgang) {
		
		this.adgangskode = adgang;
		
	}

	/**
	 *
	 *
	 * @param
	 */
	public void setAdresse(String adres) {
		
		this.adresse = adres;
		
	}

	/**
	 *
	 *
	 * @param
	 */
	public void setFuldnavn(String namey) {

		this.fuldnavn = namey;
		
	}

	/**
	 *
	 *
	 */
	@Override
	public String toString() {

		return this.fuldnavn + "\n" + this.adresse + "\n" + this.telefonnr;

	}

}