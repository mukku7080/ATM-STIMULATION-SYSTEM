package BankSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Estatement extends JFrame {
	public Estatement(){
		ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
		Image i1=i.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i2=new ImageIcon(i1);
		JLabel screen =new JLabel(i2);
		screen.setBounds(0,0,900,900);
		add(screen);
		JLabel head=new JLabel("Estatment");
		head.setBounds(230,300,400,30);
		head.setFont(new Font("Raleway",Font.BOLD,16));
		head.setForeground(Color.white);
		screen.add(head);
		setSize(900,900);
		setLayout(null);
		setLocation(230,0);
		setVisible(true);
		
		
	}
public static void main(String args[]) {
	new Estatement();
}
}
