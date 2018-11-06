package Frames;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import Database.Information;
import Database.InformationControler;
import Template.ClassicCustomer;
import Template.Customer;
import Template.PlatinumCustomer;
import Template.PremiumCustomer;
import Template.Product;

public class ProductPage {

	private JFrame frame;
	private JTextField quantityTextFIeld;
	private Customer customer;
	private int traverse;
	private ArrayList<Product> allProduct = new ArrayList<Product>();
	private Information information = new Information();
	private InformationControler informationControler = new InformationControler();

	public void run() {
		try {
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ProductPage(Customer customer) {
		this.customer = customer;
		initialize();

	}

	private void initialize() {
		traverse = 0;

		information.setType(6);
		information = informationControler.give_MeInformation(information);
		allProduct = information.getAllProduct();

		frame = new JFrame();
		frame.setBounds(100, 100, 727, 482);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel productNameLogo = new JLabel(" <product name>");
		productNameLogo.setBounds(0, 0, 46, 14);
		productNameLogo.setForeground(Color.YELLOW);
		productNameLogo.setBackground(Color.GRAY);
		productNameLogo.setFont(new Font("Palatino Linotype", Font.BOLD, 40));
		productNameLogo.setBounds(0, 0, 727, 151);
		productNameLogo.setOpaque(true);
		frame.getContentPane().add(productNameLogo);

		JButton backButton = new JButton("Back");
		backButton.setForeground(new Color(255, 0, 0));
		backButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		backButton.setBounds(640, 11, 71, 23);
		productNameLogo.add(backButton);

		JLabel idLabel = new JLabel("ID :");
		idLabel.setForeground(new Color(85, 107, 47));
		idLabel.setFont(new Font("Verdana", Font.BOLD, 15));
		idLabel.setBounds(277, 162, 31, 24);
		frame.getContentPane().add(idLabel);

		JLabel catagoryLabel = new JLabel("Catagory :");
		catagoryLabel.setForeground(new Color(85, 107, 47));
		catagoryLabel.setFont(new Font("Verdana", Font.BOLD, 15));
		catagoryLabel.setBounds(222, 185, 86, 24);
		frame.getContentPane().add(catagoryLabel);

		JLabel priceLabel = new JLabel("Price :");
		priceLabel.setForeground(new Color(85, 107, 47));
		priceLabel.setFont(new Font("Verdana", Font.BOLD, 15));
		priceLabel.setBounds(258, 209, 51, 24);
		frame.getContentPane().add(priceLabel);

		JLabel quantityLabel = new JLabel("Quantity :");
		quantityLabel.setForeground(new Color(85, 107, 47));
		quantityLabel.setFont(new Font("Verdana", Font.BOLD, 15));
		quantityLabel.setBounds(226, 233, 82, 24);
		frame.getContentPane().add(quantityLabel);

		JLabel informationLabel = new JLabel("Information :");
		informationLabel.setForeground(new Color(85, 107, 47));
		informationLabel.setFont(new Font("Verdana", Font.BOLD, 15));
		informationLabel.setBounds(198, 255, 110, 24);
		frame.getContentPane().add(informationLabel);

		JLabel idView = new JLabel("<id>");
		idView.setFont(new Font("Verdana", Font.PLAIN, 15));
		idView.setBounds(318, 162, 237, 24);
		frame.getContentPane().add(idView);

		JLabel catagoryView = new JLabel("<catagory>");
		catagoryView.setFont(new Font("Verdana", Font.PLAIN, 15));
		catagoryView.setBounds(318, 185, 229, 24);
		frame.getContentPane().add(catagoryView);

		JLabel priceView = new JLabel("<price>");
		priceView.setFont(new Font("Verdana", Font.PLAIN, 15));
		priceView.setBounds(319, 209, 228, 24);
		frame.getContentPane().add(priceView);

		JLabel quantityView = new JLabel("<quantity>");
		quantityView.setFont(new Font("Verdana", Font.PLAIN, 15));
		quantityView.setBounds(318, 233, 237, 24);
		frame.getContentPane().add(quantityView);

		JLabel informationView = new JLabel("<information>");
		informationView.setFont(new Font("Verdana", Font.PLAIN, 10));
		informationView.setBounds(318, 255, 229, 24);
		frame.getContentPane().add(informationView);

		JButton previousButton = new JButton("");
		previousButton.setIcon(new ImageIcon("pre.PNG"));
		previousButton.setBounds(31, 185, 100, 94);
		frame.getContentPane().add(previousButton);

		JButton nextButton = new JButton("");
		nextButton.setIcon(new ImageIcon("Capture.PNG"));
		nextButton.setBounds(565, 185, 100, 94);
		frame.getContentPane().add(nextButton);

		JButton buyButton = new JButton("Buy");

		buyButton.setFont(new Font("Verdana", Font.BOLD, 11));
		buyButton.setBounds(318, 305, 63, 23);
		frame.getContentPane().add(buyButton);

		quantityTextFIeld = new JTextField();
		quantityTextFIeld.setBounds(318, 339, 63, 20);
		frame.getContentPane().add(quantityTextFIeld);
		quantityTextFIeld.setColumns(10);

		JLabel buyQuantityLabel = new JLabel("Quantity :");
		buyQuantityLabel.setBounds(245, 339, 63, 20);
		frame.getContentPane().add(buyQuantityLabel);

		JButton confirmButton = new JButton("Confirm");
		confirmButton.setForeground(new Color(0, 100, 0));
		confirmButton.setFont(new Font("Verdana", Font.BOLD, 11));
		confirmButton.setBounds(401, 338, 89, 23);
		frame.getContentPane().add(confirmButton);

		JLabel error = new JLabel("<error>");
		error.setFont(new Font("Verdana", Font.BOLD, 14));
		error.setBounds(198, 370, 357, 24);
		frame.getContentPane().add(error);

		JLabel discountLabel = new JLabel("<discount>");
		discountLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		discountLabel.setForeground(new Color(0, 100, 0));
		discountLabel.setBounds(40, 162, 180, 14);
		frame.getContentPane().add(discountLabel);

		JLabel upgreadMassage = new JLabel("<upgread>");
		upgreadMassage.setForeground(new Color(165, 42, 42));
		upgreadMassage.setFont(new Font("Tahoma", Font.BOLD, 11));
		upgreadMassage.setBounds(31, 310, 229, 18);
		frame.getContentPane().add(upgreadMassage);

		if (customer.getType() == 1) {
			discountLabel.setVisible(true);
			discountLabel.setText("You will get 0% discount !!!");
		}

		if (customer.getType() == 2) {
			discountLabel.setVisible(true);
			discountLabel.setText("You will get 5% discount !!!");
		}

		if (customer.getType() == 3) {
			discountLabel.setVisible(true);
			discountLabel.setText("You will get 10% discount !!!");
		}

		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Customer_Information customer_Information = new Customer_Information(customer);
				customer_Information.run();

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

		idView.setText(allProduct.get(traverse).getID());
		productNameLogo.setText(allProduct.get(traverse).getName());
		catagoryView.setText(allProduct.get(traverse).getCatagory().getName());
		priceView.setText(Double.toString(allProduct.get(traverse).getPrice()));
		quantityView.setText(Integer.toString(allProduct.get(traverse).getQuantity()));
		informationView.setText(allProduct.get(traverse).getProductInformation());

		nextButton.addActionListener(new ActionListener() {

			@Override
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

				idView.setText(allProduct.get(traverse).getID());
				productNameLogo.setText(allProduct.get(traverse).getName());
				catagoryView.setText(allProduct.get(traverse).getCatagory().getName());
				priceView.setText(Double.toString(allProduct.get(traverse).getPrice()));
				quantityView.setText(Integer.toString(allProduct.get(traverse).getQuantity()));
				informationView.setText(allProduct.get(traverse).getProductInformation());

			}
		});

		previousButton.addActionListener(new ActionListener() {

			@Override
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

				idView.setText(allProduct.get(traverse).getID());
				productNameLogo.setText(allProduct.get(traverse).getName());
				catagoryView.setText(allProduct.get(traverse).getCatagory().getName());
				priceView.setText(Double.toString(allProduct.get(traverse).getPrice()));
				quantityView.setText(Integer.toString(allProduct.get(traverse).getQuantity()));
				informationView.setText(allProduct.get(traverse).getProductInformation());
			}
		});

		buyQuantityLabel.setVisible(false);
		quantityTextFIeld.setVisible(false);
		confirmButton.setVisible(false);
		error.setVisible(false);
		upgreadMassage.setVisible(false);

		buyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buyQuantityLabel.setVisible(true);
				quantityTextFIeld.setVisible(true);
				confirmButton.setVisible(true);
				buyButton.setVisible(false);
			}
		});

		confirmButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int quantity = Integer.parseInt(quantityTextFIeld.getText());
				double discount = 0.0;
				if (customer.getType() == 1)
					discount = 0.00;
				if (customer.getType() == 2)
					discount = 0.05;
				if (customer.getType() == 3)
					discount = 0.10;

				double cost = quantity
						* (allProduct.get(traverse).getPrice() - (allProduct.get(traverse).getPrice() * discount));

				if ((cost <= customer.getBalance()) && (quantity <= allProduct.get(traverse).getQuantity())
						&& (customer.getType() != 3)) {
					information.setType(9);
					information.setTextStr(allProduct.get(traverse).getID());
					information.setQuantity(-quantity);

					information = informationControler.give_MeInformation(information);
					information.setType(10);
					information.setAmmount(cost);

					information = informationControler.give_MeInformation(information);

					double parse = customer.getTotalParse();
					double newParse = cost + parse;

					information.setType(7);
					information.setTextStr(customer.getID());
					information = informationControler.give_MeInformation(information);
					Customer newCustomer = null;

					if (newParse >= 10000 && newParse < 100000) {
						if (customer.getType() == 1) {
							newCustomer = new PremiumCustomer(customer.getID(), customer.getPassword(),
									customer.getName(), customer.getPhoneNumber(), customer.getBalance() - cost, 2,
									newParse);
							JOptionPane.showMessageDialog(null, "You have been upgreaded to premium custtomer");
						}

						else {
							newCustomer = new PremiumCustomer(customer.getID(), customer.getPassword(),
									customer.getName(), customer.getPhoneNumber(), customer.getBalance() - cost, 2,
									newParse);

						}
					}

					else if (newParse >= 100000) {
						if (customer.getType() == 1) {
							newCustomer = new PlatinumCustomer(customer.getID(), customer.getPassword(),
									customer.getName(), customer.getPhoneNumber(), customer.getBalance() - cost, 3,
									newParse);
							JOptionPane.showMessageDialog(null, "You have been upgreaded to platinum custtomer");
						}

						if (customer.getType() == 2) {
							newCustomer = new PlatinumCustomer(customer.getID(), customer.getPassword(),
									customer.getName(), customer.getPhoneNumber(), customer.getBalance() - cost, 3,
									newParse);
							JOptionPane.showMessageDialog(null, "You have been upgreaded to platinum custtomer");
						}
					}

					else {
						newCustomer = new ClassicCustomer(customer.getID(), customer.getPassword(), customer.getName(),
								customer.getPhoneNumber(), customer.getBalance() - cost, 1, newParse);
					}

					information.setType(11);
					information.setTextStr(customer.getID());
					String tempstr = String
							.format("you have bought " + quantity + " " + allProduct.get(traverse).getName());
					information.setTextStr2(tempstr);
					information = informationControler.give_MeInformation(information);

					information.setCustomer(newCustomer);
					information.setType(-2);
					information = informationControler.give_MeInformation(information);// (

					frame.setVisible(false);
					ProductPage page = new ProductPage(newCustomer);
					page.run();
				}

				else if (customer.getType() == 3) {
					information.setType(9);
					information.setTextStr(allProduct.get(traverse).getID());
					information.setQuantity(-quantity);

					information = informationControler.give_MeInformation(information);
					information.setType(10);
					information.setAmmount(cost);

					information = informationControler.give_MeInformation(information);

					double parse = customer.getTotalParse();
					double newParse = cost + parse;

					information.setType(7);
					information.setTextStr(customer.getID());
					information = informationControler.give_MeInformation(information);
					Customer newCustomer = null;

					newCustomer = new PlatinumCustomer(customer.getID(), customer.getPassword(), customer.getName(),
							customer.getPhoneNumber(), customer.getBalance(), 3, newParse);

					information.setType(11);
					information.setTextStr(customer.getID());
					String tempstr = String
							.format("you have bought " + quantity + " " + allProduct.get(traverse).getName());
					information.setTextStr2(tempstr);
					information = informationControler.give_MeInformation(information);

					information.setCustomer(newCustomer);
					information.setType(-2);
					information = informationControler.give_MeInformation(information);

					frame.setVisible(false);
					ProductPage page = new ProductPage(newCustomer);
					page.run();

				}

				else if ((cost > customer.getBalance()))
					JOptionPane.showMessageDialog(null, "Sorry, you don't have enough money...");
				else
					JOptionPane.showMessageDialog(null, "Sorry, try with less quantity...");
			}
		});

	}

}
