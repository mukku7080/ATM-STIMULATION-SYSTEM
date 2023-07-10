package BankSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;

public class AccountD extends JFrame implements ActionListener {
	JRadioButton r1,r2,r3,r4;
	JCheckBox c1,c2,c3,c4,c5,c6,c7;
	JButton Submit,Cancel;
	String formno;
	public AccountD(String formno)
	{
		this.formno=formno;
	JLabel head=new JLabel("Page 3:Account Detail");
 head.setBounds(175,20,300,30);
 head.setFont(new Font("Raleway",Font.BOLD,22));
 add(head);
 JLabel type=new JLabel("Account Type");
 type.setBounds(50,100,200,30);
 type.setFont(new Font("Raleway",Font.BOLD,20));
 add(type);
 r1=new JRadioButton("Saving Account");
 r1.setBounds(50,140,200,30);
 r1.setBackground(Color.white);
 r1.setFont(new Font("Raleway",Font.BOLD,15));
 add(r1);
 r2=new JRadioButton("Fixed Deposite Account");
 r2.setBounds(300,140,200,30);
 r2.setBackground(Color.white);
 r2.setFont(new Font("Raleway",Font.BOLD,15));
 add(r2);
 r3=new JRadioButton("Current Account");
 r3.setBounds(50,170,200,30);
 r3.setBackground(Color.white);
 r3.setFont(new Font("Raleway",Font.BOLD,15));
 add(r3);
 r4=new JRadioButton("Reccuring Deposite Account");
 r4.setBounds(300,170,300,30);
 r4.setBackground(Color.white);
 r4.setFont(new Font("Raleway",Font.BOLD,15));
 add(r4);
 ButtonGroup group=new ButtonGroup();
 group.add(r1);
 group.add(r2);
 group.add(r3);
 group.add(r4);
 JLabel card=new JLabel("Card Number");
 card.setBounds(50,230,200,30);
 card.setFont(new Font("Raleway",Font.BOLD,20));
 add(card);
 JLabel cardnum=new JLabel("-XXXX-XXXX-XXXX-8741");
 cardnum.setBounds(300,230,400,30);
 cardnum.setFont(new Font("Raleway",Font.BOLD,20));
 add(cardnum);
 JLabel cardd=new JLabel("Your 16 digit card number");
 cardd.setBounds(50,250,250,30);
 cardd.setFont(new Font("Raleway",Font.BOLD,12));
 add(cardd);
 JLabel pinl=new JLabel("PIN");
 pinl.setBounds(50,290,100,30);
 pinl.setFont(new Font("Raleway",Font.BOLD,20));
 add(pinl);
 JLabel pinnum=new JLabel("-XXXX");
 pinnum.setBounds(300,290,400,30);
 pinnum.setFont(new Font("Raleway",Font.BOLD,20));
 add(pinnum);
 JLabel pind=new JLabel("Your 4 digit PIN");
 pind.setBounds(50,310,250,30);
 pind.setFont(new Font("Raleway",Font.BOLD,12));
 add(pind);
 JLabel service=new JLabel("Serice Required:");
 service.setBounds(50,350,250,30);
 service.setFont(new Font("Raleway",Font.BOLD,20));
 add(service);
 c1=new JCheckBox("ATM card");
 c1.setBounds(50,400,200,30);
 c1.setFont(new Font("Raleway",Font.BOLD,14));
 c1.setBackground(Color.white);
 add(c1);
 c2=new JCheckBox("Mobile Banking");
 c2.setBounds(50,440,200,30);
 c2.setFont(new Font("Raleway",Font.BOLD,14));
 c2.setBackground(Color.white);
 add(c2);
 c3=new JCheckBox("Cheque Book");
 c3.setBounds(50,480,200,30);
 c3.setFont(new Font("Raleway",Font.BOLD,14));
 c3.setBackground(Color.white);
 add(c3);
 c4=new JCheckBox("Internet Banking");
 c4.setBounds(350,400,300,30);
 c4.setFont(new Font("Raleway",Font.BOLD,14));
 c4.setBackground(Color.white);
 add(c4);
 c5=new JCheckBox("Email & SMS Alert");
 c5.setBounds(350,440,300,30);
 c5.setFont(new Font("Raleway",Font.BOLD,14));
 c5.setBackground(Color.white);
 add(c5);
 c6=new JCheckBox("E-Statement");
 c6.setBounds(350,480,200,30);
 c6.setFont(new Font("Raleway",Font.BOLD,14));
 c6.setBackground(Color.white);
 add(c6);
 c7=new JCheckBox("I here by decleared that all the particular are given that is correct.");
 c7.setBounds(50,530,600,15);
 c7.setFont(new Font("Raleway",Font.BOLD,12));
 c7.setBackground(Color.white);
 add(c7);
 Submit =new JButton("Submit");
 Submit.setBounds(150,600,100,30);
 Submit.setBackground(Color.black);
 Submit.setForeground(Color.white);
 add(Submit);
 Submit.addActionListener(this);
 Cancel =new JButton("Cancel");
 Cancel.setBounds(350,600,100,30);
 Cancel.setBackground(Color.black);
 Cancel.setForeground(Color.white);
 Cancel.addActionListener(this);
 add(Cancel);
 getContentPane().setBackground(Color.white);
 setTitle("Account Detail");
 setSize(600,750);
 setLocation(300,00);
 setLayout(null);
 setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String Account=null;
		String Facility="";
		String form_no=formno;
		if(ae.getSource()==Submit)
		{
			if(c7.isSelected())
			{
				if(r1.isSelected())
				{
					Account="Saving Account";
				}
				else if(r2.isSelected())
				{
					Account="Fixed Deposit Account";
				}
				else if(r3.isSelected())
				{
					Account="Current Account";
				}
				else if(r4.isSelected())
				{
					Account="Reccuting Deposit Account";
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Account type is required");
				}
				if(c1.isSelected())
				{
					Facility=Facility+" ATM CARD";
				}
				if(c2.isSelected())
				{
					Facility=Facility+" Mobile Banking";
				}
				if(c3.isSelected())
				{
					Facility=Facility+" Cheque Book";
				}
				if(c4.isSelected())
				{
					Facility=Facility+" Internet Banking";
				}
				if(c5.isSelected())
				{
					Facility=Facility+" Email & SMS Alert";
				}
				if(c6.isSelected())
				{
					Facility=Facility+" E-Statement";
				}
				else if(Facility.equals(""))
				{
					Facility="'No service choosen'";
				}
				Testing T=new Testing();
				
				String Card=T.card;
				String Pin=T.pin;
				System.out.println(Card+" "+Pin);
				System.out.println(Account);
				System.out.println(Facility);
				try{
					Conn c=new Conn();
					String query1=String.format("Insert into Account_details values('%s','%s','%s')",form_no,Account,Facility);
					String query2=String.format("Insert into Card_detail values('%s','%s')",Card,Pin);
					c.st.executeUpdate(query1);
					c.st.executeUpdate(query2);
					JOptionPane.showMessageDialog(null, "Card_No: "+Card+" "+"\nPin_No: "+Pin);
					setVisible(false);
					new Deposit1(Pin,Card).setVisible(true);
					
				}catch (Exception e)
				{
					e.printStackTrace();
				}
				
		}
			else
			{
				JOptionPane.showMessageDialog(null,"plz select the Declearation");
			}
	}
		
	if(ae.getSource()==Cancel)
	{
		setVisible(false);
		new AditionalD("").setVisible(true);
	}
		
		
		
		
	}
	public static void main(String args[])
	{
		new AccountD("");
	}
	
}
