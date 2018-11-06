package Main;

import java.util.ArrayList;

import Database.All_Information;
import Template.Catagory;
import Template.ClassicCustomer;
import Template.Customer;
import Template.PremiumCustomer;
import Template.Product;

public class Test1 {

	public static void main(String[] args) {
		Catagory ct1 = new Catagory("1001", "Book");
		
		//System.out.println("ID: "+ pro1.getID()+" name: "+pro1.getName()+" catagory : " + pro1.getCatagory().getName());
		//System.out.println(ct1.getID() + " " + ct1.getName());
		//System.out.println(pro1.getProductInformation());
		
		All_Information database = new All_Information();
		//database.create_New_Table_for_Category();
		//database.insert_category("1002", "Pen");
		//database.show_All_category();
		//System.out.println(database.search_category("10023"));
		//ArrayList<Catagory> myCatagories = database.get_All_Catagory();
		//System.out.println(myCatagories.size());
		//Customer aa = new PremiumCustomer("1000", "1000", "Admin", "1000", 1000.00, 5, 1000.00);
		//database.insert_customer_information(aa);
		//database.show_All_Customer();
		//database.create_New_Table_for_customer();
		//database.create_admin_table();
		//database.insert_Admin();
		//System.out.println(database.get_admin_balance());
		//System.out.println(database.get_admin_ID());
		//database.increaseBalance(10);
		//System.out.println(database.get_admin_balance());
		
		
		
		//database.create_activity_table();
		//database.insert_Activity("123123", "hello testing 2.");
		//ArrayList<String> all = database.get_All_Activities("123123");

		//System.out.println(all.size());
		//database.create_New_Table_for_product();
		//Product pro1 = new Product("101", "Chokher Bali", 60, 10, ct1, "supplied from Nilkhet.");
		//database.insert_product(pro1);
		//database.show_All_product();
		//ArrayList<Product> allpro = database.get_all_products();
		//System.out.println(allpro.size());
		//database.update_products_quantity( 5, "101");
		//database.show_All_product();
		
		
		
		
		
		
		
		
		//database.create_New_Table_for_Ac();
		
		//database.insert_ac("123123", "hello testing 2.");
		//ArrayList<String> all = database.get_All_Ac("123123");
		//System.out.println(all.size());
		
		
		
		
		
		
		
		
		//database.create_ActivityTable2();
		//database.insert_Activity2("123123", "hello testing 2.");
		
		
		//database.create_New_Table_for_customer();
		//database.show_All_Customer();
		
		//Customer customer = new ClassicCustomer("1234", "12", "Fahad", "0191936766", 1000, 1, 0.0);
		//database.insert_customer_information(customer);
	} 
}
