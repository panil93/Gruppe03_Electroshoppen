
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
public abstract class Varer {

	double RetailPrice;
	private String CompanyId;

	public double getPris() {
		return this.RetailPrice;

	}

	public void setPris(double price) {
		this.RetailPrice = price;

	}

	public Varer(double RetailPrice, String CompanyId) {
		this.RetailPrice = RetailPrice;
		this.CompanyId = CompanyId;

	}

	public String getId() {
		return this.CompanyId;
	}
}
