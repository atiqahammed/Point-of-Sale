package Database;

import java.util.ArrayList;

import Template.Catagory;
import Template.Customer;
import Template.Product;

public class Information {
	private String[] adminLogIn = new String[2];
	private boolean isCatagoryIdExists;
	private ArrayList<Catagory> allCatagory;
	private double adminBalance;
	private ArrayList<Customer> allCustomer;
	private Customer customer;
	private int type;
	private String textStr;
	private String textStr2;
	private ArrayList<Product> allProduct = new ArrayList<Product>();
	private Product product;
	private int quantity;
	private double ammount;
	private ArrayList<String> allActivities;

	public String[] getAdminLogIn() {
		return adminLogIn;
	}

	public void setAdminLogIn(String[] adminLogIn) {
		this.adminLogIn = adminLogIn;
	}

	public boolean isCatagoryIdExists() {
		return isCatagoryIdExists;
	}

	public void setCatagoryIdExists(boolean isCatagoryIdExists) {
		this.isCatagoryIdExists = isCatagoryIdExists;
	}

	public ArrayList<Catagory> getAllCatagory() {
		return allCatagory;
	}

	public void setAllCatagory(ArrayList<Catagory> allCatagory) {
		this.allCatagory = allCatagory;
	}

	public double getAdminBalance() {
		return adminBalance;
	}

	public void setAdminBalance(double adminBalance) {
		this.adminBalance = adminBalance;
	}

	public ArrayList<Customer> getAllCustomer() {
		return allCustomer;
	}

	public void setAllCustomer(ArrayList<Customer> allCustomer) {
		this.allCustomer = allCustomer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getTextStr() {
		return textStr;
	}

	public void setTextStr(String textStr) {
		this.textStr = textStr;
	}

	public String getTextStr2() {
		return textStr2;
	}

	public void setTextStr2(String textStr2) {
		this.textStr2 = textStr2;
	}

	public ArrayList<Product> getAllProduct() {
		return allProduct;
	}

	public void setAllProduct(ArrayList<Product> allProduct) {
		this.allProduct = allProduct;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getAmmount() {
		return ammount;
	}

	public void setAmmount(double ammount) {
		this.ammount = ammount;
	}

	public ArrayList<String> getAllActivities() {
		return allActivities;
	}

	public void setAllActivities(ArrayList<String> allActivities) {
		this.allActivities = allActivities;
	}

}
