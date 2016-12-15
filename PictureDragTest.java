package simulation;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import application.MainMenu;
import application.MoonAndConstellation;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PictureDragTest extends MoonAndConstellation implements MouseListener, MouseMotionListener{

	private JPanel contentPane;
	private static Image[] img_moon = new Image[8];
	private static Point[] point;
	private static boolean[] isDrag;
	private static int[] X, Y ;
	private static int[] origin_X, origin_Y;
	private final int width  = 54; //width of picture of the moon
	private final int height= 54;//height of picture of the moon
	
	private static JFrame picture_frame;
	
	
	/**
	 * Create the frame.
	 */
	public PictureDragTest() {
		picture_frame = new JFrame();
		picture_frame.setTitle("Moon and Constellation");
		
		isDrag = new boolean[8];
		X = new int[8]; // variable for the pictures location  
		Y = new int[8];	// variable for the pictures location
		origin_X = new int[8]; //this is for moving back to their own place
		origin_Y = new int[8]; //this is for moving back to their own place


		point = new Point[8]; //this is for right answer zone for each picture
	
		picture_frame.addMouseListener(this);
		picture_frame.addMouseMotionListener(this);
		picture_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		picture_frame.setBounds(100, 100, 676, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		picture_frame.setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		// 8 pictures of moon phases
		// locate these pictures 2X4 matrix 
		// substitute the  value of X[i] for origin_X[i] then
		// To move the pictures back to the original position
		// take i variable from JSlider and convert it to what I want
		for(int i = 0; i<8 ; i++){
			X[i] = (int)((i+4)/4)*90+610;
			Y[i] = (int)((i+1)%4)*90+120;
			origin_X[i] = X[i];
			origin_Y[i] = Y[i];
		}
		// point[i] is indicate the right position of the moon's picture 
		for(int i = 0; i<8 ; i++){
			point[i] = new Point();
		}
		
		//answer zone
		point[4].setLocation(344, 52); //third quarter
		point[7].setLocation(491, 102); // waning gibbous
		point[6].setLocation(547, 233); // full moon
		point[5].setLocation(496, 368);  // waxing gibbous
		point[0].setLocation(344, 428); //first
		point[3].setLocation(195, 376); //waxing crescent
		point[2].setLocation(158, 229); // new
		point[1].setLocation(192, 106); // waning crescent
		
		JPanel panel = new JPanel(){
				public void paintComponent(Graphics g){
								
				Image background = new ImageIcon("moon_test/moonphases.jpg").getImage();
				g.drawImage(background, 0, 0, this);

				for(int i=0;i<8;i++){  
					img_moon[i] = new ImageIcon("moon_test/moontest"+i+".jpg").getImage();
					g.drawImage(img_moon[i], X[i], Y[i], this);
				}

			}
		};
		contentPane.add(panel, "name_372323250270889");
		
		JButton pic_but = new JButton("MENU");
		pic_but.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu main = new MainMenu(); //
				main.mainMenuStart();
				picture_frame.dispose();
				
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(829, Short.MAX_VALUE)
					.addComponent(pic_but)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(505, Short.MAX_VALUE)
					.addComponent(pic_but)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		picture_frame.setSize(920, 569);
	}

	@Override
	public void mouseDragged(MouseEvent e) {

		//change picture's location by taking mouse's coordiantes.
		for(int i =0 ; i<8 ; i++){
			if(isDrag[i] == true){
				X[i] = e.getX()-17-27;
				Y[i] = e.getY()-43-27;
			}
		}
		picture_frame.repaint();
	}
	

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {

		// if you press the mouse button inside the picture
		// isDrag turn to true, then you can move the picture of the moon
		for(int i = 0; i<8 ; i++){ 
			if(e.getX()-16 <=  X[i] + width && e.getX()-16 >=  X[i] && e.getY()-43 <= Y[i] + height  && e.getY()-43 >= Y[i]){
				isDrag[i] = true;
			}
		}

	
	}
	
	@Override //if you release the mouse button on the answer zone, the picture lie on the answer place
	public void mouseReleased(MouseEvent e) {
		for(int i = 0; i<8 ;i++){
			if(isDrag[i] == true){
				if(e.getX()<point[i].getX() + 60 && e.getX()>point[i].getX() && e.getY()<point[i].getY() + 60 && e.getY()>point[i].getY()){
					X[i] = (int) point[i].getX();
					Y[i] = (int) point[i].getY() - 25;
				}
				else{ // if it is not on the right area, It moves back to their own area.
					X[i] = origin_X[i];
					Y[i] = origin_Y[i];	
//					wrong_count++;
				}
				}
			isDrag[i] = false; // set isDrag to false 
		}
		picture_frame.repaint();
	}

	@Override
	public void run() {

		picture_frame.setVisible(true);
		
	}
	
}