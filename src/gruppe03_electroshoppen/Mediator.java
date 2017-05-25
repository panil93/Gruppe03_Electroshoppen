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
import java.util.HashMap;

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

	public List<Commodity> getListOfVarer() {

		return l.getProduktKatalog();
	}

	public List<Customer> getListOfKunder() {
		return k.getListOfKunder();
	}

	public List<Employee> getListOfMedarbeder() {
		return this.lB.getListOfMedarbejder();
	}

	public List<Store> getListOfButikker() {
		return this.lB.getListOfButikker();
	}

	public List<Subsupplier> getListOfUnderleverandører() {
		return this.listofunderleverandor;
	}

	public List<Order> getListOfOrder() {
		return k.getListOfOrder();
	}

	public List<Payment> getListOfBetalinger() {
		return k.getListOfBetalinger();
	}

	public List<Reclamation> getListOfReklamationer() {
		return k.getListOfReklamationer();
	}

	public Customer getKundeByLogin(String login) {
		List<Customer> listeofkunde = k.getListOfKunder();
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

	public Commodity getVarerByid(String s) {
		for (Commodity v : produktkatalog) {

			if (v.getId().compareTo(s) == 0) {
				return v;
			}
		}

		return null;
	}

	public List<Commodity> getVarerByOrder(int orders_id) {

		for (Order o : this.getListOfOrder()) {
			if (o.getId() == orders_id) {
				return o.getCommodities();
			}
		}
		return null;
	}

	public Order getOrderByid(String s) {
		for (Order o : this.getListOfOrder()) {
			if (o.getId() == Integer.parseInt(s)) {
				return o;
			}
		}
		return null;
	}

	public Commodity getVarerById(String n) {
		for (Commodity v : produktkatalog) {
			if (v.getId().compareTo(n) == 0) {

				return v;
			}

		}
		return null;
	}

	public Employee getMedarbejderByLogin(String l) {
		for (Employee m : medarblist) {
			if (m.getLogin().compareTo(l) == 0) {
				return m;
			}
		}
		return null;
	}

	public Store getButikByAdresse(String a) {
		for (Store b : listofshops) {
			if (b.getAdresse().compareTo(a) == 0) {
				return b;
			}
		}
		return null;
	}

	public List<Commodity> getListOfVarerById(String st) {
		List<Commodity> varelist = this.l.getProduktKatalog();
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
			Employee m = this.getMedarbejderByLogin(stringarray[i]);
			medarbliste.add(m);
		}
		return medarbliste;
	}

	public Customer getKundeByLoginAndPassword(String log, String pass) {
		for (Customer kund : k.getListOfKunder()) {
			if ((kund.getLogin().compareTo(log) == 0) && (kund.getAdgangskode().compareTo(pass) == 0)) {
				return kund;
			}
		}
		return null;
	}

	public Customer getKundeByOrder(int ordernrnr) {
		for (Order ordi : k.getListOfOrder()) {
			if (ordi.getId() == ordernrnr) {
				return ordi.getCustomer();
			}
		}
		return null;
	}

	public List<Order> getAllOrdersByKunde(Customer kundzik) {
		List<Order> orderlist0 = new ArrayList<>();
		for (Order ord : this.getListOfOrder()) {
			if (ord.getCustomer() == kundzik) {
				orderlist0.add(ord);
			}
		}
		return orderlist0;
	}
}
