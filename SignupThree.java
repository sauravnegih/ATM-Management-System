import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class SignupThree extends JFrame implements ActionListener{

	JRadioButton r1,r2,r3,r4;
	JCheckBox c1,c2,c3,c4,c5,c6,c7;
	JButton submit,cancel;
	String formno;
	SignupThree(String formno)
	{
		this.formno=formno;
		setLayout(null);
		JLabel l1 = new JLabel("Page 3: Account Details");
		l1.setFont(new Font("Raleway",Font.BOLD,22));
		l1.setBounds(280,30,400,40);
		add(l1);
		
		JLabel type =  new JLabel("Account Type");
		type.setFont(new Font("Raleway",Font.BOLD,22));
		type.setBounds(100,140,200,30);
		add(type);
		
		r1 = new JRadioButton ("Saving Account");
		r1.setFont(new Font("Raleway",Font.BOLD,16));
		r1.setBackground(Color.white);
		r1.setBounds(100,180,150,20);
		add(r1);
		

		r2 = new JRadioButton ("Fixed Deposit Account");
		r2.setFont(new Font("Raleway",Font.BOLD,16));
		r2.setBackground(Color.white);
		r2.setBounds(350,180,250,20);
		add(r2);

		r3 = new JRadioButton ("Current Account");
		r3.setFont(new Font("Raleway",Font.BOLD,16));
		r3.setBackground(Color.white);
		r3.setBounds(100,220,250,20);
		add(r3);

		r4 = new JRadioButton ("Recurring Deposit Account");
		r4.setFont(new Font("Raleway",Font.BOLD,16));
		r4.setBackground(Color.white);
		r4.setBounds(350,220,250,20);
		add(r4);
		
		ButtonGroup groupaccount = new ButtonGroup();
		groupaccount.add(r1);
		groupaccount.add(r2);
		groupaccount.add(r3);
		groupaccount.add(r4);
		
		JLabel card = new JLabel("Card Number");
		card.setFont(new Font("Raleway",Font.BOLD,22));
		card.setBounds(100,300,200,40);
		add(card);
		
		JLabel number = new JLabel("XXXX-XXXX-XXXX-6150");
		number.setFont(new Font("Raleway",Font.BOLD,22));
		number.setBounds(330,300,300,40);
		add(number);
		
		
		JLabel pin = new JLabel("PIN:");
		pin.setFont(new Font("Raleway",Font.BOLD,22));
		pin.setBounds(100,370,200,40);
		add(pin);
		
		JLabel carddetails = new JLabel("Your 16 digit card number");
		carddetails.setFont(new Font("Raleway",Font.BOLD,10));
		carddetails.setBounds(100,330,300,15);
		add(carddetails);
		
		JLabel pnumber = new JLabel("XXXX");
		pnumber.setFont(new Font("Raleway",Font.BOLD,22));
		pnumber.setBounds(330,370,300,40);
		add(pnumber);
		
		JLabel pindetails = new JLabel("Your 4 digit PIN");
		pindetails.setFont(new Font("Raleway",Font.BOLD,10));
		pindetails.setBounds(100,400,300,15);
		add(pindetails);
		
		JLabel services = new JLabel("Services Required");
		services.setFont(new Font("Raleway",Font.BOLD,22));
		services.setBounds(100,450,400,40);
		add(services);
		
		c1 = new JCheckBox("ATM CARD");
		c1.setBackground(Color.white);
		c1.setFont(new Font("Raleway",Font.BOLD,22));
		c1.setBounds(100,500,200,30);
		add(c1);
		
		c2 = new JCheckBox("Internet Banking");
		c2.setBackground(Color.white);
		c2.setFont(new Font("Raleway",Font.BOLD,22));
		c2.setBounds(350,500,200,30);
		add(c2);
		
		c3 = new JCheckBox("Mobile Banking");
		c3.setBackground(Color.white);
		c3.setFont(new Font("Raleway",Font.BOLD,22));
		c3.setBounds(100,550,200,30);
		add(c3);
		
		c4 = new JCheckBox("Email & SMS Alerts");
		c4.setBackground(Color.white);
		c4.setFont(new Font("Raleway",Font.BOLD,22));
		c4.setBounds(350,550,250,30);
		add(c4);
		
		c5 = new JCheckBox("Cheque Book");
		c5.setBackground(Color.white);
		c5.setFont(new Font("Raleway",Font.BOLD,22));
		c5.setBounds(100,600,200,30);
		add(c5);
		
		c6 = new JCheckBox("E-Statement");
		c6.setBackground(Color.white);
		c6.setFont(new Font("Raleway",Font.BOLD,22));
		c6.setBounds(350,600,200,30);
		add(c6);
		
		c7 = new JCheckBox("I hereby declares that the above entered details are correct");
		c7.setBackground(Color.white);
		c7.setFont(new Font("Raleway",Font.BOLD,12));
		c7.setBounds(100,650,600,30);
		add(c7);
		
		submit = new JButton("Submit");
		submit.setBackground(Color.black);
		submit.setForeground(Color.white);
		submit.setFont(new Font("Raleway",Font.BOLD,12) );
		submit.setBounds(200,680,100,30);
		submit.addActionListener(this);
		add(submit);
		

		cancel = new JButton("Cancel");
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		cancel.setFont(new Font("Raleway",Font.BOLD,12) );
		cancel.setBounds(420, 680, 100, 30);
		cancel.addActionListener(this);
		add(cancel);
		
		getContentPane().setBackground(Color.white);
		
		setSize(850,820);
		setLocation(350,0);
		setVisible(true);
		
		
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==submit)
		{
			 String type=null;
			 if(r1.isSelected())
			 {
				 type="Saving Account";
			 }else if(r2.isSelected()) {
				 type="Fixed Deposit Account";
			 }else if (r3.isSelected()) {
				 type="Current Account";
			 }else if (r4.isSelected()) {
				 type="Reccuring Deposit Account";
			 }
			 
			 Random random = new Random();
			String cardnumber =""+ Math.abs((random.nextLong() %90000000L)+ 5040936000000000L);
			String pinnumber = ""+ Math.abs((random.nextLong() %9000L)+ 1000L);
		
			String facility = "";
			if(c1.isSelected()) {
				facility = facility+"ATM Card";
			}else if (c2.isSelected()) {
				facility = facility +"Internet Banking";
			}else if (c3.isSelected()) {
				facility = facility +"Mobile Banking";
			}else if (c4.isSelected()) {
				facility = facility +"Email & SMS Alert";
			}else if (c5.isSelected()) {
				facility = facility +"Cheque Book";
			}else if (c6.isSelected()) {
				facility= facility +"E-Statement";
			}
			try {
				if(type.equals("")) {
					JOptionPane.showMessageDialog(null, "Account type is required");
				}else {
					Conn conn = new Conn();
					String query1 = "insert into signupthree values('"+formno+"','"+type+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
					conn.s.execute(query1);
					String query2 = "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
					conn.s.execute(query2);
					JOptionPane.showMessageDialog(null, "Card number:"+cardnumber+"\n Pin:"+pinnumber);
					
				}
					setVisible(false);
					new Deposit(pinnumber).setVisible(false);
			}catch(Exception e) {
				System.out.println(e);
			}
			
			
		} else if (ae.getSource()==cancel)
		{
			System.exit(0);
			
			/*setVisible(false);
			Login login =new Login();
			login.jf.setVisible(true);
			*/
		}
	}
	
	public static void main(String[] args) 
	{
		new SignupThree("");

	}

}
