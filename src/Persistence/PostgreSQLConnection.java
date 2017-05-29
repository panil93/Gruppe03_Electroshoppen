/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import gruppe03_electroshoppen.Customer;
import gruppe03_electroshoppen.Reclamation;
import gruppe03_electroshoppen.Employee;
import gruppe03_electroshoppen.Commodity;
import gruppe03_electroshoppen.Mediator;
import gruppe03_electroshoppen.Order;
import gruppe03_electroshoppen.Payment;
import gruppe03_electroshoppen.Product;
import gruppe03_electroshoppen.Service;
import gruppe03_electroshoppen.Store;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Laura
 */
public class PostgreSQLConnection {
    //Mediator mediator= new Mediator();
  Connection connection = null;
    public void openDB() throws SQLException{
        try {

			Class.forName("org.postgresql.Driver");
                        
		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return;

		}
        connection = DriverManager.getConnection(
					"jdbc:postgresql://127.0.0.1:5432/electroshoppen", "gruppe03",
					"gruppe3");

    };
    public void closeDB() throws SQLException{
        this.connection.close();
    } 
   public List<Customer> getAllClients() throws SQLException{
       List<Customer> returnClient = new ArrayList<Customer>();
       
        Statement st1 = this.connection.createStatement();
        ResultSet rs1 = st1.executeQuery("SELECT fullname,adress,login,password,telefonnr,personligtilbud FROM public.\"Client\" ");
        while (rs1.next())
        {
            returnClient.add(new Customer(rs1.getString("fullname"),rs1.getString("adress"),
                    rs1.getString("login"),rs1.getString("password"),rs1.getInt("telefonnr"), rs1.getInt("personligtilbud")));
        }
       
        
        return returnClient;
   }
    public List<Store> getAllShops() throws SQLException{
       List<Store> returnShop = new ArrayList<Store>();
       
        Statement st1 = this.connection.createStatement();
        ResultSet rs1 = st1.executeQuery("SELECT * FROM public.\"Shop\"");
        while (rs1.next())
        {
            List<Employee> e = this.getAllEmploeeForShop(rs1.getString("adress"));
            returnShop.add(new Store(rs1.getString("adress"),rs1.getString("mail"),e));
        }
       
        
        return returnShop;
   }
    public List<Employee> getAllEmploeeForShop(String addr) throws SQLException
    {
        
        //this.openDB();
        List<Employee> EmploeeList = new ArrayList<Employee>();
        Statement st1 = this.connection.createStatement();
        ResultSet rs1 = st1.executeQuery("SELECT * FROM public.\"EmploeeInShop\" where shop_to_='"+addr+"'");
        List<String> em_id = new ArrayList<String>();
        while (rs1.next())
        {
            em_id.add(rs1.getString("employee_to"));
        }
        if(em_id.size() == 0)
        {
            return EmploeeList;
        }
        /*
        Construct query string
        */
        String Query = "SELECT * FROM public.\"Emploee\" where ";
        int counter = 0;
        for(String id: em_id)
        {
            if(counter == 0)
            {
                Query += "\"login\"='" + id +"' ";
                counter++;
            }
            else
            {
                Query += "OR \"login\"='" + id + "' ";
            }
            
        }
        Query += ";";
        /*
        Fetch the employees
        */
        Statement st2 = this.connection.createStatement();
        ResultSet rs2 = st1.executeQuery(Query);
        
         while (rs2.next())
        {
            EmploeeList.add(new Employee(rs2.getString("fullname"),rs2.getString("login"),rs2.getString("password"),rs2.getString("type")));
        }
        //this.closeDB();
        return EmploeeList;
    }
    public List<Employee> getAllEmploee() throws SQLException{
        
        List<Employee> returnEmploee = new ArrayList<Employee>();
       
        Statement st3 = this.connection.createStatement();
        ResultSet rs3 = st3.executeQuery("SELECT * FROM public.\"Emploee\"");
        while (rs3.next())
        {
            returnEmploee.add(new Employee(rs3.getString("Fullname"),rs3.getString("Login"),rs3.getString("Password"),rs3.getString("Type")));
        }
       
        
        return returnEmploee;
    }
    public List<Reclamation> getAllComplaints(Mediator ref) throws SQLException{
      List<Reclamation> returnComplaint = new ArrayList<Reclamation>();
      Statement st4 = this.connection.createStatement();
      
        ResultSet rs4 = st4.executeQuery("SELECT * FROM public.\"Complaint\"");
        while (rs4.next())
        {
            String test = rs4.getString("order_to_complaint");
            Order o = ref.getOrderByid(test);
            Customer cu = ref.getClientByLogin(rs4.getString("customer_to"));
            List<Commodity> co = this.getAllItemsForComplaint(rs4.getInt("id"),ref);
            returnComplaint.add(new Reclamation(rs4.getString("reason"),rs4.getDate("date"), rs4.getBoolean("isOpen"),
                    rs4.getString("item_to_change"), rs4.getInt("id"),cu,
                    co, o));
            //String årsag, Date dato, boolean erÅbnet, String byttevare, int id,
            //Customer customer, List<Commodity> varerTilBytte, Order order
            //returnComplaint.add(new Reclamation(rs4.getString("reason"),rs4.getDate("date"),rs4.getBoolean("isOpen"),"",0,null,null,null));
        }
       
        
        return returnComplaint;
    }
    public List<Commodity> getAllItemsForComplaint(int complaints_id,Mediator ref) throws SQLException
    {
        List<Commodity> returnItemsToComplaint = new ArrayList<Commodity>();
      Statement st4 = this.connection.createStatement();
      
        ResultSet rs4 = st4.executeQuery("SELECT * FROM public.\"items_to_Complaint\" WHERE fk_complaint_to_item = '" + complaints_id + "'");
        while (rs4.next())
        {
            Commodity co = ref.getCommoditiesById(rs4.getString("fk_item_to_complaint"));
           returnItemsToComplaint.add(co);
        }
       
        
        return returnItemsToComplaint;
    }
     
