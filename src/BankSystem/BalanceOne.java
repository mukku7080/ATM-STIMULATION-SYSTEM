package BankSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BalanceOne extends JFrame implements ActionListener{
	int blc;
	 JButton Menue;
	 String pinb,card;
	public BalanceOne(String pin,String cardb) {
		this.pinb=pin;
		this.card=cardb;
		
		
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
		Conn c=new Conn();
		try {
			
				int balance=0;
				String Query1=String.format("select * from bank where (Pin='%s'and card_detail='%s')",pinb,card);
			//	System.out.println(pinb);
				//System.out.println(card);
				
				ResultSet rs=c.st.executeQuery(Query1);
				while(rs.next())
				{
					if(rs.getString("TransactionType").equals("Deposite"))
					{
					balance+=Integer.parseInt(rs.getString("Amount"));
					}
					else {
						balance-=Integer.parseInt(rs.getString("Amount"));
					}
					this.blc=balance;
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
		String a=""+blc;
		JLabel balance=new JLabel("Rs."+a);
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
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==Menue) {
			setVisible(false);
			new Transiction(pinb,card).setVisible(true);
		}
		
	}
	public static void main(String args[]) {
		
		
	
	}

}
