/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppe03_electroshoppen;

import java.util.Date;

/**
 *
 * @author Termproject - SI2-ORG-U1 - Group 3 (Spring 2017)
 */
public class Campaign{

	private int precentSaved;
	private boolean isInWebshop;
	private boolean idInPoS;
	private Date startdate;
	private Date finaldate;

	public Campaign(int precentSaved, boolean isInWebshop, boolean idInPoS) {
		
		this.precentSaved = precentSaved;
		this.isInWebshop = isInWebshop;
		this.idInPoS = idInPoS;
	
	}

	public int getPrecentSaved() {
	
		return this.precentSaved;
	
	}
}
