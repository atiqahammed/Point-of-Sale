package Database;

public class InformationControler {

	private All_Information database = new All_Information();
	private Information toSend = new Information();

	public Information give_MeInformation(Information information) {

		if (information.getType() == 1)
			toSend.setAdminLogIn(database.get_admin_log_info());
		if (information.getType() == 2)
			toSend.setAllCatagory(database.get_All_Catagory());
		if (information.getType() == 3)
			toSend.setAdminBalance(database.get_admin_balance());
		if (information.getType() == 4)
			toSend.setAllCustomer(database.get_all_customer());

		if (information.getType() == 5) {
			toSend.setCatagoryIdExists(database.search_category(information.getTextStr()));
		}

		if (information.getType() == 7)
			database.delete_customer(information.getTextStr());

		if (information.getType() == 6)
			toSend.setAllProduct(database.get_all_products());
		if (information.getType() == 8)
			database.insert_product(information.getProduct());
		if (information.getType() == 9)
			database.update_products_quantity(information.getQuantity(), information.getTextStr());
		if (information.getType() == 10)
			database.increaseBalance(information.getAmmount());

		if (information.getType() == 11)
			database.insert_ac(information.getTextStr(), information.getTextStr2());

		if (information.getType() == 12)
			toSend.setAllActivities(database.get_All_Ac(information.getTextStr()));

		if (information.getType() == -1) {
			database.insert_category(information.getTextStr(), information.getTextStr2());
		}

		if (information.getType() == -2)
			database.insert_customer_information(information.getCustomer());
		if (information.getType() == -3)
			database.updateCustomer(information.getCustomer());

		return toSend;
	}

}
