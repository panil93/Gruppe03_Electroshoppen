/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppe03_electroshoppen;

import Persistence.LoadStores;
import Persistence.LoadCustomers;
import Persistence.LoadCommodities;
import java.util.ArrayList;
import java.util.List;
import Persistence.Loader;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Termproject - SI2-ORG-U1 - Group 3 (Spring 2017)
 */
public class Mediator {
/**
	 * Loaders
	 *
	 * 
	 */
	LoadCommodities l = new LoadCommodities();
	LoadCustomers k = new LoadCustomers();
	LoadStores lB = new LoadStores();

	List<Commodity> productcatalog = new ArrayList<Commodity>();
	List<Customer> listofcustomers = new ArrayList<Customer>();
	List<Employee> listofemployee = new ArrayList<Employee>();
	List<Store> listofshops = new ArrayList<Store>();
	List<Subsupplier> listofsubsuppliers = new ArrayList<Subsupplier>();
	List<Order> listoforders = new ArrayList<Order>();

        /**
	 * Mediator
	 *
	 * 
	 */
	public Mediator() {
		l.load();
		k.load(this);
		lB.load(this);
	}

	public List<Commodity> getListOfCommodites() {

		return l.getProductKatalog();
	}

	public List<Customer> getListOfCustomers() {
		return k.getListOfCustomers();
	}

	public List<Employee> getListOfEmployees() {
		return this.lB.getListOfEmploee();
	}

	public List<Store> getListOfStores() {
		return this.lB.getListOfStores();
	}

	public List<Subsupplier> getListOfSubsuppliers() {
		return this.listofsubsuppliers;
	}

	public List<Order> getListOfOrders() {
		return k.getListOfOrders();
	}

	public List<Payment> getListOfPayments() {
		return k.getListOfPayments();
	}

	public List<Reclamation> getListOfReclamations() {
		return k.getListOfReclamations();
	}

	public Customer getClientByLogin(String login) {
		List<Customer> listofclients = k.getListOfCustomers();
		for (Customer customer_to_loop : listofclients) {
			if (customer_to_loop.getLogin().compareTo(login) == 0) {
				return customer_to_loop;
			}
		}
		return null;
	}

        /**
	 * Employee login
	 *
	 * @param String login - the login
                   * @param String adgangskode - the password
	 */
	public boolean IsEmpoloyeeInSystem(String login, String password) {
		for (Employee employee_to_loop : listofemployee) {
			if (employee_to_loop.getLogin().compareTo(login) == 0 && employee_to_loop.getPassword().compareTo(password) == 0) {

				return true;
			}
		}
		return false;
	}

  /**
	 * Gets commodities by order
	 *
	 * @param int orders_id - the id of the orders
                   * 
	 */
	public List<Commodity> getCommoditiesByOrder(int orders_id) {

		for (Order order : this.getListOfOrders()) {
			if (order.getId() == orders_id) {
				return order.getListOfCommodities();

			}
		}
		return null;
	}

                /**
	 * Gets orders by ID
	 *
	 * @param orders_id
                   * 
	 */
	public Order getOrderByid(String orders_id) {
		for (Order order : this.getListOfOrders()) {
			if (order.getId() == Integer.parseInt(orders_id)) {
				return order;

			}
		}
		return null;
	}

                /**
	 * Gets commodities by ID
	 *
	 * @param commodities_id
                   * 
	 */
	public Commodity getCommoditiesById(String commodities_id) {
		for (Commodity commodity_to_loop : l.getProductKatalog()) {
			if (commodity_to_loop.getId().compareTo(commodities_id) == 0) {


				return commodity_to_loop;
			}

		}
		return null;
	}

      /**
	 * Gets employee login
	 *
	 * @param employeeslogin
                   * 
	 */
	public Employee getEmployeeByLogin(String employeeslogin) {
		for (Employee employee_to_loop : listofemployee  ) {
			if (employee_to_loop.getLogin().compareTo(employeeslogin) == 0) {
				return employee_to_loop;

			}
		}
		return null;
	}


                /**
	 * Gets stores by adress
                   * @param adress_to_store
	 */
	public Store getStoreByAdress(String adress_to_store) {
		for (Store storetoloop : lB.getListOfStores()) {
			if (storetoloop.getAdress().compareTo(adress_to_store) == 0) {
				return storetoloop;

			}
		}
		return null;
	}

                /**
	 * Gets list of commodities by ID
                   * @param commodities_id
	 */
	public List<Commodity> getListOfCommoditiesById(String commodities_id) {
		List<Commodity> commodity_list = this.l.getProductKatalog();
		List<Commodity> newlistofcommodities = new ArrayList();
		String[] ids = commodities_id.split(",");
		for (Commodity commodity_to_loop : commodity_list) {

			for (String id : ids) {
				if (commodity_to_loop.getId().compareTo(id) == 0) {
					newlistofcommodities.add(commodity_to_loop);
				}

			}
		}

		return newlistofcommodities;
	}

