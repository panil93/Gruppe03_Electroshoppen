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

	LoadCommodities l = new LoadCommodities();
	LoadCustomers k = new LoadCustomers();
	LoadStores lB = new LoadStores();

	List<Commodity> produktkatalog = new ArrayList<Commodity>();
	List<Customer> listofkunder = new ArrayList<Customer>();
	List<Employee> medarblist = new ArrayList<Employee>();
	List<Store> listofshops = new ArrayList<Store>();
	List<Subsupplier> listofunderleverandor = new ArrayList<Subsupplier>();
	List<Order> listoforder = new ArrayList<Order>();

	public Mediator() {
		l.load();
		k.load(this);
		lB.load(this);
	}

	public List<Commodity> getListOfCommodites() {

		return l.getProductKatalog();
	}

	public List<Customer> getListOfClients() {
		return k.getListOfClients();
	}

	public List<Employee> getListOfEmployees() {
		return this.lB.getListOfEmploee();
	}

	public List<Store> getListOfStores() {
		return this.lB.getListOfShops();
	}

	public List<Subsupplier> getListOfSubsuppliers() {
		return this.listofunderleverandor;
	}

	public List<Order> getListOfOrders() {
		return k.getListOfOrder();
	}

	public List<Payment> getListOfPayments() {
		return k.getListOfPayments();
	}

	public List<Reclamation> getListOfReclamations() {
		return k.getListOfComplaints();
	}

	public Customer getClientByLogin(String login) {
		List<Customer> listeofkunde = k.getListOfClients();
		for (Customer kunde : listeofkunde) {
			if (kunde.getLogin().compareTo(login) == 0) {
				return kunde;
			}
		}
		return null;
	}

	public boolean IsEmpoloeeInSystem(String login, String adgangskode) {
		for (Employee m : medarblist) {
			if (m.getLogin().compareTo(login) == 0 && m.getAdgangskode().compareTo(adgangskode) == 0) {
				return true;
			}
		}
		return false;
	}

	public Commodity getCommodityByid(String s) {
		for (Commodity v : produktkatalog) {

			if (v.getId().compareTo(s) == 0) {
				return v;
			}
		}

		return null;
	}

	public List<Commodity> getVarerByOrder(int orders_id) {

		for (Order o : this.getListOfOrders()) {
			if (o.getId() == orders_id) {
				return o.getCommodities();
			}
		}
		return null;
	}

	public Order getOrderByid(String s) {
		for (Order o : this.getListOfOrders()) {
			if (o.getId() == Integer.parseInt(s)) {
				return o;
			}
		}
		return null;
	}

	public Commodity getCommoditiesById(String n) {
		for (Commodity v : l.getProductKatalog()) {
			if (v.getId().compareTo(n) == 0) {

				return v;
			}

		}
		return null;
	}

	public Employee getEmployeeByLogin(String l) {
		for (Employee m : medarblist) {
			if (m.getLogin().compareTo(l) == 0) {
				return m;
			}
		}
		return null;
	}

	public Store getStoreByAdress(String a) {
		for (Store b : listofshops) {
			if (b.getAdresse().compareTo(a) == 0) {
				return b;
			}
		}
		return null;
	}

	public List<Commodity> getListOfCommoditiesById(String st) {
		List<Commodity> varelist = this.l.getProductKatalog();
		List<Commodity> newlistofvarer = new ArrayList();
		String[] ids = st.split(",");
		for (Commodity v : varelist) {
			for (String id : ids) {
				if (v.getId().compareTo(id) == 0) {
					newlistofvarer.add(v);
				}

			}
		}

		return newlistofvarer;
	}

	public List<Order> getListOfOrder(String intowy) {
		List<Order> orderlist = this.k.getListOfOrder();
		String[] strinkowaarray = intowy.split(",");
		for (int i = 0; i < strinkowaarray.length; i++) {
			Order orderek = this.getOrderByid((strinkowaarray[i]));
			orderlist.add(orderek);
		}
		return orderlist;
	}

	public void RemoveListOfOrder(Order o) {
		this.k.getListOfOrder().remove(o);
	}

	public List<Employee> getListOfMedarbejderByLogin(String str) {
		List<Employee> medarbliste = new ArrayList<>();
		String[] stringarray = str.split(",");
		for (int i = 0; i < stringarray.length; i++) {
			Employee m = this.getEmployeeByLogin(stringarray[i]);
			medarbliste.add(m);
		}
		return medarbliste;
	}

	public Customer getClientByLoginAndPassword(String log, String pass) {
		for (Customer kund : k.getListOfClients()) {
			if ((kund.getLogin().compareTo(log) == 0) && (kund.getPassword().compareTo(pass) == 0)) {
				return kund;
			}
		}
		return null;
	}

	public Customer getClientByOrder(int ordernrnr) {
		for (Order ordi : k.getListOfOrder()) {
			if (ordi.getId() == ordernrnr) {
				return ordi.getCustomer();
			}
		}
		return null;
	}

	public List<Order> getAllOrdersByClient(Customer kundzik) {
            
		List<Order> orderlist0 = new ArrayList<>();
		for (Order ord : this.getListOfOrders()) {
			if (ord.getCustomer().getLogin().compareTo(kundzik.getLogin()) == 0) {
				orderlist0.add(ord);
                                
			}
		}
		return orderlist0;
	}
        public List<Reclamation> getAllReclamationsByCustomer(Customer customer){
            List<Reclamation> listToReturn = new ArrayList<>();
            
            for(Reclamation r: this.getListOfReclamations()){
                if(r.getClient().equals(customer)){
                    listToReturn.add(r);
                }
                }
        
            return listToReturn;
        }
        public int getIDforOrder(){
            int returnId= 0;
            List<Integer> intowa = new ArrayList<>();
            for (Order o: this.getListOfOrders()){
                intowa.add(o.getId());
            Collections.sort(intowa);
            returnId= intowa.get((intowa.size())-1)+1;
            }
            return returnId;
        }
        public int getIDforReclamation(){
            int returnId=0;
            List<Integer> intowa = null;
            for (Reclamation r: this.getListOfReclamations()){
                intowa.add(r.getId());
                Collections.sort(intowa);
                returnId=intowa.get((intowa.size())-1)+1;
            }
            return returnId;
            
        }
        public boolean addNewReclamation(Reclamation r)
        {
             try {
                return this.k.addNewReclamation(r);
            } catch (SQLException ex) {
                Logger.getLogger(Mediator.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        public boolean addNewOrder(Order o)
        {
            try {
                return k.addNewOrder(o);
            } catch (SQLException ex) {
                Logger.getLogger(Mediator.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
}
