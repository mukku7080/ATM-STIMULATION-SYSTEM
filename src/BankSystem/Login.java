package BankSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;

public class Login extends JFrame implements ActionListener{
	JButton login,clear,signup;
	JTextField CardNumber;
	JPasswordField Pin;
	Login()
	{
		setTitle("automatic teller machine");
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("logo.jpg"));
		Image i2=i1.getImage().getScaledInstance(100, 100, DO_NOTHING_ON_CLOSE);
		ImageIcon i3=new ImageIcon(i2);
		JLabel label=new JLabel(i3);
		label.setBounds(70,10,100,100);
		add(label);
		JLabel text=new JLabel("WELCOME TO ATM");
		text.setFont(new Font("Osward",Font.BOLD,38));;
		text.setBounds(200,40,400,40);
		add(text);
		JLabel card=new JLabel("Card_NO:");
		card.setFont(new Font("Osward",Font.BOLD,25));;
		card.setBounds(90,120,200,40);
		add(card);
		JLabel pin=new JLabel("PIN_NO:");
		pin.setFont(new Font("Osward",Font.BOLD,25));;
		pin.setBounds(90,180,200,40);
		add(pin);
		CardNumber=new JTextField();
		CardNumber.setBounds(220,128,218,30);
		add(CardNumber);
		Pin=new JPasswordField();
		Pin.setBounds(220,200,218,30);
		add(Pin);
		login=new JButton("Sign-in");
		login.setBounds(220, 280, 100, 30);
		login.setBackground(Color.black);
		login.setForeground(Color.white);
		login.addActionListener(this);
		add(login);
		clear=new JButton("clear");
		clear.setBounds(340, 280, 100, 30);
		clear.setBackground(Color.black);
		clear.setForeground(Color.white);
		clear.addActionListener(this);
		add(clear);
		signup=new JButton("Sign-up");
		signup.setBounds(220, 320, 220, 30);
		signup.setBackground(Color.black);
		signup.setForeground(Color.white);
		signup.addActionListener(this);
		add(signup);
		
		getContentPane().setBackground(Color.WHITE);
		setSize(700,500);
		setLayout(null);
		setLocation(300,200);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==login)
		{
			String card=CardNumber.getText();
			String pin=Pin.getText();
		Conn c=new Conn();
		try {
			String query=String.format("select * from Card_detail where(Card_number='%s' and PIN_number='%s')",card,pin);
			ResultSet rs=c.st.executeQuery(query);
			if(rs.next())
			{
				setVisible(false);
				new Transiction(pin,card).setVisible(true);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "card no or pin is invalid:");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		}
		else if(ae.getSource()==clear)
		{
			CardNumber.setText("");
			Pin.setText("");
		}
		else if(ae.getSource()==signup)
		{
			setVisible(false);
			new SignupOne().setVisible(true);
		}
	}
	public static void main(String[] args) {
		new Login();

	}

}
