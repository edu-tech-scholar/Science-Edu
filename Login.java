package application;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.Font;

public class Login {
	//public static Login login = new Login();
	private JPanel contentPane;
	private JTextField textField = new JTextField();
	private JPasswordField textField_1 = new JPasswordField();
	
	private static JFrame mainFrame = new JFrame();
	
	private boolean flag = false;
	private boolean flag2 = false;
	
	private JFrame myFrame = new JFrame();
	
	/**
	 * Launch the application.
	 */
	
	public void checkUser(){          // this is the method to check user.
									  // if you don't have an ID then , you have to join to enjoy this app.
		
		
		String Id = textField.getText();        // get ID from the textField , then set ID on this class.
		String Password = textField_1.getText();// get Password from the textField, then set Password on this class.
		File f = new File("user.txt"); 
		
		if(f.exists() == true){
			
			try {
				FileReader reader = new FileReader("user.txt");
				
				int i;
				String line;
				StringBuilder sb = new StringBuilder();
				
				while((i = reader.read()) != -1){  // save the information of FILE " User.txt"
					
					sb.append((char)i);     
				}
				
				line = sb.toString();  // input the information of FILE " User.txt " to String variable.
				
				
				String[] check_line = line.split("\n");  // spit users into array one by one.
				String[] check = null;					 //In Check_line[0], There is one user's information.
				for(int j = 0 ; j < check_line.length ; j++){
					
					check = check_line[j].split(";");
					if(check[0].equals(Id))   // if there is User's ID, then flag becomes true.
						flag = true;			   // if there is no User'sID, then, it will check next User's ID
					if(check[1].equals(Password))
						flag2 = true;		//if there is an ID but you input wrong password, you can't login 
					
				}
				
				reader.close();
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		      
	}	
//	public static void main(String[] args) {
//		
//		Login login = new Login();
//		login.run();
//	}

	/**
	 * Create the frame.
	 */
	public Login() {	
		mainFrame.setTitle("Moon and Constellation");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setBounds(100, 100, 676, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainFrame.setContentPane(contentPane);
		
		JPanel panel = new JPanel(){
			public void paintComponent(Graphics g){		 
				super.paintComponent(g);
		        Image img =  new ImageIcon("background.jpg").getImage();
		        g.drawImage(img, 0, 0, this); 
				
			}
		};
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 673, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 432, GroupLayout.PREFERRED_SIZE))
		);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				checkUser();
				
				if(flag == true ){ 		// If you have ID, it checks that you input correct password.
										
					if(flag2 == true){
						
					MainMenu main = new MainMenu();  // if you input right id and password 
					main.mainMenuStart();			 // let's Start study
					mainFrame.dispose();
					}
					
					else           //if you input wrong password, then you can see this message.
						JOptionPane.showMessageDialog(myFrame, "*** Wrong Password ***");
				}
			
					
				
				else{
					int i = JOptionPane.showConfirmDialog(myFrame, " You have to join", "*** There is no ID ***",
							JOptionPane.YES_NO_OPTION);
					if(i == JOptionPane.OK_OPTION){			//if you don't have ID, you must make ID
						
						Join join = new Join();
					
						try {
							
							join.run();
							mainFrame.dispose();    
							
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}				
				}

			}
		});
		
		JButton btnCancel = new JButton("Quit");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int i = JOptionPane.showConfirmDialog(myFrame, "Are you sure to close the app ?", "Exit",  JOptionPane.YES_NO_OPTION);
				
				if( i == JOptionPane.OK_OPTION ) System.exit(0); 
				
			}
			
		});
		
		JLabel lblId = new JLabel("ID");
		lblId.setForeground(Color.white);
		lblId.setFont(new Font("Arial", Font.PLAIN, 13));
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.white);
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 13));
		
	
		textField.setColumns(10);
	
		textField_1.setColumns(10);
		
		JLabel lblMoonAndConstellation = new JLabel("Moon and Constellation");
		lblMoonAndConstellation.setForeground(Color.white);
		lblMoonAndConstellation.setFont(new Font("Arial", Font.PLAIN, 17));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(143)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(120)
							.addComponent(btnNewButton)
							.addGap(18)
							.addComponent(btnCancel))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblPassword)
								.addComponent(lblId))
							.addGap(34)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
								.addComponent(textField))))
					.addContainerGap(199, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(375, Short.MAX_VALUE)
					.addComponent(lblMoonAndConstellation, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
					.addGap(229))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(65)
					.addComponent(lblMoonAndConstellation)
					.addGap(58)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnCancel))
					.addGap(152))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
	public void run() {
		try {
			
			mainFrame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
}
}