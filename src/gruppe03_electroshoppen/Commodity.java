
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppe03_electroshoppen;

import java.text.DecimalFormat;

/**
 *
 * @author Termproject - SI2-ORG-U1 - Group 3 (Spring 2017)
 */
public abstract class Commodity{

	double RetailPrice;
	private String CompanyId;

	public double getPrice() {
            DecimalFormat formatter = new DecimalFormat("$0.00");
            
		return this.RetailPrice; // WTF ?!

	}

	public void setPrice(double price) {
		this.RetailPrice = price;

	}

	public Commodity(double RetailPrice, String CompanyId) {
	
		this.RetailPrice = RetailPrice;
		this.CompanyId = CompanyId;

	}

	public String getId() {
		return this.CompanyId;
	}
}
