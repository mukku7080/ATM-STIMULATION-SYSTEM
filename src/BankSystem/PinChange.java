package BankSystem;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

import com.mysql.cj.protocol.Resultset;
public class PinChange extends JFrame implements ActionListener {
	JTextField rpin,Newpin;
	JButton Submit,Back;
	String pin,card;
public	PinChange(String pin,String cardp)
	{
	this.card=cardp;
	this.pin=pin;
	ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
	Image i1=i.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
	ImageIcon i2=new ImageIcon(i1);
	JLabel screen =new JLabel(i2);
	screen.setBounds(0,0,900,900);
	add(screen);
	JLabel head=new JLabel("Change Your PIN");
	head.setBounds(260,300,400,30);
	head.setFont(new Font("Raleway",Font.BOLD,16));
	head.setForeground(Color.white);
	screen.add(head);
	JLabel New=new JLabel("New PIN:");
	New.setBounds(170,360,100,30);
	New.setFont(new Font("Raleway",Font.BOLD,16));
	New.setForeground(Color.white);
	screen.add(New);
	rpin=new JTextField();
	rpin.setBounds(300,360,200,35);
	rpin.setBackground(Color.black);
	rpin.setForeground(Color.white);
	rpin.setFont(new Font("System",Font.BOLD,16));
	screen.add(rpin);
	JLabel rNew=new JLabel("RE-Enter_PIN:");
	rNew.setBounds(170,400,150,30);
	rNew.setFont(new Font("Raleway",Font.BOLD,16));
	rNew.setForeground(Color.white);
	screen.add(rNew);
	Newpin=new JTextField();
	Newpin.setBounds(300,400,200,35);
	Newpin.setBackground(Color.black);
	Newpin.setForeground(Color.white);
	Newpin.setFont(new Font("System",Font.BOLD,16));
	screen.add(Newpin);
	Submit=new JButton("Submit");
	Submit.setBounds(305,480,150,30);
	Submit.setFont(new Font("Raleway",Font.BOLD,17));
	Submit.addActionListener(this);
	screen.add(Submit);
	Back=new JButton("Back");
	Back.setBounds(305,520,150,30);
	Back.setFont(new Font("Raleway",Font.BOLD,17));
	Back.addActionListener(this);
	screen.add(Back);
	setSize(900,900);
	setLocation(230,0);
	setLayout(null);
	setUndecorated(true);
	setVisible(true);
	
	}
public void actionPerformed(ActionEvent ae)
{ 
	if(ae.getSource()==Submit)
	{
		String card55=card;
		String oldpin=pin;
		String repin=rpin.getText();
		String newpin=Newpin.getText();
		if(newpin.equals("")) {
			JOptionPane.showMessageDialog(null, "plz enter pin");
		}
		else
		{
			if(repin.equals("")) {
				JOptionPane.showMessageDialog(null, "plz re-enter pin");
			}
			else {
				Conn c=new Conn();
				try {
				
					String query=String.format("update bank set Pin='%s' where Pin='%s'",newpin,oldpin);
					String query1=String.format("update Card_detail set PIN_Number='%s' where PIN_Number='%s'",newpin,oldpin);
					c.st.executeUpdate(query);
					c.st.executeUpdate(query1);
					JOptionPane.showMessageDialog(null, "Pin Successfully Changed:");
					setVisible(false);
					new Transiction(newpin,card55).setVisible(true);	
					 
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				
			}
		}
		
}
		
	if(ae.getSource()==Back) {
		String pinp=pin;
		setVisible(false);
		new Transiction(pinp,card).setVisible(true);
	}
}
public static void main(String args[])
{
	new PinChange("","");
}
}
