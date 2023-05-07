package com.hotel.management.system;



import javax.swing.*;


import java.awt.*;
import java.awt.event.*;

 public class Dashboard extends JFrame implements ActionListener{
	
	Dashboard(){
		setBounds(0,0,1550,1000);
		
		setLayout(null);
		
//		image ke liye
		
//		ImageIcon i1 =  new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
//		Image i2 = i1.getImage().getScaledInstance(1550,1000,Image.SCALE_DEFAULT);
//		ImageIcon i3 = new ImageIcon(i2);
//		JLabel image = new JLabel(i3);
//		image.setBounds(0,0,1550,1000);
//		add(image);
		
		
		//label chirag kalra group welcomes you
		
		JLabel text = new JLabel("THE CHIRAG KALRA GROUP WELCOMES YOU");
		text.setBounds(250,100,1500,50);
		text.setFont(new Font("Tahoma" ,Font.BOLD,45));
		text.setForeground(Color.blue);
		add(text);
		
		//image.add(text);  <-- ye aise tab likhunga jab image add ho jaygi
		
		//we are using menu bar class taki hum menu dikha paye, white color ki patti bn gayi hai
		//MENU BAR
		JMenuBar mb = new JMenuBar();
		mb.setBounds(0,0,1550,30);
		add(mb);
		
		//menu bar ke uppar hum menu ko add kr skte hai using JMenu class
		
		//1st MENU
		JMenu hotel = new JMenu("HOTEL MANAGEMENT");
		hotel.setForeground(Color.red);
		mb.add(hotel);
		
		//1.1) DROPDOWN ke liye 
		JMenuItem reception = new JMenuItem("RECEPTION");
		reception.addActionListener(this);  //action
		hotel.add(reception);
				
		
		
		//2nd MENU
		JMenu admin = new JMenu("ADMIN");
		admin.setForeground(Color.blue);
		mb.add(admin);
		
		//2.1)DROPDOWN ke liye 
	    JMenuItem addEmployee = new JMenuItem("ADD EMPLOYEE");
	    addEmployee.addActionListener(this);  //action 1
	    admin.add(addEmployee);
	    
	    
	    //2.2)
	    JMenuItem addRooms = new JMenuItem("ADD ROOMS");
	    addRooms.addActionListener(this);     //action 2
	    admin.add(addRooms);
	    
	    //2.3
	    JMenuItem addDrivers = new JMenuItem("ADD DRIVERS");
	    addDrivers.addActionListener(this);  //action 3
	    admin.add(addDrivers);
	    
	    
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("ADD EMPLOYEE")) {
			new AddEmployee();
		} else if (ae.getActionCommand().equals("ADD ROOMS")) {
			new AddRooms();	
		} else if (ae.getActionCommand().equals("ADD DRIVERS")) {
			new AddDriver();
		} else if (ae.getActionCommand().equals("RECEPTION")) {
			new Reception();
			
		}
	}

	public static void main(String[] args) {
		new Dashboard();

	}

}


