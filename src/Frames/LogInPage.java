package Frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

import Database.Information;
import Database.InformationControler;
import Template.ClassicCustomer;
import Template.Customer;
import regularX.REX;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class LogInPage {

	private JFrame frame;
	private JTextField loginID;
	private JPasswordField loginPassword;
	private JLabel ID;
	private JLabel Password;
	private JLabel wrongIdOrPassword;
	private JLabel creatAccountLable;
	private JLabel nameLable;
	private JTextField newName;
	private JLabel nameError;
	private JLabel newIDLabel;
	private JLabel newPasswordLabel;
	private JLabel IDError;
	private JTextField newID;
	private JLabel newPhoneLabel;
	private JTextField newPhone;
	private JLabel passwordError;
	private JLabel phoneError;
	private JButton signUpButtone;
	private JPasswordField newPassword;
	private JButton exitButton;
	private InformationControler informationControler = new InformationControler();
	private Information information = new Information();
	private JButton login;
	private REX myRex = new REX();
	private boolean nameTest, idTest, phoneTest, passwordTest;

	public void run() {
		try {
			LogInPage window = new LogInPage();
			window.frame.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public LogInPage() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 727, 482);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		JLabel lblPoint = new JLabel("    Point Of Sale ");
		lblPoint.setForeground(Color.YELLOW);
		lblPoint.setBackground(Color.GRAY);
		lblPoint.setFont(new Font("Palatino Linotype", Font.BOLD, 40));
		lblPoint.setBounds(0, 0, 727, 151);
		frame.getContentPane().add(lblPoint);
		lblPoint.setOpaque(true);

		loginID = new JTextField();
		loginID.setBounds(360, 70, 156, 20);
		lblPoint.add(loginID);
		loginID.setColumns(10);

		loginPassword = new JPasswordField();
		loginPassword.setBounds(537, 70, 156, 20);
		lblPoint.add(loginPassword);

		ID = new JLabel(" ID");
		ID.setForeground(Color.WHITE);
		ID.setFont(new Font("Verdana", Font.BOLD, 13));
		ID.setBounds(360, 40, 156, 20);
		lblPoint.add(ID);

		Password = new JLabel("Password");
		Password.setFont(new Font("Verdana", Font.BOLD, 13));
		Password.setForeground(Color.WHITE);
		Password.setBounds(537, 44, 156, 20);
		lblPoint.add(Password);

		wrongIdOrPassword = new JLabel("Wrong ID or Password");
		wrongIdOrPassword.setForeground(Color.RED);
		wrongIdOrPassword.setFont(new Font("Verdana", Font.BOLD, 13));
		wrongIdOrPassword.setBounds(360, 109, 218, 20);
		lblPoint.add(wrongIdOrPassword);
		wrongIdOrPassword.setVisible(false);

		creatAccountLable = new JLabel("Create a free account");
		creatAccountLable.setFont(new Font("Verdana", Font.BOLD, 22));
		creatAccountLable.setForeground(new Color(128, 0, 0));
		creatAccountLable.setBounds(21, 157, 276, 50);
		frame.getContentPane().add(creatAccountLable);

		nameLable = new JLabel("Name        : ");
		nameLable.setFont(new Font("Verdana", Font.BOLD, 16));
		nameLable.setForeground(new Color(128, 0, 0));
		nameLable.setBounds(21, 220, 113, 31);
		frame.getContentPane().add(nameLable);

		newName = new JTextField();
		newName.setBounds(159, 223, 175, 31);
		frame.getContentPane().add(newName);
		newName.setColumns(10);

		nameError = new JLabel("Wrong name format !");
		nameError.setForeground(new Color(255, 0, 0));
		nameError.setFont(new Font("Verdana", Font.BOLD, 12));
		nameError.setBounds(429, 223, 246, 31);
		frame.getContentPane().add(nameError);
		nameError.setVisible(false);

		newIDLabel = new JLabel("ID              :");
		newIDLabel.setForeground(new Color(128, 0, 0));
		newIDLabel.setFont(new Font("Verdana", Font.BOLD, 16));
		newIDLabel.setBounds(21, 274, 113, 31);
		frame.getContentPane().add(newIDLabel);

		// nothing to do with it
		newPasswordLabel = new JLabel("Password :");
		newPasswordLabel.setFont(new Font("Verdana", Font.BOLD, 16));
		newPasswordLabel.setForeground(new Color(128, 0, 0));
		newPasswordLabel.setBounds(21, 329, 113, 31);
		frame.getContentPane().add(newPasswordLabel);

		// initially this will be false but previous will alive it
		IDError = new JLabel("This already exists !");
		IDError.setForeground(new Color(255, 0, 0));
		IDError.setFont(new Font("Verdana", Font.BOLD, 12));
		IDError.setBounds(429, 277, 200, 31);
		frame.getContentPane().add(IDError);
		IDError.setVisible(false);

		// nothing to with it
		newID = new JTextField();
		newID.setBounds(159, 277, 174, 31);
		frame.getContentPane().add(newID);
		newID.setColumns(10);

		// nothing to with it
		newPhoneLabel = new JLabel("Phone       :");
		newPhoneLabel.setFont(new Font("Verdana", Font.BOLD, 16));
		newPhoneLabel.setForeground(new Color(128, 0, 0));
		newPhoneLabel.setBounds(21, 380, 113, 31);
		frame.getContentPane().add(newPhoneLabel);

		// nothing to do with it
		newPhone = new JTextField();
		newPhone.setBounds(159, 380, 175, 31);
		frame.getContentPane().add(newPhone);
		newPhone.setColumns(10);

		// small password will make it alive
		passwordError = new JLabel("Equal or longer than 5 and lett than or equal 10 Character !");
		passwordError.setForeground(new Color(255, 0, 0));
		passwordError.setFont(new Font("Verdana", Font.BOLD, 8));
		passwordError.setBounds(429, 332, 282, 31);
		frame.getContentPane().add(passwordError);
		passwordError.setVisible(false);

		// error phone number will make it cry
		phoneError = new JLabel("Wrong Phone Number format !");
		phoneError.setForeground(new Color(255, 0, 0));
		phoneError.setFont(new Font("Verdana", Font.BOLD, 12));
		phoneError.setBounds(429, 383, 246, 31);
		frame.getContentPane().add(phoneError);
		phoneError.setVisible(false);

		signUpButtone = new JButton("sign up");
		signUpButtone.setFont(new Font("Tahoma", Font.BOLD, 11));

		signUpButtone.setBounds(609, 176, 83, 23);
		frame.getContentPane().add(signUpButtone);

		newPassword = new JPasswordField();
		newPassword.setBounds(159, 332, 175, 31);
		frame.getContentPane().add(newPassword);

		exitButton = new JButton("exit");
		exitButton.setForeground(Color.RED);
		exitButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		exitButton.setBounds(609, 11, 83, 23);
		lblPoint.add(exitButton);

		information.setType(1);
		information = informationControler.give_MeInformation(information);
		String adminloginInfo[] = information.getAdminLogIn();

		information.setType(4);
		information = informationControler.give_MeInformation(information);
		ArrayList<Customer> allCustomer = information.getAllCustomer();

		login = new JButton("log in");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (loginID.getText().equals(adminloginInfo[0]) && loginPassword.getText().equals(adminloginInfo[1])) {
					frame.setVisible(false);
					AdminPage adminPage = new AdminPage();
					adminPage.run();
				}

				else {

					boolean test = false;
					for (int index = 0; index < allCustomer.size(); index++) {
						if ((allCustomer.get(index).getID().equals(loginID.getText())
								&& (allCustomer.get(index).getPassword().equals(loginPassword.getText())))) {
							frame.setVisible(false);
							Customer_Information customer_Information = new Customer_Information(
									allCustomer.get(index));
							customer_Information.run();
						}
					}

					wrongIdOrPassword.setVisible(true);
				}
			}
		});
		login.setFont(new Font("Tahoma", Font.BOLD, 11));
		login.setBounds(609, 113, 83, 23);
		lblPoint.add(login);

		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Thank you !!!!");
				frame.setVisible(false);
			}
		});

		newName.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {
				nameTest = myRex.checkName(newName.getText());
				if (!nameTest)
					nameError.setVisible(true);
				else
					nameError.setVisible(false);
			}

			public void focusGained(FocusEvent arg0) {

			}
		});

		newID.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {
				idTest = true;
				if (newID.getText().equals(adminloginInfo[0]))
					idTest = false;

				for (int i = 0; i < allCustomer.size(); i++)
					if (allCustomer.get(i).getID().equals(newID.getText()))
						idTest = false;

				if (!idTest || newID.getText().equals("")) {
					IDError.setVisible(true);
					idTest = false;

				} else
					IDError.setVisible(false);

			}

			@Override
			public void focusGained(FocusEvent arg0) {

			}
		});

		newPassword.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent arg0) {
				passwordTest = myRex.checkPassword(newPassword.getText());
				if (!passwordTest)
					passwordError.setVisible(true);
				else
					passwordError.setVisible(false);

			}

			public void focusGained(FocusEvent arg0) {

			}
		});

		newPhone.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent arg0) {
				phoneTest = myRex.checkPhoneNumber(newPhone.getText());
				if (!phoneTest)
					phoneError.setVisible(true);
				else
					phoneError.setVisible(false);

			}

			@Override
			public void focusGained(FocusEvent arg0) {

			}
		});

		signUpButtone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (nameTest && idTest && passwordTest && phoneTest) {
					Customer customer = new ClassicCustomer(newID.getText(), newPassword.getText(), newName.getText(),
							newPhone.getText(), 1000, 1, 0);
					information = new Information();
					information.setCustomer(customer);
					frame.setVisible(false);
					information.setType(-2);
					information = informationControler.give_MeInformation(information);// (information);
					Customer_Information customer_Information = new Customer_Information(customer);
					customer_Information.run();
				}

				else
					JOptionPane.showMessageDialog(null, "Sorry, there is an error.............");
			}
		});
	}

	private static class __Tmp {
		private static void __tmp() {
			javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
