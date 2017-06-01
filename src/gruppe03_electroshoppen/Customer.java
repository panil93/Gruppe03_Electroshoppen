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

	private String fullname;
	private String adress;
	private String login;
	private String password;
	private int telefonnumber;
        private int personalSale;

	/**
	 *
	 *
	 * @param
	 */
	public Customer(String fullname, String adress, String login, String password, int telefonnumber, int personalSale) {

		this.fullname = fullname;
		this.adress = adress;
		this.login = login;
		this.password = password;
		this.telefonnumber = telefonnumber;
                this.personalSale=personalSale;
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
		
		return this.fullname;
		
	}

	/**
	 *
	 *
	 */
	public String getAdress() {
		
		return this.adress;
		
	}

	/**
	 *
	 *
	 */
	public String getPassword() {
		
		return this.password;
		
	}

	/**
	 *
	 *
	 */
	public int getTelefonnr() {
		
		return this.telefonnumber;
		
	}

	/**
	 *
	 *
	 * @param
	 */
	public void setTelefonnr(int telefonnumberToSetting) {
		
		this.telefonnumber = telefonnumberToSetting;
		
	}

	/**
	 *
	 *
	 * @param
	 */
	public void setPassword(String passwordToSetting) {
		
		this.password = passwordToSetting;
		
	}

	/**
	 *
	 *
	 * @param
	 */
	public void setAdress(String adressToSetting) {
		
		this.adress = adressToSetting;
		
	}

	/**
	 *
	 *
	 * @param
	 */
	public void setFullname(String nameToSetting) {

		this.fullname = nameToSetting;
		
	}
        public void setPersonalSale(int procentSaleToSetting){
            this.personalSale = procentSaleToSetting;
        }
        public int getPersonalSale(){
            return this.personalSale;
        }

	/**
	 *
	 *
	 */
	@Override
	public String toString() {

		return this.fullname + "\n" + this.adress + "\n" + this.telefonnumber;

	}

}
