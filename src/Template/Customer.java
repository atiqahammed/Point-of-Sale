package Template;

public class Customer {
	protected String ID;
	protected String name;
	protected String password;
	protected String phoneNumber;
	protected double balance;

	public void setBalance(double balance) {
		this.balance = balance;
	}

	protected int type;
	protected double totalParse;

	public Customer(String iD, String password, String name, String phoneNumber, double balance, int type,
			double totalParse) {
		ID = iD;
		this.password = password;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.balance = balance;
		this.type = type;
		this.totalParse = totalParse;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getID() {
		return ID;
	}

	public double getBalance() {
		return balance;
	}

	public void deposite(double amount) {
		if (amount > 0.0)
			balance += amount;
	}

	public int getType() {
		return type;
	}

	public double getTotalParse() {
		return totalParse;
	}

}
