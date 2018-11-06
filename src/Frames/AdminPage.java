package Frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Database.All_Information;
import Database.Information;
import Database.InformationControler;
import Template.Catagory;
import Template.Customer;
import Template.Product;
import regularX.REX;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class AdminPage {

	private JFrame frame;
	private JTextField catagoryIdTextField;
	private JTextField catagoryName;
	private JTextField newQuantityTextField;
	private JTextField IDFieldForNewProduct;
	private JTextField nameFieldForNewProduct;
	private JTextField priceFIeldForNewProduct;
	private JTextField quantityForNewProduct;
	private JTextField inforMationFieldFOrNewProduct;
	private InformationControler informationControler = new InformationControler();
	private Information information = new Information();
	private REX myRXtest = new REX();
	private ArrayList<Catagory> allCatagory = new ArrayList<Catagory>();
	private ArrayList<Product> allProduct = new ArrayList<Product>();
	private ArrayList<Customer> allCustomer = new ArrayList<Customer>();
	private boolean ptest1;
	private int traverse;

	public void run() {
		try {
			AdminPage window = new AdminPage();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public AdminPage() {
		initialize();
	}

	private void initialize() {
		traverse = 0;
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 625);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		ArrayList<String> notifications = new ArrayList<String>();

		information.setType(2);
		information = informationControler.give_MeInformation(information);
		allCatagory = information.getAllCatagory();
		ArrayList<String> allCatagoryID = new ArrayList<String>();
		for (int i = 0; i < allCatagory.size(); i++)
			allCatagoryID.add(allCatagory.get(i).getID());

		information.setType(6);
		information = informationControler.give_MeInformation(information);
		allProduct = information.getAllProduct();

		information.setType(4);
		information = informationControler.give_MeInformation(information);
		allCustomer = information.getAllCustomer();
		ArrayList<String> allCustomerInfoToDelete = new ArrayList<String>();

		for (int i = 0; i < allCustomer.size(); i++)
			allCustomerInfoToDelete.add(allCustomer.get(i).getID() + " " + allCustomer.get(i).getName());

		for (int z = 0; z < allProduct.size(); z++) {
			if (allProduct.get(z).getQuantity() < 10)
				notifications.add(allProduct.get(z).getID() + " 's product should be included");
		}

		JButton logOutButton = new JButton("Log out");
		logOutButton.setForeground(new Color(255, 0, 0));
		logOutButton.setFont(new Font("Verdana", Font.BOLD, 12));
		logOutButton.setBounds(10, 11, 123, 23);
		frame.getContentPane().add(logOutButton);

		JButton viewCatagoryButton = new JButton("View Catagory");
		viewCatagoryButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		viewCatagoryButton.setBounds(10, 45, 123, 23);
		frame.getContentPane().add(viewCatagoryButton);

		JLabel addCatagoryLabel = new JLabel("Add a new Catagory");
		addCatagoryLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		addCatagoryLabel.setBounds(10, 127, 169, 23);
		frame.getContentPane().add(addCatagoryLabel);

		catagoryIdTextField = new JTextField();
		catagoryIdTextField.setBounds(139, 161, 110, 23);
		frame.getContentPane().add(catagoryIdTextField);
		catagoryIdTextField.setColumns(10);

		JLabel ctagoryIDLabel = new JLabel("Catagory ID :");
		ctagoryIDLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		ctagoryIDLabel.setBounds(40, 161, 93, 23);
		frame.getContentPane().add(ctagoryIDLabel);

		JLabel catagoryIDError = new JLabel("");
		catagoryIDError.setIcon(new ImageIcon("error.png"));
		catagoryIDError.setBounds(260, 161, 29, 23);
		frame.getContentPane().add(catagoryIDError);
		catagoryIDError.setVisible(false);

		JLabel catagoryNameLabel = new JLabel("Catagory Name :");
		catagoryNameLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		catagoryNameLabel.setBounds(23, 195, 110, 23);
		frame.getContentPane().add(catagoryNameLabel);

		catagoryName = new JTextField();
		catagoryName.setBounds(139, 196, 110, 23);
		frame.getContentPane().add(catagoryName);
		catagoryName.setColumns(10);

		JButton confirmCatagoryButton = new JButton("Add");
		confirmCatagoryButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		confirmCatagoryButton.setBounds(10, 229, 119, 23);
		frame.getContentPane().add(confirmCatagoryButton);

		JButton previousButton = new JButton("");
		previousButton.setIcon(new ImageIcon("pre.PNG"));
		previousButton.setBounds(10, 338, 89, 88);
		frame.getContentPane().add(previousButton);

		JLabel increaseProductLabel = new JLabel("Increase product");
		increaseProductLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		increaseProductLabel.setBounds(10, 303, 225, 23);
		frame.getContentPane().add(increaseProductLabel);

		JLabel productNameToIncreaseLabel = new JLabel("Name :");
		productNameToIncreaseLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		productNameToIncreaseLabel.setBounds(109, 338, 43, 23);
		frame.getContentPane().add(productNameToIncreaseLabel);

		JLabel viewProductNameToIncrease = new JLabel("<name>");
		viewProductNameToIncrease.setFont(new Font("Tahoma", Font.BOLD, 11));
		viewProductNameToIncrease.setBounds(150, 338, 169, 23);
		frame.getContentPane().add(viewProductNameToIncrease);

		JLabel idLabelForProductIncrease = new JLabel("ID :");
		idLabelForProductIncrease.setFont(new Font("Tahoma", Font.BOLD, 11));
		idLabelForProductIncrease.setBounds(109, 360, 24, 23);
		frame.getContentPane().add(idLabelForProductIncrease);

		JLabel viewIdForIncrease = new JLabel("<id>");
		viewIdForIncrease.setFont(new Font("Tahoma", Font.BOLD, 11));
		viewIdForIncrease.setBounds(133, 360, 156, 23);
		frame.getContentPane().add(viewIdForIncrease);

		JLabel quantityLabelToIncreaseProduct = new JLabel("Quantity :");
		quantityLabelToIncreaseProduct.setFont(new Font("Tahoma", Font.BOLD, 11));
		quantityLabelToIncreaseProduct.setBounds(109, 383, 61, 14);
		frame.getContentPane().add(quantityLabelToIncreaseProduct);

		JLabel lblNewLabel = new JLabel("<quantity>");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(175, 379, 114, 23);
		frame.getContentPane().add(lblNewLabel);

		JButton nextButton = new JButton("");
		nextButton.setIcon(new ImageIcon("Capture.PNG"));
		nextButton.setBounds(362, 338, 89, 88);
		frame.getContentPane().add(nextButton);

		newQuantityTextField = new JTextField();
		newQuantityTextField.setText("Quantity");
		newQuantityTextField.setBounds(109, 406, 86, 20);
		frame.getContentPane().add(newQuantityTextField);
		newQuantityTextField.setColumns(10);

		JButton addQuantityButton = new JButton("Add");

		addQuantityButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		addQuantityButton.setBounds(211, 403, 61, 23);
		frame.getContentPane().add(addQuantityButton);

		JLabel addNewProductLabel = new JLabel("Add New Product");
		addNewProductLabel.setFont(new Font("Verdana", Font.BOLD, 13));
		addNewProductLabel.setBounds(610, 51, 169, 19);
		frame.getContentPane().add(addNewProductLabel);

		IDFieldForNewProduct = new JTextField();
		IDFieldForNewProduct.setText("ID");
		IDFieldForNewProduct.setBounds(610, 82, 169, 23);
		frame.getContentPane().add(IDFieldForNewProduct);
		IDFieldForNewProduct.setColumns(10);

		nameFieldForNewProduct = new JTextField();
		nameFieldForNewProduct.setText("Name");
		nameFieldForNewProduct.setBounds(610, 114, 169, 23);
		frame.getContentPane().add(nameFieldForNewProduct);
		nameFieldForNewProduct.setColumns(10);

		JLabel IDErrorForProduct = new JLabel("");
		IDErrorForProduct.setIcon(new ImageIcon("error.png"));
		IDErrorForProduct.setBounds(789, 81, 34, 23);
		frame.getContentPane().add(IDErrorForProduct);

		priceFIeldForNewProduct = new JTextField();
		priceFIeldForNewProduct.setText("Price");
		priceFIeldForNewProduct.setBounds(609, 148, 170, 22);
		frame.getContentPane().add(priceFIeldForNewProduct);
		priceFIeldForNewProduct.setColumns(10);

		quantityForNewProduct = new JTextField();
		quantityForNewProduct.setText("Quantity");
		quantityForNewProduct.setBounds(610, 178, 169, 23);
		frame.getContentPane().add(quantityForNewProduct);
		quantityForNewProduct.setColumns(10);

		JComboBox catagoryComboForProduct = new JComboBox();
		catagoryComboForProduct.setModel(new DefaultComboBoxModel(allCatagoryID.toArray()));

		catagoryComboForProduct.setBounds(610, 212, 169, 20);
		frame.getContentPane().add(catagoryComboForProduct);

		inforMationFieldFOrNewProduct = new JTextField();
		inforMationFieldFOrNewProduct.setText("Information");
		inforMationFieldFOrNewProduct.setBounds(610, 250, 169, 23);
		frame.getContentPane().add(inforMationFieldFOrNewProduct);
		inforMationFieldFOrNewProduct.setColumns(10);

		JButton addNewProductButton = new JButton("Add");

		addNewProductButton.setForeground(new Color(139, 0, 139));
		addNewProductButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		addNewProductButton.setBounds(610, 288, 93, 23);
		frame.getContentPane().add(addNewProductButton);

		JComboBox notification = new JComboBox();
		notification.setModel(new DefaultComboBoxModel(notifications.toArray()));
		notification.setBounds(211, 52, 322, 20);
		frame.getContentPane().add(notification);

		JComboBox customerCombo = new JComboBox();
		customerCombo.setModel(new DefaultComboBoxModel(allCustomerInfoToDelete.toArray()));
		customerCombo.setBounds(610, 380, 233, 20);
		frame.getContentPane().add(customerCombo);

		JButton deleteButton = new JButton("Delete");

		deleteButton.setForeground(new Color(255, 0, 0));
		deleteButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		deleteButton.setBounds(879, 379, 89, 23);
		frame.getContentPane().add(deleteButton);

		JLabel adminBalance = new JLabel("Balance :");
		adminBalance.setFont(new Font("Tahoma", Font.BOLD, 16));
		adminBalance.setBounds(189, 496, 93, 31);
		frame.getContentPane().add(adminBalance);

		JLabel showBalance = new JLabel("<balance>");
		showBalance.setFont(new Font("Tahoma", Font.BOLD, 14));
		showBalance.setBounds(293, 496, 194, 31);
		frame.getContentPane().add(showBalance);

		JLabel newCatagoryNameError = new JLabel("");
		newCatagoryNameError.setIcon(new ImageIcon("error.png"));
		newCatagoryNameError.setBounds(260, 195, 29, 23);
		frame.getContentPane().add(newCatagoryNameError);
		newCatagoryNameError.setVisible(false);

		information.setType(3);
		information = informationControler.give_MeInformation(information);
		showBalance.setText(Double.toString(information.getAdminBalance()));

		logOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				LogInPage logInPage = new LogInPage();
				logInPage.run();
			}
		});

		catagoryIdTextField.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				information.setType(5);
				information.setTextStr(catagoryIdTextField.getText());
				information = informationControler.give_MeInformation(information);
				boolean test = information.isCatagoryIdExists();

				if (test || !(myRXtest.strEmptyTest(catagoryIdTextField.getText())))
					catagoryIDError.setVisible(true);
				else
					catagoryIDError.setVisible(false);

			}

			public void focusGained(FocusEvent e) {

			}
		});

		catagoryName.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				if (!myRXtest.strEmptyTest(catagoryName.getText()))
					newCatagoryNameError.setVisible(true);
				else
					newCatagoryNameError.setVisible(false);

			}

			public void focusGained(FocusEvent e) {

			}
		});

		confirmCatagoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				information.setType(5);
				information.setTextStr(catagoryIdTextField.getText());
				information = informationControler.give_MeInformation(information);
				boolean test = information.isCatagoryIdExists();

				boolean testID = (test || !(myRXtest.strEmptyTest(catagoryIdTextField.getText())));
				boolean testName = !myRXtest.strEmptyTest(catagoryName.getText());

				if (testName)
					newCatagoryNameError.setVisible(true);
				if (testID)
					catagoryIDError.setVisible(true);

				if (!testID && !testName) {

					information.setType(-1);
					information.setTextStr(catagoryIdTextField.getText());
					information.setTextStr2(catagoryName.getText());
					information = informationControler.give_MeInformation(information);
					JOptionPane.showMessageDialog(null, "Catagory successfully added");
					frame.setVisible(false);

					AdminPage adminPage = new AdminPage();
					adminPage.run();
				}
			}
		});

		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String temp = customerCombo.getSelectedItem().toString();
				String info[] = temp.split(" ");
				information.setType(7);
				information.setTextStr(info[0]);
				information = informationControler.give_MeInformation(information);
				JOptionPane.showMessageDialog(null, info[1] + " has been deletde...");
				frame.setVisible(false);
				AdminPage adminPage = new AdminPage();
				adminPage.run();

			}
		});

		viewCatagoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				CatagoryPage catagoryPage = new CatagoryPage(0);
				catagoryPage.run();
			}
		});

		ptest1 = false;
		IDErrorForProduct.setVisible(false);
		IDFieldForNewProduct.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent arg0) {
				String temp = IDFieldForNewProduct.getText();
				boolean tempTest = true;
				for (int z = 0; z < allProduct.size(); z++) {
					if (temp.equals(allProduct.get(z).getID()))
						tempTest = false;
				}

				ptest1 = tempTest;
				if (temp.equals(""))
					ptest1 = false;
				if (!ptest1)
					IDErrorForProduct.setVisible(true);
				else
					IDErrorForProduct.setVisible(false);
			}

			@Override
			public void focusGained(FocusEvent arg0) {
				IDFieldForNewProduct.setText("");

			}
		});

		nameFieldForNewProduct.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent e) {

			}

			public void focusGained(FocusEvent e) {
				nameFieldForNewProduct.setText("");

			}
		});

		priceFIeldForNewProduct.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent e) {

			}

			public void focusGained(FocusEvent e) {
				priceFIeldForNewProduct.setText("");

			}
		});
		quantityForNewProduct.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent e) {

			}

			public void focusGained(FocusEvent e) {
				quantityForNewProduct.setText("");

			}
		});
		inforMationFieldFOrNewProduct.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent e) {

			}

			public void focusGained(FocusEvent e) {
				inforMationFieldFOrNewProduct.setText("");
			}
		});

		addNewProductButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (ptest1) {

					double price = Double.parseDouble(priceFIeldForNewProduct.getText());
					int quantity = Integer.parseInt(quantityForNewProduct.getText());
					String temptt = (String) catagoryComboForProduct.getSelectedItem();

					Catagory tempcatagory = null;
					for (int z = 0; z < allCatagory.size(); z++) {
						if (temptt.equals(allCatagory.get(z).getID()))
							tempcatagory = allCatagory.get(z);
					}

					Product product = new Product(IDFieldForNewProduct.getText(), nameFieldForNewProduct.getText(),
							price, quantity, tempcatagory, inforMationFieldFOrNewProduct.getText());
					information.setProduct(product);
					information.setType(8);

					information = informationControler.give_MeInformation(information);

					JOptionPane.showMessageDialog(null, "Product has been added");
					frame.setVisible(false);
					AdminPage adminPage = new AdminPage();
					adminPage.run();
				}

				else {
					JOptionPane.showMessageDialog(null, "Error !!!!!");
				}

			}
		});

		if (traverse == 0)
			previousButton.setVisible(false);
		else
			previousButton.setVisible(true);

		if (traverse == allProduct.size() - 1)
			nextButton.setVisible(false);
		else
			nextButton.setVisible(true);

		viewProductNameToIncrease.setText(allProduct.get(traverse).getName());
		viewIdForIncrease.setText(allProduct.get(traverse).getID());
		lblNewLabel.setText(Double.toString(allProduct.get(traverse).getQuantity()));

		previousButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				traverse--;

				if (traverse == 0)
					previousButton.setVisible(false);
				else
					previousButton.setVisible(true);

				if (traverse == allProduct.size() - 1)
					nextButton.setVisible(false);
				else
					nextButton.setVisible(true);

				viewProductNameToIncrease.setText(allProduct.get(traverse).getName());
				viewIdForIncrease.setText(allProduct.get(traverse).getID());
				lblNewLabel.setText(Double.toString(allProduct.get(traverse).getQuantity()));
			}
		});

		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				traverse++;

				if (traverse == 0)
					previousButton.setVisible(false);
				else
					previousButton.setVisible(true);

				if (traverse == allProduct.size() - 1)
					nextButton.setVisible(false);
				else
					nextButton.setVisible(true);

				viewProductNameToIncrease.setText(allProduct.get(traverse).getName());
				viewIdForIncrease.setText(allProduct.get(traverse).getID());
				lblNewLabel.setText(Double.toString(allProduct.get(traverse).getQuantity()));
			}
		});

		newQuantityTextField.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusGained(FocusEvent e) {
				newQuantityTextField.setText("");

			}
		});

		addQuantityButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int adding = Integer.parseInt(newQuantityTextField.getText());
				information.setType(9);
				information.setQuantity(adding);
				information.setTextStr(allProduct.get(traverse).getID());

				information = informationControler.give_MeInformation(information);
				JOptionPane.showMessageDialog(null, "Quantity increased....");
				frame.setVisible(false);
				AdminPage adminPage = new AdminPage();
				adminPage.run();
			}
		});

	}
}
