package Template;

public class Product {
	private String ID;
	private String name;
	private double price;
	private int quantity;
	private Catagory catagory;
	private String productInformation = "No information avilable.";

	public String getProductInformation() {
		return productInformation;
	}

	public Product(String iD, String name, double price, int quantity, Catagory catagory, String productInformation) {
		ID = iD;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.catagory = catagory;
		this.productInformation = productInformation;
	}

	public Product(String iD, String name, double price, int quantity, Catagory catagory) {
		ID = iD;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.catagory = catagory;
	}

	public String getID() {
		return ID;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public Catagory getCatagory() {
		return catagory;
	}
}
