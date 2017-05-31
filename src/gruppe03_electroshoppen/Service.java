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
public class Service extends Commodity{

	private String name;

	public Service(String CompanyId, String name, double RetailPrice) {
		super(RetailPrice, CompanyId);
		this.name = name;

	}

	public String getNavn() {
		return this.name;
	}

	@Override
	public String toString() {
            DecimalFormat formatter = new DecimalFormat("0.00");
		return (this.name + " " + formatter.format(RetailPrice));

	}
}
