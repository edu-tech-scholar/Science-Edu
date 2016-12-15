package application;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import application.MainMenu;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Join {

	private JPanel contentPane;
	private JTextField textField = new JTextField();
	private JPasswordField textField_1 = new JPasswordField();
	private JTextField textField_2 = new JTextField();
	private JTextField textField_3 = new JTextField();
	private JLabel lblId = new JLabel("ID");
	
	private JLabel lblPassword = new JLabel("Password");
	
	private JLabel lblName = new JLabel("Name");
	
	private JLabel lblAge = new JLabel("Age");
	
	private JFrame mainFrame = new JFrame();

	private JFrame myFrame = new JFrame();

	
	/**
	 * Launch the application.
	 */
	public void run() {
		try {
		
			mainFrame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the frame.
	 */
	public Join() {
		mainFrame.setTitle("Moon and Constellation");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setBounds(100, 100, 676, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainFrame.setContentPane(contentPane);
		
		JPanel panel = new JPanel(){
			public void paintComponent(Graphics g){		 //set background of Join page.
				super.paintComponent(g);
		        Image img =  new ImageIcon("background.jpg").getImage();
		        g.drawImage(img, 0, 0, this); 
				
			}
		};
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
		);
		
	

		
		textField.setColumns(10);	
		textField_1.setColumns(10);
		textField_2.setColumns(10);
		textField_3.setColumns(10);
	
		JButton btnJoin = new JButton("Join");
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
			
				try {
					FileWriter writer = new FileWriter("user.txt",true);    

					String Id = textField.getText();               // get id from textfield and set in Join class.
					String Password = textField_1.getText();			 // get password from textfield and set in Join class.
					String name = textField_2.getText();				 // get name from textfield and set in Join class.
					int age = Integer.parseInt(textField_3.getText());				 // get age from textfield and set in Join class.
					
					char a = ';';         //  ' ; ' is token to split id,password,name,age
					writer.write(Id+a);    
					writer.write(Password+a);
					writer.write(name+a);
					writer.write(age+a+"\n");       // \n is need to split the users
			        
			        writer.close();
			        
			        MainMenu main = new MainMenu();
			        main.mainMenuStart();            // if join is clear, then start the MainMenu class
			        mainFrame.dispose();
			      					
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NumberFormatException e3){
					JOptionPane.showMessageDialog(myFrame, "*** Age must be Integer ***");
				}
		        
				


				
			}

		});
		
		JButton btnCancel = new JButton("Quit");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int i = JOptionPane.showConfirmDialog(myFrame, "Are you sure to close the app ?", "Exit",  JOptionPane.YES_NO_OPTION);
			
				if( i == JOptionPane.OK_OPTION ) System.exit(0);  // if you want to close the app, then click the Cancel button

			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(167)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblAge)
						.addComponent(lblName)
						.addComponent(lblPassword)
						.addComponent(lblId))
					.addGap(32)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(textField, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
						.addComponent(textField_3)
						.addComponent(textField_2)
						.addComponent(textField_1)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(btnJoin, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnCancel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addContainerGap(203, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(88)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAge)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnJoin)
						.addComponent(btnCancel))
					.addContainerGap(110, Short.MAX_VALUE))
		);
		lblName.setForeground(Color.white);
		lblName.setFont(new Font("Arial", Font.PLAIN, 13));
		lblAge.setForeground(Color.white);
		lblAge.setFont(new Font("Arial", Font.PLAIN, 13));
		lblPassword.setForeground(Color.white);
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 13));
		lblId.setForeground(Color.white);
		lblId.setFont(new Font("Arial", Font.PLAIN, 13));
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
	

}