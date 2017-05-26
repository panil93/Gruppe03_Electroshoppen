package gruppe03_electroshoppen;

import java.util.Date;

/**
 * This class represent a payment in the webshop. It is a payment of an
 * order. The class has 4 accessor methods. One for each of the attributes.
 *
 * @author Termproject - SI2-ORG-U1 - Group 3 (Spring 2017)
 */
public class Payment {

	private double amount;
	private Date date;
	private Customer customer;
	private Order order;

	/**
	 * This contructor creates a Payment-object.
	 *
	 * @param amount
	 * @param date
	 * @param customer
	 * @param order
	 */
	public Payment(double amount, Date date, Customer customer, Order order) {

		this.amount = amount;
		this.date = date;
		this.customer = customer;
		this.order = order;
	}

	/**
	 *
	 * @return The amount belonging to a payment.
	 */
	public double getAmount() {

		return this.amount;
	}

	/**
	 *
	 * @return The date belonging to a payment.
	 */
	public Date getDate() {

		return this.date;

	}

	/**
	 *
	 * @return The customer belonging to a payment.
	 */
	public Customer getCustomerToPayment() {

		return this.customer;

	}

	/**
	 *
	 * @return The order belonging to a payment.
	 */
	public Order getOrderToPayment() {

		return this.order;

	}
}