             /**
	 * Gets list of orders
                   * @param string_to_split
	 */
	public List<Order> getListOfOrders(String string_to_split) {
		List<Order> orderlist = this.k.getListOfOrders();
		String[] strinkowaarray = string_to_split.split(",");

		for (int i = 0; i < strinkowaarray.length; i++) {
			Order order_to = this.getOrderByid((strinkowaarray[i]));
			orderlist.add(order_to);
		}
		return orderlist;
	}

     /**
	 * Removes order from list
                   * @param order_to_remove
	 */
	public void RemoveOrderFromList(Order order_to_remove) {
		this.k.getListOfOrders().remove(order_to_remove);
	}

                        /**
	 * Gets list of employee by login
	 *
	 * @param employeeslogin
                   * 
	 */
	public List<Employee> getListOfEmployeeByLogin(String employeeslogin) {
		List<Employee> employeeslist = new ArrayList<>();
		String[] stringarray = employeeslogin.split(",");

		for (int i = 0; i < stringarray.length; i++) {
			Employee m = this.getEmployeeByLogin(stringarray[i]);
			employeeslist.add(m);
		}
		return employeeslist;
	}

                        /**
	 * Gets custome login
	 *
	 * @param login - the login
                   * @param password - the password
                   * 
	 */
	public Customer getCustomerByLoginAndPassword(String login, String password) {
		for (Customer customer_to_loop : k.getListOfCustomers()) {
			if ((customer_to_loop.getLogin().compareTo(login) == 0) && (customer_to_loop.getPassword().compareTo(password) == 0)) {
				return customer_to_loop;

			}
		}
		return null;
	}

                /**
	 * Gets lcustomer by order
	 *
	 * @param ordernr
                   * 
	 */
	public Customer getCustomerByOrder(int ordernrnr) {
		for (Order order_to_loop : k.getListOfOrders()) {
			if (order_to_loop.getId() == ordernrnr) {
				return order_to_loop.getCustomer();

			}
		}
		return null;
	}

                /**
	 * Gets all orders by customer
	 *
	 * @param customer_to_orders
                   * 
	 */
	public List<Order> getAllOrdersByCustomer(Customer customer_to_orders) {

            
		List<Order> orderlist0 = new ArrayList<>();
		for (Order order_to_loop : this.getListOfOrders()) {
			if (order_to_loop.getCustomer().getLogin().compareTo(customer_to_orders.getLogin()) == 0) {
				orderlist0.add(order_to_loop);
                                
			}
		}
		return orderlist0;
	}
        
                /**
	 * Gets all the reclamations by customer
	 *
	 * @param Customer customer
                   * 
	 */
        public List<Reclamation> getAllReclamationsByCustomer(Customer customer){
            List<Reclamation> listToReturn = new ArrayList<>();
            
            for(Reclamation reclamation_to_loop: this.getListOfReclamations()){
                String customers_login = customer.getLogin();
                String customers_login_to_reclamation = reclamation_to_loop.getCustomer().getLogin();
                if(customers_login_to_reclamation.compareTo(customers_login) == 0){
                    listToReturn.add(reclamation_to_loop);
                }
                }
        
            return listToReturn;
        }
        
                /**
	 * Gets the ID for an order
	 *
	 * 
                   * 
	 */
        public int getIDforOrder(){
            int returnId= 0;
            List<Integer> listOfInts = new ArrayList<>();
            for (Order order_to_id: this.getListOfOrders()){
                listOfInts.add(order_to_id.getId());
            Collections.sort(listOfInts);
            returnId= listOfInts.get((listOfInts.size())-1)+1;
            }
            return returnId;
        }
        
                /**
	 * Gets ID for reclamation
	 *
	 * @param String s
                   * 
	 */
        public int getIDforReclamation(){
            int returnId=0;
            List<Integer> listOfInts = new ArrayList<>();
            for (Reclamation reclamation_to_id: this.getListOfReclamations()){
                listOfInts.add(reclamation_to_id.getId());
                Collections.sort(listOfInts);
                returnId=listOfInts.get((listOfInts.size())-1)+1;
            }
            return returnId;
            
        }

                    /**
	 * Adds new reclamation
	 *
	 * @param reclamation
                   * 
	 */
        public boolean addNewReclamation(Reclamation reclamation)

        {
             try {
                return this.k.addNewReclamation(reclamation);
            } catch (SQLException ex) {
                Logger.getLogger(Mediator.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }

                    /**
	 * Adds new order
	 *
	 * @param order
                   * 
	 */
        public boolean addNewOrder(Order order)
        {
            try {
                return k.addNewOrder(order);
            } catch (SQLException ex) {
                Logger.getLogger(Mediator.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
}
