/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppe03_electroshoppen;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Termproject - SI2-ORG-U1 - Group 3 (Spring 2017)
 */
public class Reclamation{

	private String årsag;
	private Date dato;
	private boolean erÅbnet;
	private String byttevare;
	private int id;
	Customer customer;
	List<Commodity> varerTilBytte;
	Order order;

	public Reclamation(String årsag, Date dato, boolean erÅbnet, String byttevare, int id, Customer customer, List<Commodity> varerTilBytte, Order order) {
		this.årsag = årsag;
		this.dato = dato;
		this.erÅbnet = erÅbnet;
		this.byttevare = byttevare;
		this.id = id;
	}

}
