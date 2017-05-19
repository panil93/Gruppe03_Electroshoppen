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
public class Betaling {

	private double beløb;
	private Date dato;
	private Kunde kunde;
	private Order order;

	public Betaling(double beløb, Date dato, Kunde kunde, Order order) {

		this.beløb = beløb;
		this.dato = dato;
		this.kunde = kunde;
		this.order = order;
	}

	public double getBeløb() {

		return this.beløb;
	}

	public Date getDato() {

		return this.dato;

	}

	public Kunde getKundetilBetaling() {

		return this.kunde;

	}

	public Order getOrderTilBetaling() {

		return this.order;

	}
}
