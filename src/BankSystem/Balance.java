package BankSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Balance extends JFrame implements ActionListener {
	 int blc;
	 JButton Menue;
	 String pinb;
	 
	public Balance(int blc) {
		this.blc=blc;
		String a=""+blc;
		
		
		ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
		Image i1=i.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i2=new ImageIcon(i1);
		JLabel screen =new JLabel(i2);
		screen.setBounds(0,0,900,900);
		add(screen);
		JLabel head=new JLabel("Your availbale Balance");
		head.setBounds(230,300,400,30);
		head.setFont(new Font("Raleway",Font.BOLD,16));
		head.setForeground(Color.white);
		screen.add(head);
		JLabel balance=new JLabel("Rs.");
		balance.setBounds(230,360,100,30);
		balance.setFont(new Font("Raleway",Font.BOLD,16));
		balance.setForeground(Color.white);
		screen.add(balance);
		JLabel amount=new JLabel(a);
		amount.setBounds(350,360,100,30);
		amount.setFont(new Font("Raleway",Font.BOLD,16));
		amount.setForeground(Color.white);
		Menue=new JButton("Main Menue");
		 Menue.setBounds(330,500,150,30);
		 Menue.setFont(new Font("Raleway",Font.BOLD,17));
		Menue.addActionListener(this);
		screen.add(Menue);
		screen.add(amount);
		setSize(900,900);
		setLayout(null);
		setLocation(230,0);
		setUndecorated(true);
		setVisible(true);
	}
	public Balance(String pin) {
		this.pinb=pin;
			
	}
	public void actionPerformed(ActionEvent ae) {
		String pin=pinb;
		if(ae.getSource()==Menue) {
			//System.out.println(pin)

			setVisible(false);
			//new Transiction(pin,card).setVisible(true);
		}
	}
public static void main(String args[])
{
	
	//new Balance("");
	new Balance(0);
	
}
}
