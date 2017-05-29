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
	Customer customer;
	List<Commodity> listOfCommodities;

	/**
	 * This contructor creates an Order-object.
	 *
	 * @param id
	 * @param deliveryPlace
	 * @param customer
	 * @param listOfCommodities
	 */
	public Order(int id, String deliveryPlace, Customer customer, List<Commodity> listOfCommodities) {

		this.id = id;
		this.deliveryPlace = deliveryPlace;
		this.customer = customer;
		this.listOfCommodities = listOfCommodities;

	}

	/**
	 *
	 * @return A list of all products and services in the order.
	 */
	public List<Commodity> getCommodities() {

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
	public Customer getCustomer() {

		return this.customer;

	}
        public List<Commodity> getListOfCommodities(){
            return this.listOfCommodities;
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
