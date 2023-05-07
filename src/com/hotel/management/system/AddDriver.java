package com.hotel.management.system;


import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class AddDriver extends JFrame implements ActionListener {
	
	JButton add , cancel;
	JTextField tfname,tfcompany ,tfage,tfmodel,tflocation;
	JComboBox availablecombo,gendercombo;
	
	
	
	AddDriver(){
		
		getContentPane().setBackground(Color.yellow);
		setLayout(null);
		
		//Label 0  heading add drivers
		JLabel heading = new JLabel("Add Drivers");
		heading.setFont(new Font("Tahoma",Font.BOLD,18));
		heading.setBounds(150,10,200,20);
		add(heading);
		
		//------------------------------------------------------
		
		//Label 1 label name
		JLabel lblname = new JLabel("Name");
		lblname.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblname.setBounds(60,70,120,30);
		add(lblname);
		
		//Text 1 for name
		tfname = new JTextField();
		tfname.setBounds(200,70,150,30);
		add(tfname);
		
		//-------------------------------------------------------
		
		//Label 2 for age
		JLabel lblage = new JLabel("Age");
		lblage.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblage.setBounds(60,110,120,30);
		add(lblage);
		
		//Text for age
		tfage = new JTextField();
		tfage.setBounds(200,110,150,30);
		add(tfage);
		
		//--------------------------------------------------------
		
		//Label 3 for Gender
		JLabel lblgender = new JLabel("Gender");
		lblgender.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblgender.setBounds(60,150,120,30);
		add(lblgender);
		
		//dropdown
		String genderOptions[] = {"Male","Female"};
		gendercombo = new JComboBox(genderOptions);
		gendercombo.setBounds(200,150,150,30);
		gendercombo.setBackground(Color.white);
		add(gendercombo);
		
		//---------------------------------------------------------
		
		//Label 4 for car company
		JLabel lblcompany = new JLabel("Car Company");
		lblcompany.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblcompany.setBounds(60,190,120,30);
		add(lblcompany);
		
		//text for car company
		tfcompany = new JTextField();
		tfcompany.setBounds(200,190,150,30);
		add(tfcompany);
		
		//----------------------------------------------------------
		
//		Label 5 for bed status
		JLabel lblmodel = new JLabel("Car Model");
		lblmodel.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblmodel.setBounds(60,230,120,30);
		add(lblmodel);
		
		//text for car model
		tfmodel = new JTextField();
		tfmodel.setBounds(200,230,150,30);
		add(tfmodel);
		
		//----------------------------------------------------------
		
		//Label 6 for availability
		JLabel lblavailable = new JLabel("Available");
		lblavailable.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblavailable.setBounds(60,270,120,30);
		add(lblavailable);
		
		//dropdown
		String driverOptions[] = {"Available","Busy"};
		availablecombo = new JComboBox(driverOptions);
		availablecombo.setBounds(200,270,150,30);
		availablecombo.setBackground(Color.white);
		add(availablecombo);
		
		//-----------------------------------------------------------
		
		//Label 7 for location
		JLabel lbllocation = new JLabel("Location");
		lbllocation.setFont(new Font("Tahoma",Font.PLAIN,16));
		lbllocation.setBounds(60,310,120,30);
		add(lbllocation);
		
		//text for car model
		tflocation = new JTextField();
		tflocation.setBounds(200,310,150,30);
		add(tflocation);
		
		
		
		//-----------------------------------------------------------
		
		//Button 1 for add rooms
		
		add = new JButton("Add Driver");
		add.setForeground(Color.white);
		add.setBackground(Color.black);
		add.setBounds(60,370,130,30);
		add.addActionListener(this);
		add(add);
		
		//Button 2 for cancel
		
		cancel = new JButton("Cancel");
		cancel.setForeground(Color.white);
		cancel.setBackground(Color.black);
		cancel.setBounds(220,370,130,30);
		cancel.addActionListener(this);
		add(cancel);
		
		//------------------------------------------------------------
		
		//image
		
	
//		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
//		Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
//		ImageIcon i3 = new ImageIcon(i2);
//		JLabel image = new JLabel(i3);
//		image.setBounds(400,30,500,300);
//		add(image);
		
		
		setBounds(300,200,980,470);
		setVisible(true);
		
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()== add) {
			
			String name = tfname.getText();
			String age = tfage.getText();
			String gender = (String)gendercombo.getSelectedItem();
			String company = tfcompany.getText();
			String brand = tfmodel.getText();
			String available = (String)availablecombo.getSelectedItem();
			String location = tflocation.getText();
			
			try {
				Conn conn = new Conn();
				String str  = "insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+brand+"','"+available+"','"+location+"')";

				conn.s.executeUpdate(str);		
				
				JOptionPane.showMessageDialog(null, "New Driver Added Successfully");
				
				setVisible(false);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}else{
			setVisible(false);
		
		}
		
	}

	public static void main(String[] args) {
		new AddDriver();
		

	}

}


