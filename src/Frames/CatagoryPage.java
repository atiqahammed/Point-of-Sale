package Frames;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Database.Information;
import Database.InformationControler;
import Template.Catagory;
import Template.Customer;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CatagoryPage {

	private JFrame frame;
	private int fromWhere;
	private int traverse;
	private ArrayList<Catagory> allCatagory;
	private InformationControler informationControler = new InformationControler();
	private Information information = new Information();
	private Customer customer;

	public void run() {
		try {
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public CatagoryPage(int fromWhere) {
		this.fromWhere = fromWhere;
		traverse = 0;
		initialize();
	}

	public CatagoryPage(int fromWhere, Customer customer) {
		this.fromWhere = fromWhere;
		this.customer = customer;
		traverse = 0;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 727, 482);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		JLabel catagoryLogo = new JLabel("  Catagory");
		catagoryLogo.setBounds(0, 0, 46, 14);
		catagoryLogo.setForeground(Color.YELLOW);
		catagoryLogo.setBackground(Color.GRAY);
		catagoryLogo.setFont(new Font("Palatino Linotype", Font.BOLD, 40));
		catagoryLogo.setBounds(0, 0, 727, 151);
		catagoryLogo.setOpaque(true);
		frame.getContentPane().add(catagoryLogo);

		JButton backButton = new JButton("Back");
		backButton.setForeground(Color.RED);
		backButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		backButton.setBounds(622, 11, 89, 23);
		catagoryLogo.add(backButton);

		JLabel idLabel = new JLabel("Catagory ID :");
		idLabel.setForeground(new Color(128, 0, 0));
		idLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
		idLabel.setBounds(215, 186, 135, 23);
		frame.getContentPane().add(idLabel);

		JLabel viewIdLabel = new JLabel("<id>");
		viewIdLabel.setFont(new Font("Verdana", Font.BOLD, 16));
		viewIdLabel.setBounds(371, 187, 197, 23);
		frame.getContentPane().add(viewIdLabel);

		JLabel nameLabel = new JLabel("Catagory Name :");
		nameLabel.setForeground(new Color(128, 0, 0));
		nameLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
		nameLabel.setBounds(182, 220, 168, 29);
		frame.getContentPane().add(nameLabel);

		JLabel viewNameLabel = new JLabel("<name>");
		viewNameLabel.setFont(new Font("Verdana", Font.BOLD, 16));
		viewNameLabel.setBounds(371, 221, 197, 29);
		frame.getContentPane().add(viewNameLabel);

		JButton viewProductButton = new JButton("View Products");
		viewProductButton.setForeground(new Color(0, 128, 0));
		viewProductButton.setFont(new Font("Verdana", Font.BOLD, 16));
		viewProductButton.setBounds(247, 310, 168, 50);
		frame.getContentPane().add(viewProductButton);

		JButton previousButton = new JButton("");

		previousButton.setIcon(new ImageIcon("pre.PNG"));
		previousButton.setBounds(10, 162, 123, 106);
		frame.getContentPane().add(previousButton);

		JButton nextButton = new JButton("");

		nextButton.setIcon(new ImageIcon("Capture.PNG"));
		nextButton.setBounds(545, 162, 113, 106);
		frame.getContentPane().add(nextButton);

		information.setType(2);
		information = informationControler.give_MeInformation(information);
		allCatagory = information.getAllCatagory();

		if (fromWhere == 0)
			viewProductButton.setVisible(false);

		if (traverse == 0)
			previousButton.setVisible(false);
		else
			previousButton.setVisible(true);
		if (traverse == allCatagory.size() - 1)
			nextButton.setVisible(false);
		else
			nextButton.setVisible(true);

		viewIdLabel.setText(allCatagory.get(traverse).getID());
		viewNameLabel.setText(allCatagory.get(traverse).getName());

		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				if (fromWhere == 0) {
					AdminPage adminPage = new AdminPage();
					adminPage.run();
				}

				else {
					Customer_Information customer_Information = new Customer_Information(customer);
					customer_Information.run();
				}

			}
		});

		viewProductButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				ProductPage page = new ProductPage(customer);
				page.run();

			}
		});

		previousButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				traverse--;
				if (traverse == 0)
					previousButton.setVisible(false);
				else
					previousButton.setVisible(true);
				if (traverse == allCatagory.size() - 1)
					nextButton.setVisible(false);
				else
					nextButton.setVisible(true);

				viewIdLabel.setText(allCatagory.get(traverse).getID());
				viewNameLabel.setText(allCatagory.get(traverse).getName());
			}
		});

		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				traverse++;
				if (traverse == 0)
					previousButton.setVisible(false);
				else
					previousButton.setVisible(true);
				if (traverse == allCatagory.size() - 1)
					nextButton.setVisible(false);
				else
					nextButton.setVisible(true);

				viewIdLabel.setText(allCatagory.get(traverse).getID());
				viewNameLabel.setText(allCatagory.get(traverse).getName());

			}
		});

		viewProductButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
	}
}
