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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
   public List<Customer> getAllCustomers() throws SQLException{
       List<Customer> returnCustomer = new ArrayList<Customer>();
       
        Statement statement1 = this.connection.createStatement();
        ResultSet resultset1 = statement1.executeQuery("SELECT fullname,adress,login,password,telefonnr,personligtilbud FROM public.\"Client\" ");
        while (resultset1.next())
        {
            returnCustomer.add(new Customer(resultset1.getString("fullname"),resultset1.getString("adress"),
                    resultset1.getString("login"),resultset1.getString("password"),resultset1.getInt("telefonnr"), resultset1.getInt("personligtilbud")));
        }
       
        
        return returnCustomer;
   }
    public List<Store> getAllStores() throws SQLException{
       List<Store> returnStore = new ArrayList<Store>();
       
        Statement statement1 = this.connection.createStatement();
        ResultSet resultset1 = statement1.executeQuery("SELECT * FROM public.\"Shop\"");
        while (resultset1.next())
        {
            List<Employee> e = this.getAllEmployeesForStore(resultset1.getString("adress"));
            returnStore.add(new Store(resultset1.getString("adress"),resultset1.getString("mail"),e));
        }
       
        
        return returnStore;
   }
    public List<Employee> getAllEmployeesForStore(String addr) throws SQLException
    {
        
        //this.openDB();
        List<Employee> employeesList = new ArrayList<Employee>();
        Statement statement1 = this.connection.createStatement();
        ResultSet resultset1 = statement1.executeQuery("SELECT * FROM public.\"EmploeeInShop\" where shop_to_='"+addr+"'");
        List<String> employees_id_list = new ArrayList<String>();
        while (resultset1.next())
        {
            employees_id_list.add(resultset1.getString("employee_to"));
        }
        if(employees_id_list.size() == 0)
        {
            return employeesList;
        }
        /*
        Construct query string
        */
        String Query = "SELECT * FROM public.\"Emploee\" where ";
        int counter = 0;
        for(String id: employees_id_list)
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
        Statement statement2 = this.connection.createStatement();
        ResultSet resultset2 = statement1.executeQuery(Query);
        
         while (resultset2.next())
        {
            employeesList.add(new Employee(resultset2.getString("fullname"),resultset2.getString("login"),resultset2.getString("password"),resultset2.getString("type")));
        }
        //this.closeDB();
        return employeesList;
    }
    public List<Employee> getAllEmployees() throws SQLException{
        
        List<Employee> returnEmplyoees = new ArrayList<Employee>();
       
        Statement statement3 = this.connection.createStatement();
        ResultSet resultset3 = statement3.executeQuery("SELECT * FROM public.\"Emploee\"");
        while (resultset3.next())
        {
            returnEmplyoees.add(new Employee(resultset3.getString("Fullname"),resultset3.getString("Login"),resultset3.getString("Password"),resultset3.getString("Type")));
        }
       
        
        return returnEmplyoees;
    }
    public List<Reclamation> getAllReclamations(Mediator reference_to_mediator) throws SQLException{
      List<Reclamation> returnReclamations = new ArrayList<Reclamation>();
      Statement statement4 = this.connection.createStatement();
      
        ResultSet resultset4 = statement4.executeQuery("SELECT * FROM public.\"Complaint\"");
        while (resultset4.next())
        {
            String orders_id = resultset4.getString("order_to_complaint");
            Order order = reference_to_mediator.getOrderByid(orders_id);
            Customer cu = reference_to_mediator.getClientByLogin(resultset4.getString("customer_to"));
            List<Commodity> commodities_list = this.getAllCommoditiesForReclamation(resultset4.getInt("id"),reference_to_mediator);
            returnReclamations.add(new Reclamation(resultset4.getString("reason"),resultset4.getDate("date"), resultset4.getBoolean("isOpen"),
                    resultset4.getString("item_to_change"), resultset4.getInt("id"),cu,
                    commodities_list, order));
            //String årsag, Date dato, boolean erÅbnet, String byttevare, int id,
            //Customer customer, List<Commodity> varerTilBytte, Order order
            //returnComplaint.add(new Reclamation(rs4.getString("reason"),rs4.getDate("date"),rs4.getBoolean("isOpen"),"",0,null,null,null));
        }
       
        
        return returnReclamations;
    }
    public List<Commodity> getAllCommoditiesForReclamation(int complaints_id,Mediator reference_to_mediator) throws SQLException
    {
        List<Commodity> returnCommoditiesToReclamation = new ArrayList<Commodity>();
      Statement statement4 = this.connection.createStatement();
      
        ResultSet resultset4 = statement4.executeQuery("SELECT * FROM public.\"items_to_Complaint\" WHERE fk_complaint_to_item = '" + complaints_id + "'");
        while (resultset4.next())
        {
            Commodity commodity_to_reclamation = reference_to_mediator.getCommoditiesById(resultset4.getString("fk_item_to_complaint"));
           returnCommoditiesToReclamation.add(commodity_to_reclamation);
        }
       
        
        return returnCommoditiesToReclamation;
    }
     
    public List<Customer> GetAllEmployees() throws SQLException
    {
        List<Customer> returnEmployees = new ArrayList<Customer>();
       
        Statement statement3 = this.connection.createStatement();
        ResultSet resultset3 = statement3.executeQuery("SELECT * FROM public.\"Emploee\"");
        while (resultset3.next())
        {
            //String fuldnavn,String adresse,String login,String adgangskode,int telefonnr
            returnEmployees.add(new Customer(resultset3.getString("fullname"),resultset3.getString("adress"),
resultset3.getString("login"),resultset3.getString("password"),resultset3.getInt("telefonnr"), resultset3.getInt("personligtilbud")));
        }
        return returnEmployees;
    }
    public List<Order> GetAllOrders() throws SQLException
    {
        List<Order> returnOrders = new ArrayList<Order>();
        Statement statement3 = this.connection.createStatement();
        ResultSet resultset3 = statement3.executeQuery("SELECT * FROM public.\"Order\"");
        while (resultset3.next())
        {
            //int id,String stedtiludlevering, Client kunde, double orderPrice, List<Item>listOfVarer
            List<Commodity> commodity = this.GetListOfCommoditiesByOrdersId(resultset3.getInt("id"));
            Statement createdstatement = this.connection.createStatement();
            ResultSet createdresultset = createdstatement.executeQuery("SELECT * FROM public.\"Client\" where login = '"+resultset3.getString("client_to_order")+"'");
            Customer customer = null;
            while (createdresultset.next())
            {
                //String fuldnavn,String adresse,String login,String adgangskode,int telefonnr
                customer = new Customer(createdresultset.getString("fullname"),createdresultset.getString("adress")
                ,createdresultset.getString("login"),createdresultset.getString("password"),createdresultset.getInt("telefonnr"), createdresultset.getInt("personligtilbud"));
            }
           
            returnOrders.add(new Order(resultset3.getInt("id"),resultset3.getString("placeToReception"),customer,
            commodity));
        }
        return returnOrders;
    }
    public List<Commodity> GetListOfCommoditiesByOrdersId(int orders_id) throws SQLException
    {
        List<Commodity> returnCommodities = new ArrayList<>();
        Statement statement1 = this.connection.createStatement();
        ResultSet resultset1 = statement1.executeQuery("SELECT * FROM public.\"itemsToOrder\" WHERE order_to_item = '"+orders_id+"'");
        List<String> commodities_ids = new ArrayList<>();
        while (resultset1.next())
        {
            commodities_ids.add(resultset1.getString("item_to_order"));
        }
        String Query = "SELECT * FROM public.\"Item\" WHERE ";
        int counter = 0;
        for(String id: commodities_ids)
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
        Statement statement2 = this.connection.createStatement();
        ResultSet resultset2 = statement2.executeQuery(Query);
        while (resultset2.next())
        {
            if(resultset2.getString("type").compareTo("Product") == 0)
            {
                Statement productstatement = this.connection.createStatement();
                ResultSet productresultset = productstatement.executeQuery("SELECT * FROM public.\"Product\" WHERE title = '" + resultset2.getString("CompanyId") + "'");
                while (productresultset.next())
                {
                    returnCommodities.add(new Product(resultset2.getDouble("RetailPrice"),resultset2.getString("CompanyId"),
                    productresultset.getString("SupplierName"), productresultset.getInt("SupplierId"), productresultset.getString("SupplierProductCode"),
                    productresultset.getString("ProductCategory"),productresultset.getString("Brand"),productresultset.getDouble("CostPrice"),
                    productresultset.getDouble("CostPriceFreightFrom"),productresultset.getDouble("CostPriceFreightTo"),
                    productresultset.getDouble("CostPriceHandlingFee"), productresultset.getDouble("CostPriceWeeFee"),productresultset.getString("EAN"),
                    productresultset.getBoolean("Expired"),productresultset.getDate("ExpiredDate"),productresultset.getInt("StockQuantity"),
                    productresultset.getDate("LastRestocked"),productresultset.getString("ShortReelDescription"),productresultset.getString("LongDescription"),
                    productresultset.getString("ShortDescription"),productresultset.getString("Title"),productresultset.getInt("DeliveryTime"),
                    productresultset.getDouble("Weight"),productresultset.getDouble("Lenght"),productresultset.getDouble("Width"),productresultset.getDouble("Height"),
                    productresultset.getDate("ConvertedDate"),productresultset.getDate("Created"),productresultset.getDate("Modified"),
                    productresultset.getInt("NextDeliveryQuantity"),productresultset.getDate("DeliveryDate"),productresultset.getDate("PriceLastModified"))); 
                }
                
            }
            else
            {
                /*
                Its a service.
                */
                Statement servicestatement = this.connection.createStatement();
                ResultSet serviceresultset = servicestatement.executeQuery("SELECT * FROM public.\"Service\" WHERE company_id = '" +resultset2.getString("CompanyId") +"'");
                while (serviceresultset.next())
                {
                    returnCommodities.add(new Service(resultset2.getString("CompanyId"),serviceresultset.getString("name"),resultset2.getDouble("RetailPrice")));
                }
            }
        }
        return returnCommodities;
    }
    public List<Commodity> GetAllCommodities() throws SQLException
    {
       List<Commodity> returnCommodities = new ArrayList<Commodity>();
       
        Statement statement1 = this.connection.createStatement();
        ResultSet resultset1 = statement1.executeQuery("SELECT * FROM public.\"Product\" join public.\"Item\" on \"Product\".title = \"Item\".\"CompanyId\" ");
        while (resultset1.next())
        {
            
            returnCommodities.add(new Product(resultset1.getDouble("RetailPrice"),resultset1.getString("CompanyId"),
                    resultset1.getString("SupplierName"), resultset1.getInt("SupplierId"), resultset1.getString("SupplierProductCode"),
                    resultset1.getString("ProductCategory"),resultset1.getString("Brand"),resultset1.getDouble("CostPrice"),
                    resultset1.getDouble("CostPriceFreightFrom"),resultset1.getDouble("CostPriceFreightTo"),
                    resultset1.getDouble("CostPriceHandlingFee"), resultset1.getDouble("CostPriceWeeFee"),resultset1.getString("EAN"),
                    resultset1.getBoolean("Expired"),resultset1.getDate("ExpiredDate"),resultset1.getInt("StockQuantity"),
                    resultset1.getDate("LastRestocked"),resultset1.getString("ShortReelDescription"),resultset1.getString("LongDescription"),
                    resultset1.getString("ShortDescription"),resultset1.getString("Title"),resultset1.getInt("DeliveryTime"),
                    resultset1.getDouble("Weight"),resultset1.getDouble("Lenght"),resultset1.getDouble("Width"),resultset1.getDouble("Height"),
                    resultset1.getDate("ConvertedDate"),resultset1.getDate("Created"),resultset1.getDate("Modified"),
                    resultset1.getInt("NextDeliveryQuantity"),resultset1.getDate("DeliveryDate"),resultset1.getDate("PriceLastModified"))); 		
        }
        /*
        Add the service products aswell
        */
        Statement statement2 = this.connection.createStatement();
        ResultSet resultset2 = statement2.executeQuery("SELECT * FROM public.\"Service\" join public.\"Item\" on \"Service\".company_id = \"Item\".\"CompanyId\"");
        while (resultset2.next())
        {
            /* String CompanyId, String navn, double RetailPrice */
            returnCommodities.add(new Service(resultset2.getString("CompanyId"),resultset2.getString("name"),resultset2.getDouble("RetailPrice")));
        }
        
        return returnCommodities;
    }
    public List<Payment> GetAllPayments(Mediator reference_to_mediator) throws SQLException
    {
        List<Payment> returnPayments = new ArrayList<>();
        Statement st3 = this.connection.createStatement();
        ResultSet rs3 = st3.executeQuery("SELECT * FROM public.\"Payment\"");
        while (rs3.next())
        {
            //double amount, Date date, Customer customer, Order order
            Order Payment_order = reference_to_mediator.getOrderByid(rs3.getString("order_to_payment"));
            returnPayments.add(new Payment(rs3.getDouble("amount"),rs3.getDate("date"),Payment_order.getCustomer(),Payment_order));
            
        }
        return returnPayments;
    }
    public boolean insertNewReclamation(Reclamation reclamation) throws SQLException
    {
        /*
        Opret Entry i Complaint tabel
        */
        
        Statement statement3 = this.connection.createStatement();
        String Query = "INSERT INTO public.\"Complaint\" (\"date\",\"isOpen\",\"id\",\"reason\",\"customer_to\",\"order_to_complaint\",\"item_to_change\") VALUES"
                + " ('" +reclamation.getDate()+"',"+reclamation.isOpen()+ ","+reclamation.getId()+",'"+reclamation.getReason()+"','"+reclamation.getCustomer().getLogin()+"',"+reclamation.getOrder().getId()+",'"+reclamation.getChangeItem()+
                "')";
        int resultset3 = statement3.executeUpdate(Query);
        if(resultset3 == 0)
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
        GetListOfCommoditiesByReclamationsId(reclamation);
        return true;
    }
    public boolean GetListOfCommoditiesByReclamationsId(Reclamation reclamation) throws SQLException
    {
        
        for (Commodity commodity: reclamation.getListOfCommodities()){
         Statement statement3 = this.connection.createStatement();
        int resultset3 = statement3.executeUpdate("INSERT INTO public.\"items_to_Complaint\" (\"fk_item_to_complaint\",\"fk_complaint_to_item\") VALUES (" +
                commodity.getId()+","+reclamation.getId()+ 
                ")");
            if(resultset3 == 0)
            {
               return false; 
            }
        
        }
        return true;
}
    public boolean insertNewOrder(Order order) throws SQLException
    {
        Statement statement3 = this.connection.createStatement();
        String Query = "INSERT INTO public.\"Order\" (\"id\", \"placeToReception\", \"client_to_order\") VALUES (" +
                order.getId()+",'"+order.getDeliveryPlace()+ "','"+order.getCustomer().getLogin()+
                "')";
        int resultset3 = statement3.executeUpdate(Query);
        if(resultset3 == 0)
        {
           return false;         
    }
        GetListOfCommoditiesToOrder(order);
        return false; 
} 
    public boolean GetListOfCommoditiesToOrder(Order order) throws SQLException
    {
        for (Commodity commodity: order.getListOfCommodities()){
         Statement statement3 = this.connection.createStatement();
         String query = "INSERT INTO public.\"itemsToOrder\" (\"item_to_order\", \"order_to_item\") VALUES ('" +
                commodity.getId()+"',"+order.getId()+ 
                ")";
        int resultset3 = statement3.executeUpdate(query);
        if(resultset3 == 0)
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

