
package Frames;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import Database.Information;
import Database.InformationControler;
import Template.ClassicCustomer;
import Template.Customer;
import Template.PlatinumCustomer;
import Template.PremiumCustomer;
import regularX.REX;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.security.auth.kerberos.DelegationPermission;
import javax.swing.DefaultComboBoxModel;

public class Customer_Information {

	private JFrame frame;
	private JTextField newNameTextField;
	private JPasswordField newPasswordField;
	private JTextField newPhoneTextField;
	private JTextField depositField;
	private boolean nameTest = true, passwordTest = true, phoneTest = true;
	private REX myRxx = new REX();
	private ArrayList<String> allActivities;

	public void run() {
		try {
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Customer_Information(Customer customer) {
		initialize(customer);
	}

	private void initialize(Customer customer) {
		Information information = new Information();
		InformationControler informationControler = new InformationControler();

		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Verdana", Font.PLAIN, 13));
		frame.setBounds(100, 100, 727, 482);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		Information info = new Information();
		info.setTextStr(customer.getID());
		info.setType(12);
		info = informationControler.give_MeInformation(info);
		allActivities = info.getAllActivities();

		JLabel nameLabel = new JLabel(" <name>");
		nameLabel.setForeground(Color.YELLOW);
		nameLabel.setBackground(Color.GRAY);
		nameLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 40));
		nameLabel.setBounds(0, 0, 727, 151);
		frame.getContentPane().add(nameLabel);
		nameLabel.setOpaque(true);
		nameLabel.setText(customer.getName());

		JButton logOutButton = new JButton("log out");
		logOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				LogInPage inPage = new LogInPage();
				inPage.run();
			}
		});
		logOutButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		logOutButton.setForeground(Color.RED);
		logOutButton.setBounds(583, 10, 128, 29);
		nameLabel.add(logOutButton);

		JButton viewCatagoryButton = new JButton("view Catagory");

		viewCatagoryButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		viewCatagoryButton.setBounds(582, 53, 129, 28);
		nameLabel.add(viewCatagoryButton);

		JButton viewProductButton = new JButton("view Product");
		viewProductButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		viewProductButton.setBounds(581, 93, 130, 30);
		nameLabel.add(viewProductButton);

		JButton editProfileButton = new JButton("Edit Profile ");

		editProfileButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		editProfileButton.setBounds(579, 159, 132, 29);
		frame.getContentPane().add(editProfileButton);

		newNameTextField = new JTextField();
		newNameTextField.setBounds(504, 199, 170, 29);
		frame.getContentPane().add(newNameTextField);
		newNameTextField.setColumns(10);
		newNameTextField.setVisible(false);

		newPasswordField = new JPasswordField();
		newPasswordField.setBounds(504, 239, 170, 29);
		frame.getContentPane().add(newPasswordField);
		newPasswordField.setVisible(false);

		newPhoneTextField = new JTextField();
		newPhoneTextField.setBounds(504, 279, 170, 29);
		frame.getContentPane().add(newPhoneTextField);
		newPhoneTextField.setColumns(10);
		newPhoneTextField.setVisible(false);

		JButton confirmButton = new JButton("confirm");
		confirmButton.setForeground(new Color(0, 128, 0));
		confirmButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		confirmButton.setBounds(579, 318, 97, 23);
		frame.getContentPane().add(confirmButton);
		confirmButton.setVisible(false);

		JLabel nameError = new JLabel("");
		nameError.setIcon(new ImageIcon("error.png"));
		nameError.setBounds(684, 199, 27, 29);
		frame.getContentPane().add(nameError);
		nameError.setVisible(false);

		JLabel passwordError = new JLabel("");
		passwordError.setIcon(new ImageIcon("error.png"));
		passwordError.setBounds(684, 239, 27, 29);
		frame.getContentPane().add(passwordError);
		passwordError.setVisible(false);

		JLabel phoneError = new JLabel("");
		phoneError.setIcon(new ImageIcon("error.png"));
		phoneError.setBounds(684, 279, 27, 29);
		frame.getContentPane().add(phoneError);
		phoneError.setVisible(false);

		JLabel newNameLabel = new JLabel("name :");
		newNameLabel.setToolTipText("");
		newNameLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		newNameLabel.setBounds(448, 199, 46, 29);
		frame.getContentPane().add(newNameLabel);
		newNameLabel.setVisible(false);

		JLabel newPasswordLabel = new JLabel("password :");
		newPasswordLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		newPasswordLabel.setBounds(421, 246, 73, 14);
		frame.getContentPane().add(newPasswordLabel);
		newPasswordLabel.setVisible(false);

		JLabel newPhoneLabel = new JLabel("phone :");
		newPhoneLabel.setFont(new Font("Verdana", Font.BOLD, 11));
		newPhoneLabel.setBounds(446, 279, 48, 29);
		frame.getContentPane().add(newPhoneLabel);
		newPhoneLabel.setVisible(false);

		JLabel idLabel = new JLabel("ID :");
		idLabel.setForeground(new Color(128, 0, 0));
		idLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		idLabel.setBounds(57, 159, 27, 29);
		frame.getContentPane().add(idLabel);

		JLabel idView = new JLabel("<id>");
		idView.setFont(new Font("Verdana", Font.BOLD, 13));
		idView.setBounds(111, 157, 229, 29);
		frame.getContentPane().add(idView);
		idView.setText(customer.getID());

		JLabel passLabel = new JLabel("Password :");
		passLabel.setForeground(new Color(128, 0, 0));
		passLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		passLabel.setBounds(2, 237, 82, 29);
		frame.getContentPane().add(passLabel);

		JLabel swowingPassLabel = new JLabel("<pass>");
		swowingPassLabel.setFont(new Font("Verdana", Font.BOLD, 13));
		swowingPassLabel.setBounds(111, 237, 229, 29);
		frame.getContentPane().add(swowingPassLabel);
		swowingPassLabel.setText(customer.getPassword());

		JLabel phoneLabel = new JLabel("Phone :");
		phoneLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		phoneLabel.setForeground(new Color(128, 0, 0));
		phoneLabel.setBounds(30, 184, 54, 29);
		frame.getContentPane().add(phoneLabel);

		JLabel showingPhoneLabel = new JLabel("<phone>");
		showingPhoneLabel.setFont(new Font("Verdana", Font.BOLD, 13));
		showingPhoneLabel.setBounds(111, 184, 229, 29);
		frame.getContentPane().add(showingPhoneLabel);
		showingPhoneLabel.setText(customer.getPhoneNumber());

		JLabel typeLabel = new JLabel("type :");
		typeLabel.setForeground(new Color(128, 0, 0));
		typeLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		typeLabel.setBounds(40, 213, 44, 29);
		frame.getContentPane().add(typeLabel);

		String type[] = { "Classical Customer", "Premium Customer", "Platinum Customer" };

		JLabel viewTypeLabel = new JLabel("<type>");
		viewTypeLabel.setFont(new Font("Verdana", Font.BOLD, 13));
		viewTypeLabel.setBounds(111, 213, 229, 29);
		frame.getContentPane().add(viewTypeLabel);
		viewTypeLabel.setText(type[customer.getType() - 1]);

		JLabel balanceLabel = new JLabel("Balance :");
		balanceLabel.setForeground(new Color(128, 0, 0));
		balanceLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		balanceLabel.setBounds(11, 265, 73, 29);
		frame.getContentPane().add(balanceLabel);

		JLabel viewBalanceLabel = new JLabel("<balance>");
		viewBalanceLabel.setFont(new Font("Verdana", Font.BOLD, 13));
		viewBalanceLabel.setBounds(111, 265, 170, 29);
		frame.getContentPane().add(viewBalanceLabel);
		viewBalanceLabel.setText(Double.toString(customer.getBalance()));

		JLabel parseLabel = new JLabel("Parse :");
		parseLabel.setForeground(new Color(128, 0, 0));
		parseLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		parseLabel.setBounds(30, 291, 54, 29);
		frame.getContentPane().add(parseLabel);

		JLabel viewParseLabel = new JLabel("<parse>");
		viewParseLabel.setFont(new Font("Verdana", Font.BOLD, 13));
		viewParseLabel.setBounds(111, 291, 170, 29);
		frame.getContentPane().add(viewParseLabel);
		viewParseLabel.setText(Double.toString(customer.getTotalParse()));

		JButton depositButton = new JButton("Deposit");

		depositButton.setForeground(new Color(107, 142, 35));
		depositButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		depositButton.setBounds(344, 318, 89, 23);
		frame.getContentPane().add(depositButton);

		depositField = new JTextField();
		depositField.setBounds(286, 352, 147, 29);
		frame.getContentPane().add(depositField);
		depositField.setColumns(10);
		depositField.setVisible(false);

		JButton depositConfirmButton = new JButton("Confirm");

		depositConfirmButton.setForeground(new Color(0, 128, 0));
		depositConfirmButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		depositConfirmButton.setBounds(344, 392, 89, 23);
		frame.getContentPane().add(depositConfirmButton);
		depositConfirmButton.setVisible(false);

		JLabel depositError = new JLabel("too much ammont !!!");
		depositError.setForeground(new Color(255, 0, 0));
		depositError.setFont(new Font("Tahoma", Font.BOLD, 11));
		depositError.setBounds(440, 359, 116, 14);
		frame.getContentPane().add(depositError);

		JComboBox activitiesComboBox = new JComboBox();
		activitiesComboBox.setFont(new Font("Tahoma", Font.PLAIN, 10));
		activitiesComboBox.setModel(new DefaultComboBoxModel(allActivities.toArray()));
		activitiesComboBox.setToolTipText("");
		activitiesComboBox.setBounds(11, 356, 265, 20);
		frame.getContentPane().add(activitiesComboBox);
		depositError.setVisible(false);
		if (customer.getType() == 1)
			activitiesComboBox.setVisible(false);

		activitiesComboBox.setVisible(true);

		depositButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				depositField.setVisible(true);
				depositConfirmButton.setVisible(true);
				viewProductButton.setVisible(false);
				viewCatagoryButton.setVisible(false);
				editProfileButton.setVisible(false);
				depositButton.setVisible(false);
			}
		});

		depositConfirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double amount = Double.parseDouble(depositField.getText());
				if (amount > 1000.00)
					depositError.setVisible(true);

				if (amount <= 1000.00 && amount > 0.00) {
					depositError.setVisible(false);
					depositField.setText("");
					depositField.setVisible(false);
					depositConfirmButton.setVisible(false);
					depositButton.setVisible(true);
					editProfileButton.setVisible(true);
					viewCatagoryButton.setVisible(true);
					viewProductButton.setVisible(true);

					customer.setBalance(customer.getBalance() + amount);
					information.setCustomer(customer);
					information.setType(-3);
					Information information1 = informationControler.give_MeInformation(information);

					JOptionPane.showMessageDialog(null, amount + " taka has been deposited.");
					frame.setVisible(false);
					Customer_Information customer_Information = new Customer_Information(customer);
					customer_Information.run();

				}
			}
		});

		viewCatagoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				CatagoryPage catagoryPage = new CatagoryPage(1, customer);
				catagoryPage.run();
			}
		});

		viewProductButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				ProductPage page = new ProductPage(customer);
				page.run();

			}
		});

		editProfileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				editProfileButton.setVisible(false);
				newNameLabel.setVisible(true);
				newNameTextField.setVisible(true);
				newPasswordLabel.setVisible(true);
				newPasswordField.setVisible(true);
				newPhoneLabel.setVisible(true);
				newPhoneTextField.setVisible(true);
				confirmButton.setVisible(true);

				newNameTextField.setText(customer.getName());
				newPasswordField.setText(customer.getPassword());
				newPhoneTextField.setText(customer.getPhoneNumber());
			}
		});

		newNameTextField.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {
				nameTest = myRxx.checkName(newNameTextField.getText());
				nameError.setVisible(!nameTest);

			}

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		newPasswordField.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				passwordTest = myRxx.checkPassword(newPasswordField.getText());
				passwordError.setVisible(!passwordTest);

			}

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		newPhoneTextField.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {
				phoneTest = myRxx.checkPhoneNumber(newPhoneTextField.getText());
				phoneError.setVisible(!phoneTest);

			}

			@Override
			public void focusGained(FocusEvent arg0) {

			}
		});

		confirmButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (nameTest && phoneTest && passwordTest) {
					information.setType(7);
					information.setTextStr(customer.getID());
					Information information1 = informationControler.give_MeInformation(information);
					Customer newCustomer = null;

					if (customer.getType() == 1)
						newCustomer = new ClassicCustomer(customer.getID(), newPasswordField.getText(),
								newNameTextField.getText(), newPhoneTextField.getText(), customer.getBalance(), 1,
								customer.getTotalParse());
					else if (customer.getType() == 2)
						newCustomer = new PlatinumCustomer(customer.getID(), newPasswordField.getText(),
								newNameTextField.getText(), newPhoneTextField.getText(), customer.getBalance(), 2,
								customer.getTotalParse());
					else
						newCustomer = new PremiumCustomer(customer.getID(), newPasswordField.getText(),
								newNameTextField.getText(), newPhoneTextField.getText(), customer.getBalance(), 3,
								customer.getTotalParse());

					information.setCustomer(newCustomer);
					information.setType(-2);
					Information dummyInformation = informationControler.give_MeInformation(information);

					JOptionPane.showMessageDialog(null, "Profile has been edited..");
					frame.setVisible(false);
					Customer_Information customer_Information = new Customer_Information(newCustomer);
					customer_Information.run();
				}

				else {
					JOptionPane.showMessageDialog(null, "Error.....................");
				}
			}
		});

	}
}