    public List<Customer> GetAllClients() throws SQLException
    {
        List<Customer> returnEmploee = new ArrayList<Customer>();
       
        Statement st3 = this.connection.createStatement();
        ResultSet rs3 = st3.executeQuery("SELECT * FROM public.\"Emploee\"");
        while (rs3.next())
        {
            //String fuldnavn,String adresse,String login,String adgangskode,int telefonnr
            returnEmploee.add(new Customer(rs3.getString("fullname"),rs3.getString("adress"),
            rs3.getString("login"),rs3.getString("password"),rs3.getInt("telefonnr"), rs3.getInt("personligtilbud")));
        }
        return returnEmploee;
    }
    public List<Order> GetAllOrders() throws SQLException
    {
        List<Order> returnOrders = new ArrayList<Order>();
        Statement st3 = this.connection.createStatement();
        ResultSet rs3 = st3.executeQuery("SELECT * FROM public.\"Order\"");
        while (rs3.next())
        {
            //int id,String stedtiludlevering, Client kunde, double orderPrice, List<Item>listOfVarer
            List<Commodity> c = this.GetListOfItemsByOrderId(rs3.getInt("id"));
            Statement cs = this.connection.createStatement();
            ResultSet cs3 = cs.executeQuery("SELECT * FROM public.\"Client\" where login = '"+rs3.getString("client_to_order")+"'");
            Customer cu = null;
            while (cs3.next())
            {
                //String fuldnavn,String adresse,String login,String adgangskode,int telefonnr
                cu = new Customer(cs3.getString("fullname"),cs3.getString("adress")
                ,cs3.getString("login"),cs3.getString("password"),cs3.getInt("telefonnr"), cs3.getInt("personligtilbud"));
            }
           
            returnOrders.add(new Order(rs3.getInt("id"),rs3.getString("placeToReception"),cu,
            c));
        }
        return returnOrders;
    }
    public List<Commodity> GetListOfItemsByOrderId(int order_id) throws SQLException
    {
        List<Commodity> returnItems = new ArrayList<>();
        Statement st1 = this.connection.createStatement();
        ResultSet rs1 = st1.executeQuery("SELECT * FROM public.\"itemsToOrder\"");
        List<String> item_id = new ArrayList<>();
        while (rs1.next())
        {
            item_id.add(rs1.getString("item_to_order"));
        }
        String Query = "SELECT * FROM public.\"Item\" WHERE ";
        int counter = 0;
        for(String id: item_id)
        {
            if(counter == 0)
            {
                Query += "\"CompanyId\"='" + id +"' ";
                counter++;
            }
            else
            {
                Query += "OR \"CompanyId\"='" + id + "' ";
            }
        }
        Query += ";";
        Statement st2 = this.connection.createStatement();
        ResultSet rs2 = st2.executeQuery(Query);
        while (rs2.next())
        {
            if(rs2.getString("type").compareTo("Product") == 0)
            {
                Statement pst = this.connection.createStatement();
                ResultSet prs = pst.executeQuery("SELECT * FROM public.\"Product\" WHERE title = '" + rs2.getString("CompanyId") + "'");
                while (prs.next())
                {
                    returnItems.add(new Product(rs2.getDouble("RetailPrice"),rs2.getString("CompanyId"),
                    prs.getString("SupplierName"), prs.getInt("SupplierId"), prs.getString("SupplierProductCode"),
                    prs.getString("ProductCategory"),prs.getString("Brand"),prs.getDouble("CostPrice"),
                    prs.getDouble("CostPriceFreightFrom"),prs.getDouble("CostPriceFreightTo"),
                    prs.getDouble("CostPriceHandlingFee"), prs.getDouble("CostPriceWeeFee"),prs.getString("EAN"),
                    prs.getBoolean("Expired"),prs.getDate("ExpiredDate"),prs.getInt("StockQuantity"),
                    prs.getDate("LastRestocked"),prs.getString("ShortReelDescription"),prs.getString("LongDescription"),
                    prs.getString("ShortDescription"),prs.getString("Title"),prs.getInt("DeliveryTime"),
                    prs.getDouble("Weight"),prs.getDouble("Lenght"),prs.getDouble("Width"),prs.getDouble("Height"),
                    prs.getDate("ConvertedDate"),prs.getDate("Created"),prs.getDate("Modified"),
                    prs.getInt("NextDeliveryQuantity"),prs.getDate("DeliveryDate"),prs.getDate("PriceLastModified"))); 
                }
                
            }
            else
            {
                /*
                Its a service.
                */
                Statement sst = this.connection.createStatement();
                ResultSet srs = sst.executeQuery("SELECT * FROM public.\"Service\" WHERE company_id = \"" +rs2.getString("CompanyId") +"\"");
                while (srs.next())
                {
                    returnItems.add(new Service(rs2.getString("CompanyId"),srs.getString("navn"),rs2.getDouble("RetailPrice")));
                }
            }
        }
        return returnItems;
    }
    public List<Commodity> GetAllItems() throws SQLException
    {
       List<Commodity> returnItems = new ArrayList<Commodity>();
       
        Statement st1 = this.connection.createStatement();
        ResultSet rs1 = st1.executeQuery("SELECT * FROM public.\"Product\" join public.\"Item\" on \"Product\".title = \"Item\".\"CompanyId\" ");
        while (rs1.next())
        {
            
            returnItems.add(new Product(rs1.getDouble("RetailPrice"),rs1.getString("CompanyId"),
                    rs1.getString("SupplierName"), rs1.getInt("SupplierId"), rs1.getString("SupplierProductCode"),
                    rs1.getString("ProductCategory"),rs1.getString("Brand"),rs1.getDouble("CostPrice"),
                    rs1.getDouble("CostPriceFreightFrom"),rs1.getDouble("CostPriceFreightTo"),
                    rs1.getDouble("CostPriceHandlingFee"), rs1.getDouble("CostPriceWeeFee"),rs1.getString("EAN"),
                    rs1.getBoolean("Expired"),rs1.getDate("ExpiredDate"),rs1.getInt("StockQuantity"),
                    rs1.getDate("LastRestocked"),rs1.getString("ShortReelDescription"),rs1.getString("LongDescription"),
                    rs1.getString("ShortDescription"),rs1.getString("Title"),rs1.getInt("DeliveryTime"),
                    rs1.getDouble("Weight"),rs1.getDouble("Lenght"),rs1.getDouble("Width"),rs1.getDouble("Height"),
                    rs1.getDate("ConvertedDate"),rs1.getDate("Created"),rs1.getDate("Modified"),
                    rs1.getInt("NextDeliveryQuantity"),rs1.getDate("DeliveryDate"),rs1.getDate("PriceLastModified"))); 		
        }
        /*
        Add the service products aswell
        */
        Statement st2 = this.connection.createStatement();
        ResultSet rs2 = st2.executeQuery("SELECT * FROM public.\"Service\" join public.\"Item\" on \"Service\".company_id = \"Item\".\"CompanyId\"");
        while (rs2.next())
        {
            /* String CompanyId, String navn, double RetailPrice */
            returnItems.add(new Service(rs2.getString("CompanyId"),rs2.getString("name"),rs2.getDouble("RetailPrice")));
        }
        
        return returnItems;
    }
    public List<Payment> GetAllPayments(Mediator ref_m) throws SQLException
    {
        List<Payment> returnPayments = new ArrayList<>();
        Statement st3 = this.connection.createStatement();
        ResultSet rs3 = st3.executeQuery("SELECT * FROM public.\"Payment\"");
        while (rs3.next())
        {
            //double amount, Date date, Customer customer, Order order
            Order Payment_order = ref_m.getOrderByid(rs3.getString("order_to_payment"));
            returnPayments.add(new Payment(rs3.getDouble("amount"),rs3.getDate("date"),Payment_order.getCustomer(),Payment_order));
            
        }
        return returnPayments;
    }
    public boolean insertNewReclamation(Reclamation r) throws SQLException
    {
        /*
        Opret Entry i Complaint tabel
        */
        Statement st3 = this.connection.createStatement();
        int rs3 = st3.executeUpdate("INSERT INTO public.\"Complaint\" VALUE (" +
                r.getDate()+","+r.isOpen()+ ","+r.getId()+","+r.getReason()+","+r.getClient()+","+r.getOrder()+","+r.getChangeItem()+
                ")");
        if(rs3 == 0)
        {
           return false; 
        }
        /*
        date date,
  "isOpen" boolean,
  id integer NOT NULL,
  reason text,
  customer_to text,
  order_to_complaint integer,
  item_to_change text,
        Opret rows for produkter til complaint
        */
        GetListOfItemsByReclamationsId(r);
        return true;
    }
    public boolean GetListOfItemsByReclamationsId(Reclamation r) throws SQLException
    {
        for (Commodity c: r.getListOfCommodities()){
         Statement st3 = this.connection.createStatement();
        int rs3 = st3.executeUpdate("INSERT INTO public.\"items_to_Complaint\" VALUE (" +
                c.getId()+","+r.getId()+ 
                ")");
        if(rs3 == 0)
        {
           return false; 
        }
        
        return true;}
        return false;
}
    public boolean insertNewOrder(Order o) throws SQLException
    {
        Statement st3 = this.connection.createStatement();
        int rs3 = st3.executeUpdate("INSERT INTO public.\"Order\" VALUE (" +
                o.getId()+","+o.getDeliveryPlace()+ ","+o.getCustomer()+
                ")");
        if(rs3 == 0)
        {
           return false;         
    }
        GetListOfItemsToOrder(o);
        return false; 
} 
    public boolean GetListOfItemsToOrder(Order r) throws SQLException
    {
        for (Commodity c: r.getListOfCommodities()){
         Statement st3 = this.connection.createStatement();
        int rs3 = st3.executeUpdate("INSERT INTO public.\"itemsToOrder\" VALUE (" +
                c.getId()+","+r.getId()+ 
                ")");
        if(rs3 == 0)
        {
           return false; 
        }
        
        return true;}
        return false;
}
    
    /*item_to_order text,
  order_to_item integer,
  id serial NOT NULL,*/
}

