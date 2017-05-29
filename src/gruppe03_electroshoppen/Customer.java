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
        private int personligtilbud;

	/**
	 *
	 *
	 * @param
	 */
	public Customer(String fuldnavn, String adresse, String login, String adgangskode, int telefonnr, int personligtilbud) {

		this.fuldnavn = fuldnavn;
		this.adresse = adresse;
		this.login = login;
		this.adgangskode = adgangskode;
		this.telefonnr = telefonnr;
                this.personligtilbud=personligtilbud;
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
	public String getPassword() {
		
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
	public void setPassword(String adgang) {
		
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
	public void setFullname(String namey) {

		this.fuldnavn = namey;
		
	}
        public void setPersonTilbud(int i){
            this.personligtilbud = i;
        }
        public int getPersonTilbud(){
            return this.personligtilbud;
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
