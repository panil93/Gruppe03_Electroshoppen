package gruppe03_electroshoppen;

import java.util.List;

/**
 * This class represent an order in the webshop. An order contains a list of all
 * the products and services a customer wishes to buy. An order has a unique ID.   
 *
 * @author Termproject - SI2-ORG-U1 - Group 3 (Spring 2017)
 */
public class Order {

	private int id;
	private String deliveryPlace;
	private double amount;
	Kunde customer;
	List<Varer> listOfCommodities;

	/**
	 * This contructor creates an Order-object.
	 *
	 * @param id
	 * @param deliveryPlace
	 * @param customer
	 * @param amount
	 * @param listOfCommodities
	 */
	public Order(int id, String deliveryPlace, Kunde customer, double amount, List<Varer> listOfCommodities) {

		this.id = id;
		this.deliveryPlace = deliveryPlace;
		this.amount = amount;
		this.customer = customer;
		this.listOfCommodities = listOfCommodities;

	}

	/**
	 *
	 * @return A list of all products and services in the order.
	 */
	public List<Varer> getCommodities() {

		return this.listOfCommodities;

	}

	/**
	 *
	 * @return The ID of the order.
	 */
	public int getId() {

		return this.id;

	}

	/**
	 *
	 * @return The delivery place.
	 */
	public String getDeliveryPlace() {

		return this.deliveryPlace;

	}

	/**
	 *
	 * @return The customer requesting the order.
	 */
	public Kunde getCustomer() {

		return this.customer;

	}

	/**
	 *
	 * @return The orders ID as a String.
	 */
	@Override
	public String toString() {

		return String.valueOf(this.id);

	}
}
