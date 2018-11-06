package Template;

import java.util.ArrayList;

public class PlatinumCustomer extends Customer {

	private ArrayList<String> activities = new ArrayList<String>();

	public PlatinumCustomer(String iD, String password, String name, String phoneNumber, double balance, int type,
			double totalParse) {
		super(iD, password, name, phoneNumber, balance, type, totalParse);
		// TODO Auto-generated constructor stub
	}

	public ArrayList<String> getActivities() {
		return activities;
	}

	public void setActivities(ArrayList<String> activities) {
		this.activities = activities;
	}

}
