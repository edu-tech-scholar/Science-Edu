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

public class MoonExample extends Contents implements ActionListener {

   // these panels will act as "cards" in CardLayout
   private JPanel p1, p2;
   private JFrame exampleFrame = new JFrame();
   // this panel holds the "cards" p1, p2 and p3
   private JPanel cardPanel;

   // this panel contains navigation buttons
   private JPanel btnPanel;

   // buttons to navigate through card panels
   private JButton next, previous, menu;

   
   public MoonExample() {

      exampleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      exampleFrame.setTitle("Moon and Constellation");

      // create a card panel that uses CardLayout
      cardPanel = new JPanel();
      cardPanel.setLayout(new CardLayout());

      // create and add cards. When adding, we must assign a unique
      // string "card ID".
      p1 = new Panel1();
      p2 = new Panel2();
    

      cardPanel.add(p1);
      cardPanel.add(p2);
    

      // create navigation panel with buttons
      // add button ActionListener      
      previous = new JButton("Previous");
      previous.addActionListener(this);

      next = new JButton("Next");
      next.addActionListener(this);
      
      menu = new JButton("Menu");
      menu.addActionListener(this);

      //In panel, create previous, next, menu button
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

   // In panel, create label and put images and text
   class Panel1 extends JPanel {

      private JLabel lbl;
      private JPanel panel;

      @Override
      public void paintComponent(Graphics g) {
         super.paintComponent(g);
         Image image = new ImageIcon("example/praymoon.jpg").getImage();
         g.drawImage(image, 0, 0, this);

         g.setColor(Color.WHITE);
         g.setFont(new Font("Arial", Font.BOLD, 17));
         g.drawString("People used to make a wish while seeing the moon ", 15, 350);

      }

      public Panel1() {

    	  //create label and add images
         lbl = new JLabel();
         this.add(lbl);

      }

   }
// In panel, create label and put images and text
   class Panel2 extends JPanel {

      private JLabel lbl;
      private JPanel panel;

      @Override
      public void paintComponent(Graphics g) {
         super.paintComponent(g);
         Image image = new ImageIcon("example/kang.jpg").getImage();
         g.drawImage(image, 0, 0, this);

         g.setColor(Color.WHITE);
         g.setFont(new Font("Arial", Font.BOLD, 17));
         g.drawString("During one of the biggest holidays in Korea, people gather and dance under the moon", 15, 350);

      }

    //create label and add images
      public Panel2() {

         lbl = new JLabel();
         this.add(lbl);
      }

   }


   @Override
   public void actionPerformed(ActionEvent e) {

      // activate first, previous, menu card (panel) depending
      // on which button was clicked

      CardLayout cl = (CardLayout) (cardPanel.getLayout());

      //previous button goes to previous step
      if (e.getSource().equals(previous)) {

         cl.previous(cardPanel);

         //next button goes to next step
      } else if (e.getSource().equals(next)) {

         cl.next(cardPanel);

         //menu button goes to main menu
         //create object and execute it to access main menu class
      }
      else if (e.getSource().equals(menu)) {
         MainMenu mainmenu = new MainMenu();
         mainmenu.mainMenuStart();
         exampleFrame.dispose();
      }
   }


   // this run methods makes this class execute in main method which is in mainmenu
   @Override
   public void run() {
      try {
         exampleFrame.setVisible(true);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

}