package BankSystem;

import java.awt.*;
import java.util.*;

import javax.swing.*;
//import javax.swing.JLabel;
import java.awt.event.*;
public class AditionalD extends JFrame implements ActionListener{
	JTextField adhar,pan;
	JButton next;
	String formno;
	JComboBox religion,category,income,seniorC,existingA,education,occupation;
	public AditionalD(String formno)
	
	{
		this.formno=formno;
		JLabel Aditionaldetail=new JLabel("Page 2: Aditional Detail");
		Aditionaldetail.setBounds(160,60,300,30);
		Aditionaldetail.setFont(new Font("Raleway",Font.BOLD,22));
		add(Aditionaldetail);
		JLabel rname=new JLabel("Religion:");
		rname.setBounds(100,160,100,30);
		rname.setFont(new Font("Raleway",Font.BOLD,18));
		add(rname);
		String[] dharm= {"Hindu","Muslim","Sikkh","Chiristian"};
		religion =new JComboBox(dharm);
		religion.setBounds(300,160,250,25);
		//religion.setFont(new Font("Raleway",Font.BOLD,18));
		religion.setBackground(Color.white);
		add(religion);
		JLabel categoryl=new JLabel("Category:");
		categoryl.setBounds(100,200,200,30);
		categoryl.setFont(new Font("Raleway",Font.BOLD,18));
		add(categoryl);
		String[] jati= {"General","OBC","SC","ST","Others"};
		category =new JComboBox(jati);
		category.setBounds(300,200,250,25);
		//category.setFont(new Font("Raleway",Font.BOLD,18));
		category.setBackground(Color.white);
		add(category);
		JLabel Incomel=new JLabel("Income:");
		Incomel.setBounds(100,240,100,30);
		Incomel.setFont(new Font("Raleway",Font.BOLD,18));
		add(Incomel);
		String[] sal= {"<1lac","<2.5lac","upto 10lac","others"};
		income =new JComboBox(sal);
		income.setBounds(300,240,250,25);
		//Income.setFont(new Font("Raleway",Font.BOLD,18));
		income.setBackground(Color.white);
		add(income);
		
		JLabel educationl=new JLabel("Educational");
		educationl.setBounds(100,280,200,30);
		educationl.setFont(new Font("Raleway",Font.BOLD,18));
		add(educationl);
		JLabel qualification=new JLabel("Qualification:");
		qualification.setBounds(100,320,200,30);
		qualification.setFont(new Font("Raleway",Font.BOLD,18));
		add(qualification);
		String[] edu= {"Highschool","Intermediate","Graduate","Post-Graduate","Docterate"};
		education=new JComboBox(edu);
		education.setBounds(300,320,250,25);
		//Income.setFont(new Font("Raleway",Font.BOLD,18));
		education.setBackground(Color.white);
		add(education);
		JLabel occupationl=new JLabel("Occupation:");
		occupationl.setBounds(100,360,200,30);
		occupationl.setFont(new Font("Raleway",Font.BOLD,18));
		add(occupationl);
		String[] ocu= {"private","State Government Employee","Central Government Employee","Self-Bussiness"};
		occupation=new JComboBox(ocu);
		occupation.setBounds(300,360,250,25);
		//Income.setFont(new Font("Raleway",Font.BOLD,18));
		occupation.setBackground(Color.white);
		add(occupation);
		
		JLabel panl=new JLabel("PAN number:");
		panl.setBounds(100,400,200,30);
		panl.setFont(new Font("Raleway",Font.BOLD,18));
		add(panl);
		pan=new JTextField();
		pan.setBounds(300,400,250,25);
		pan.setFont(new Font("Raleway",Font.BOLD,18));
		add(pan);
		JLabel adharl = new JLabel("Aadhar:");
		adharl.setBounds(100,440,200,30);
		adharl.setFont(new Font("Raleway",Font.BOLD,18));
		add(adharl);
		adhar=new JTextField();
		adhar.setBounds(300,440,250,25);
		adhar.setFont(new Font("Raleway",Font.BOLD,18));
		add(adhar);
		
		JLabel SC=new JLabel("Senior Citizen:");
		SC.setBounds(100,480,200,30);
		SC.setFont(new Font("Raleway",Font.BOLD,18));
		add(SC);
		String[] option= {"Yes","No"};
		seniorC =new JComboBox(option);
		seniorC.setBounds(300,480,250,25);
		//SeniorC.setFont(new Font("Raleway",Font.BOLD,18));
		seniorC.setBackground(Color.white);
		add(seniorC);
		JLabel EA=new JLabel("Existing Account:");
		EA.setBounds(100,520,200,30);
		EA.setFont(new Font("Raleway",Font.BOLD,18));
		add(EA);
		String[] option1= {"Yes","No"};
		existingA =new JComboBox(option1);
		existingA.setBounds(300,520,250,25);
		//ExistingA.setFont(new Font("Raleway",Font.BOLD,18));
		existingA.setBackground(Color.white);
		add(existingA);
		
		next =new JButton("next");
		next.setBounds(350,590,100,30);
		next.setBackground(Color.black);
		next.setForeground(Color.white);
		add(next);
		next.addActionListener(this);
		getContentPane().setBackground(Color.WHITE);
		setSize(600,700);
		setLocation(300,00);
		setLayout(null);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		String form_no=formno;
		String Religion=(String)religion.getSelectedItem();
		String Category=(String)category.getSelectedItem();
		String Income=(String)income.getSelectedItem();
		String Education=(String)education.getSelectedItem();
		
		String Occupation=(String)occupation.getSelectedItem();
	
		String Pan=pan.getText();
		String Adhar=adhar.getText();
		String Seniorcitizen=(String)seniorC.getSelectedItem();
		String ExistingA=(String)existingA.getSelectedItem();
		try {
	
		
				
				Conn c=new  Conn();
				String querry=String.format("insert into Aditional_detail values('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')",form_no,Religion,Category,Income,Education,Occupation,Pan,Adhar,Seniorcitizen,ExistingA);
				c.st.executeUpdate(querry);
				JOptionPane.showMessageDialog(null, "data sucessfully submited");
				setVisible(false);
				new AccountD(formno).setVisible(true);
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
public static void main(String args[])
{
	new AditionalD("");
}
}

