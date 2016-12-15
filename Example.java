package application;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Example extends Contents implements ActionListener {

	// these panels will act as "cards" in CardLayout
	private JPanel p1, p2, p3;
	private JFrame exampleFrame = new JFrame();
	// this panel holds the "cards" p1, p2 and p3
	private JPanel cardPanel;

	// this panel contains navigation buttons
	private JPanel btnPanel;

	// buttons to navigate through card panels
	private JButton next, previous, menu;

	public Example() {

		exampleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		exampleFrame.setTitle("Moon and Constellation");

		// create a card panel that uses CardLayout
		cardPanel = new JPanel();
		cardPanel.setLayout(new CardLayout());

		// create and add cards. When adding, we must assign a unique
		// string "card ID".
		p1 = new Panel1();
		p2 = new Panel2();
		p3 = new Panel3();

		cardPanel.add(p1);
		cardPanel.add(p2);
		cardPanel.add(p3);

		// create navigation panel with buttons

		previous = new JButton("Previous");
		previous.addActionListener(this);

		next = new JButton("Next");
		next.addActionListener(this);
		
		menu = new JButton("Menu");
		menu.addActionListener(this);

		btnPanel = new JPanel();
		btnPanel.add(previous);
		btnPanel.add(next);
		btnPanel.add(menu);

		// add cardpanel and button panel to frame
		exampleFrame.add(cardPanel, BorderLayout.CENTER);
		exampleFrame.add(btnPanel, BorderLayout.SOUTH);

		// show the frame
		exampleFrame.setSize(676, 453);
		exampleFrame.setVisible(true);

	}

	class Panel1 extends JPanel {

		private JLabel lbl;
		private JPanel panel;

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Image image = new ImageIcon("example/edit_harv.jpg").getImage();
			g.drawImage(image, 0, 0, this);

			g.setColor(Color.WHITE);
			g.setFont(new Font("Arial", Font.BOLD, 17));
			g.drawString("Constellation is used for predicting when to harvest in Agriculture", 15, 350);

		}

		public Panel1() {

			lbl = new JLabel();
			this.add(lbl);

		}

	}

	class Panel2 extends JPanel {

		private JLabel lbl;
		private JPanel panel;

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Image image = new ImageIcon("example/edit_cal.jpg").getImage();
			g.drawImage(image, 0, 0, this);

			g.setColor(Color.WHITE);
			g.setFont(new Font("Arial", Font.BOLD, 17));
			g.drawString("Constellation is used for predicting date,time and weather", 15, 350);

		}

		public Panel2() {

			lbl = new JLabel();
			this.add(lbl);
		}

	}

	class Panel3 extends JPanel {

		private JLabel lbl;
		private JPanel panel;

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Image image = new ImageIcon("example/edit_navi.jpg").getImage();
			g.drawImage(image, 0, 0, this);

			g.setColor(Color.BLACK);
			g.setFont(new Font("Arial", Font.BOLD, 17));
			g.drawString("Constellation is used for finding direction", 20, 350);

		}

		public Panel3() {
			lbl = new JLabel();
			this.add(lbl);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// activate first, previous, next or last card (panel) depending
		// on which button was clicked

		CardLayout cl = (CardLayout) (cardPanel.getLayout());

		if (e.getSource().equals(previous)) {

			cl.previous(cardPanel);

		} else if (e.getSource().equals(next)) {

			cl.next(cardPanel);

		} else if (e.getSource().equals(menu)) {
			MainMenu mainmenu = new MainMenu();
			mainmenu.mainMenuStart();
			exampleFrame.dispose();
		}
	}
	

	@Override
	public void run() {
		try {
			exampleFrame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}