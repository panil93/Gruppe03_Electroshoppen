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

	private String reason;
	private Date date;
	private boolean isOpen;
	private String refoundOrCommodity;
	private int id;
	Customer customer;
	List<Commodity> commoditiesToChange;
	Order order;

	public Reclamation(String reason, Date date, boolean isOpen, String refoundOrCommodity, int id, Customer customer, List<Commodity> commoditiesToChange, Order order) {
		this.reason = reason;
		this.date = date;
		this.isOpen = isOpen;
		this.refoundOrCommodity = refoundOrCommodity;
		this.id = id;
                this.customer = customer;
                this.commoditiesToChange = commoditiesToChange;
                this.order = order;
	}
        public int getId(){
            return this.id;
        }
        public String getChangeItem(){
            return this.refoundOrCommodity;
        }
        public List<Commodity> getListOfCommodities(){
            return this.commoditiesToChange;
        }
        public Order getOrder(){
            return this.order;
        }
        
        public String getReason(){
            return this.reason;
        }
        public Customer getCustomer(){
            return this.customer;
        }
        public String getDate()
        {
            return this.date.toString();
        }
        public boolean isOpen()
        {
            return this.isOpen;
        }
        @Override
        public String toString()
        {
            return String.valueOf(this.id);
        }
}
