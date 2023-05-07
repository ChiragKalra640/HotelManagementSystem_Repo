package com.hotel.management.system;


import javax.swing.*;


import java.awt.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener {
	
	JButton add , cancel;
	JTextField tfroom,tfprice;
	JComboBox availablecombo,cleancombo,typecombo;
	
	
	
	AddRooms(){
		
		getContentPane().setBackground(Color.yellow);
		setLayout(null);
		
		//Label 0  heading add rooms
		JLabel heading = new JLabel("Add Rooms");
		heading.setFont(new Font("Tahoma",Font.BOLD,18));
		heading.setBounds(150,20,200,20);
		add(heading);
		
		//------------------------------------------------------
		
		//Label 1 label room number
		JLabel lblroomno = new JLabel("Room Number");
		lblroomno.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblroomno.setBounds(60,80,120,30);
		add(lblroomno);
		
		//text 1 for room number
		tfroom = new JTextField();
		tfroom.setBounds(200,80,150,30);
		add(tfroom);
		//-------------------------------------------------------
		
		//Label 2 for room available
		JLabel lblavailable = new JLabel("Available");
		lblavailable.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblavailable.setBounds(60,130,120,30);
		add(lblavailable);
		
		//dropdown
		String availableOptions[] = {"Available","Occupied"};
		availablecombo = new JComboBox(availableOptions);
		availablecombo.setBounds(200,130,150,30);
		availablecombo.setBackground(Color.white);
		add(availablecombo);
		
		//--------------------------------------------------------
		
		//Label 3 for cleaning status
		JLabel lblclean = new JLabel("Cleaning Status");
		lblclean.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblclean.setBounds(60,180,120,30);
		add(lblclean);
		
		//dropdown
		String cleanOptions[] = {"Cleaned","Dirty"};
		cleancombo = new JComboBox(cleanOptions);
		cleancombo.setBounds(200,180,150,30);
		cleancombo.setBackground(Color.white);
		add(cleancombo);
		
		//---------------------------------------------------------
		
		//Label 4 for Room price
		JLabel lblprice = new JLabel("Price");
		lblprice.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblprice.setBounds(60,230,120,30);
		add(lblprice);
		
		//text 2 for room price
		tfprice = new JTextField();
		tfprice.setBounds(200,230,150,30);
		add(tfprice);
		
		//----------------------------------------------------------
		
//		Label 5 for bed status
		JLabel lbltype = new JLabel("Bed Type");
		lbltype.setFont(new Font("Tahoma",Font.PLAIN,16));
		lbltype.setBounds(60,280,120,30);
		add(lbltype);
		
		//dropdown
		String typeOptions[] = {"Single bed","Double bed"};
		typecombo = new JComboBox(typeOptions);
		typecombo.setBounds(200,280,150,30);
		typecombo.setBackground(Color.white);
		add(typecombo);
		
		//-----------------------------------------------------------
		
		//Button 1 for add rooms
		
		add = new JButton("Add Room");
		add.setForeground(Color.white);
		add.setBackground(Color.black);
		add.setBounds(60,350,130,30);
		add.addActionListener(this);
		add(add);
		
		//Button 2 for cancel
		
		cancel = new JButton("Cancel");
		cancel.setForeground(Color.white);
		cancel.setBackground(Color.black);
		cancel.setBounds(220,350,130,30);
		cancel.addActionListener(this);
		add(cancel);
		
		//------------------------------------------------------------
		
		//image
		
	
//		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
//		JLabel image = new JLabel(i1);
//		image.setBounds(400,30,500,300);
//		add(image);
		
		
		setBounds(330,200,940,470);
		setVisible(true);
		
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()== add) {
			
			String roomnumber = tfroom.getText();
			String availability = (String)availablecombo.getSelectedItem();
			String status = (String)cleancombo.getSelectedItem();
			String price = tfprice.getText();
			String type = (String)typecombo.getSelectedItem();
			
			try {
				Conn conn = new Conn();
				String str  = "insert into room values('"+roomnumber+"','"+availability+"','"+status+"','"+price+"','"+type+"')";

				conn.s.executeUpdate(str);		
				
				JOptionPane.showMessageDialog(null, "New Room Added Successfully");
				
				setVisible(false);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}else{
			setVisible(false);
		
		}
		
	}

	public static void main(String[] args) {
		new AddRooms();
		

	}

}

