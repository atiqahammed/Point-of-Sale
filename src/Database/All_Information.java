package Database;

import java.sql.Connection;

import java.sql.DatabaseMetaData;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.ldap.PagedResultsResponseControl;

import Template.Catagory;
import Template.ClassicCustomer;
import Template.Customer;
import Template.PlatinumCustomer;
import Template.PremiumCustomer;
import Template.Product;

public class All_Information {

	final private String dbName = "all_information.db";
	final private String url = "jdbc:sqlite:db_file/" + dbName;
	final private String productTable = "Product";

	final private String customerTable = "Customer";
	final private String categoryTable = "Category";
	final private String AdminTable = "Admin";
	final private String ac2 = "Ac2";
	

	private Connection connect() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	///////////////////////////////////////////////////////////////// activityTalbe

	public void create_New_Table_for_Ac() {
		String sql = "CREATE TABLE IF NOT EXISTS " + ac2 + " (\n" + "    Id text NOT NULL,\n"
				+ "    Name text NOT NULL\n" + ");";

		try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
			stmt.execute(sql);
			System.out.println("Table created sucessfully.");
			System.out.println(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void insert_ac(String Id, String Name) {
		String sql = "INSERT INTO " + ac2 + " (Id,Name) VALUES(?,?)";

		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, Id);
			pstmt.setString(2, Name);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public ArrayList<String> get_All_Ac(String id) {
		String sql = "SELECT Id,Name FROM " + ac2 + "";

		ArrayList<String> allAc = new ArrayList<String>();

		try (Connection conn = this.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			// loop through the result set
			while (rs.next()) {
				if(rs.getString("Id").equals(id))
					allAc.add(rs.getString("Name"));
				
				/*Catagory temp = new Catagory(rs.getString("categoryId"), rs.getString("categoryName"));
				allCaragory.add(temp);*/
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return allAc;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////
	public void createNewDatabase() {

		try (Connection conn = DriverManager.getConnection(url)) {
			if (conn != null) {
				DatabaseMetaData meta = conn.getMetaData();
				System.out.println("The driver name is " + meta.getDriverName());
				System.out.println("A new database has been created.");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	////////////////////////////////// Admin Part
	////////////////////////////////// ///////////////////////////////////////////////////
	public void create_admin_table() {
		String sql = "CREATE TABLE IF NOT EXISTS " + AdminTable + " (\n" + "    Id text PRIMARY KEY,\n"
				+ "    password text NOT NULL,\n" + "	   balance real NOT NULL\n" + ");";

		try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
			// create a new table
			stmt.execute(sql);
			System.out.println("Table created sucessfully.");
			System.out.println(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void insert_Admin() {
		String sql = "INSERT INTO " + AdminTable + " (Id,password,balance) VALUES(?,?,?)";

		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, "123123");
			pstmt.setString(2, "123123");
			pstmt.setDouble(3, 10.0);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public double get_admin_balance() {
		String sql = "SELECT balance FROM " + AdminTable + "";

		try (Connection conn = this.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				return rs.getDouble("balance");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return 0.0;
	}

	public String get_admin_password() {
		String sql = "SELECT password FROM " + AdminTable + "";

		try (Connection conn = this.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				return rs.getString("password");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public String get_admin_ID() {
		String sql = "SELECT ID FROM " + AdminTable + "";

		try (Connection conn = this.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				return rs.getString("ID");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public void increaseBalance(double amount) {
		String sql = "UPDATE " + AdminTable + " SET balance = ?";

		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setDouble(1, (amount + get_admin_balance()));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public String[] get_admin_log_info() {
		String[] adminLogInfo = new String[2];
		adminLogInfo[0] = get_admin_ID();
		adminLogInfo[1] = get_admin_password();
		return adminLogInfo;
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////

	public void create_New_Table_for_Category() {
		String sql = "CREATE TABLE IF NOT EXISTS " + categoryTable + " (\n" + "    categoryId text PRIMARY KEY,\n"
				+ "    categoryName text NOT NULL\n" + ");";

		try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
			stmt.execute(sql);
			System.out.println("Table created sucessfully.");
			System.out.println(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void insert_category(String categoryId, String categoryName) {
		String sql = "INSERT INTO " + categoryTable + " (categoryId,categoryName) VALUES(?,?)";

		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, categoryId);
			pstmt.setString(2, categoryName);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void show_All_category() {
		String sql = "SELECT categoryId,categoryName FROM " + categoryTable + "";

		try (Connection conn = this.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				System.out.println(rs.getString("categoryId") + "\t" + rs.getString("categoryName"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<Catagory> get_All_Catagory() {
		String sql = "SELECT categoryId,categoryName FROM " + categoryTable + "";

		ArrayList<Catagory> allCaragory = new ArrayList<Catagory>();

		try (Connection conn = this.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			// loop through the result set
			while (rs.next()) {
				Catagory temp = new Catagory(rs.getString("categoryId"), rs.getString("categoryName"));
				allCaragory.add(temp);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return allCaragory;
	}

	public boolean search_category(String categoryId) {
		String sql = "SELECT categoryId,categoryName FROM " + categoryTable + "";

		try (Connection conn = this.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				if (categoryId.equals(rs.getString("categoryId"))) {
					return true;
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	////////////////////////////////////////////////////////////////////////////

	public void create_New_Table_for_customer() {

		String sql = "CREATE TABLE IF NOT EXISTS " + customerTable + " (\n" + "    customerId text PRIMARY KEY,\n"
				+ "	   customerName text NOT NULL,\n" + "	   password text NOT NULL,\n"
				+ "	   phoneNumber text NOT NULL,\n" + "	   balance real NOT NULL,\n"
				+ "	   type integer NOT NULL,\n" + "	   totalParse real NOT NULL\n" + ");";

		try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
			// create a new table
			stmt.execute(sql);
			System.out.println("Table created sucessfully.");
			System.out.println(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void insert_customer_information(Customer customer) {

		String customerId = customer.getID();
		String customerName = customer.getName();
		String password = customer.getPassword();
		String phoneNumber = customer.getPhoneNumber();
		double balance = customer.getBalance();
		int type = customer.getType();
		double totalParse = customer.getTotalParse();

		String sql = "INSERT INTO " + customerTable
				+ " (customerId,customerName,password,phoneNumber,balance,type,totalParse) VALUES(?,?,?,?,?,?,?)";

		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, customerId);
			pstmt.setString(2, customerName);
			pstmt.setString(3, password);
			pstmt.setString(4, phoneNumber);
			pstmt.setDouble(5, balance);
			pstmt.setInt(6, type);
			pstmt.setDouble(7, totalParse);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void show_All_Customer() {
		String sql = "SELECT customerId,customerName,password,phoneNumber,balance,type,totalParse FROM " + customerTable
				+ "";

		try (Connection conn = this.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				System.out.println(rs.getString("customerId") + "\t" + rs.getString("customerName") + "\t"
						+ rs.getString("password") + "\t" + rs.getDouble("balance"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<Customer> get_all_customer() {
		ArrayList<Customer> allCustomer = new ArrayList<Customer>();

		String sql = "SELECT customerId,customerName,password,phoneNumber,balance,type,totalParse FROM " + customerTable
				+ "";

		try (Connection conn = this.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {

				Customer customer;
				if (rs.getInt("type") == 1)
					customer = new ClassicCustomer(rs.getString("customerId"), rs.getString("password"),
							rs.getString("customerName"), rs.getString("phoneNumber"), rs.getDouble("balance"), 1,
							rs.getDouble("totalParse"));

				else if (rs.getInt("type") == 2)
					customer = new PremiumCustomer(rs.getString("customerId"), rs.getString("password"),
							rs.getString("customerName"), rs.getString("phoneNumber"), rs.getDouble("balance"), 2,
							rs.getDouble("totalParse"));
				else
					customer = new PlatinumCustomer(rs.getString("customerId"), rs.getString("password"),
							rs.getString("customerName"), rs.getString("phoneNumber"), rs.getDouble("balance"), 3,
							rs.getDouble("totalParse"));

				allCustomer.add(customer);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return allCustomer;
	}

	public void updateCustomer(Customer customer) {
		String sql = "UPDATE " + customerTable + " SET customerName = ? , " + "password = ? , " + "phoneNumber = ? , "
				+ "balance = ? , " + "type = ? , " + "totalParse = ? " + "WHERE customerId = ?";

		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, customer.getName());
			pstmt.setString(2, customer.getPassword());
			pstmt.setString(3, customer.getPhoneNumber());
			pstmt.setDouble(4, customer.getBalance());
			pstmt.setInt(5, customer.getType());
			pstmt.setDouble(6, customer.getTotalParse());
			pstmt.setString(7, customer.getID());
			pstmt.executeUpdate();
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void delete_customer(String id) {
		String sql = "DELETE FROM " + customerTable + " WHERE customerId = ?";

		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, id);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	////////////////// product //////////////////////////////////////
	public void create_New_Table_for_product() {

		String sql = "CREATE TABLE IF NOT EXISTS " + productTable + " (\n" + "    id text PRIMARY KEY,\n"
				+ "    name text NOT NULL,\n" + "    price real NOT NULL,\n" + "    categoryID text NOT NULL,\n"
				+ "    categoryName text NOT NULL,\n" + "    quantity integer NOT NULL,\n"
				+ "    information text NOT NULL\n" + ");";

		try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
			stmt.execute(sql);
			System.out.println("Table created sucessfully.");
			System.out.println(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void insert_product(Product product) {
		String sql = "INSERT INTO " + productTable
				+ " (id,name,price,categoryID,categoryName,quantity,information) VALUES(?,?,?,?,?,?,?)";

		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, product.getID());
			pstmt.setString(2, product.getName());
			pstmt.setDouble(3, product.getPrice());
			pstmt.setString(4, product.getCatagory().getID());
			pstmt.setString(5, product.getCatagory().getName());
			pstmt.setInt(6, product.getQuantity());
			pstmt.setString(7, product.getProductInformation());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void show_All_product() {
		String sql = "SELECT id,name,price,categoryID,categoryName,quantity,information FROM " + productTable + "";

		try (Connection conn = this.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				System.out.println(rs.getString("id") + " " + rs.getString("name") + " " + rs.getDouble("price") + " "
						+ rs.getString("categoryID") + " " + rs.getString("categoryName") + " " + rs.getInt("quantity")
						+ " " + rs.getString("information"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<Product> get_all_products() {
		ArrayList<Product> allProdcuct = new ArrayList<Product>();

		String sql = "SELECT id,name,price,categoryID,categoryName,quantity,information FROM " + productTable + "";

		try (Connection conn = this.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				Catagory catagory = new Catagory(rs.getString("categoryID"), rs.getString("categoryName"));
				Product product = new Product(rs.getString("id"), rs.getString("name"), rs.getDouble("price"),
						rs.getInt("quantity"), catagory, rs.getString("information"));
				allProdcuct.add(product);

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return allProdcuct;
	}

	public void update_products_quantity(int i, String id) {
		String sql = "UPDATE " + productTable + " SET quantity = ? " + "WHERE id = ?";

		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, (i + get_product_quantity(id)));
			pstmt.setString(2, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	private int get_product_quantity(String string) {
		String sql = "SELECT id,name,price,categoryID,categoryName,quantity,information FROM " + productTable + "";

		try (Connection conn = this.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				if (rs.getString("id").equals(string))
					return rs.getInt("quantity");

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
