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

	private int procentTilbud;
	private boolean gælderIWebshop;
	private boolean gælderIPoS;
	private Date startdato;
	private Date sluttdato;

	public Campaign(int procentTilbud, boolean gælderIWebshop, boolean gælderIPoS) {
		
		this.procentTilbud = procentTilbud;
		this.gælderIWebshop = gælderIWebshop;
		this.gælderIPoS = gælderIPoS;
	
	}

	public int getProcentTilbud() {
	
		return this.procentTilbud;
	
	}
}
