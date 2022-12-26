import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;
public class Login implements ActionListener {
	
	JFrame jf=new JFrame();

	JButton login = new JButton("SIGN IN");
	JButton clear = new JButton("CLEAR");
	JButton signup = new JButton("SIGN UP");
	JTextField cardtext = new JTextField();
	JPasswordField pintext = new JPasswordField();
	
	JLabel label,welcomelabel,cardno,pin;
	
	
	Login()
	{
				ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("logo.png"));
		//we do not add image directly we have to add jlabel for this and add jlabel to frame
		
		jf.setTitle("Automated Teller Machine");
		jf.setSize(600,400);
		
		 label= new JLabel(img);
		jf.add(label);
		jf.setLayout(null);//for customised location in swing layout manager should be null
		label.setBounds(50, 10, 100, 100);
		jf.setLocation(350,200);
		jf.getContentPane().setBackground(Color.white);
		
		 welcomelabel = new JLabel("Welcome To The ATM");
		welcomelabel.setBounds(170,45,400,50);
		welcomelabel.setFont(new Font("Osward",Font.BOLD,30));
		jf.add(welcomelabel);
		
		 cardno = new JLabel("Card No: ");
		cardno.setBounds(120,135,150,50);
		cardno.setFont(new Font("Raleway",Font.BOLD,30));
		jf.add(cardno);
		
		 pin = new JLabel("Pin: ");
		pin.setBounds(120,205,150,50);
		pin.setFont(new Font("Raleway",Font.BOLD,30));
		jf.add(pin);
		
		cardtext.setBounds(270, 135, 300, 40);
		jf.add(cardtext);
		
		pintext.setBounds(270, 205, 300, 40);
		jf.add(pintext);
		
		
		login.setBounds(270, 265, 80, 40);
		login.setBackground(Color.black);
		login.setForeground(Color.white);
		login.addActionListener(this);
		jf.add(login);
		
		clear.setBounds(370, 265, 80, 40);
		clear.setBackground(Color.black);
		clear.setForeground(Color.white);
		clear.addActionListener(this);
		jf.add(clear);
		
		signup.setBounds(270, 320, 180, 30);
		signup.setBackground(Color.black);
		signup.setForeground(Color.white);
		signup.addActionListener(this);
		jf.add(signup);
		
		jf.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent eve)
	{
		if(eve.getSource() == login) 
		{
			Conn conn = new Conn();
			String cardnumber = cardtext.getText();
			String pinnumber = pintext.getText();
			String query = "select * from login where cardnumber ='"+cardnumber+"' and pinnumber = '"+pinnumber+"'";
		
			try {
				 ResultSet rs =conn.s.executeQuery(query);
				 if(rs.next()) {
					 jf.setVisible(false);
					 Transactions transaction = new Transactions(pinnumber);
					 transaction.setVisible(true);
				 }else {
					 JOptionPane.showMessageDialog(null, "Incorrect card number or pin");
				 }
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		else if(eve.getSource()==clear)
		{
			cardtext.setText(""); 
			pintext.setText("");
		}
		else if(eve.getSource()==signup)
		{
			jf.setVisible(false);
			SignupOne signup = new SignupOne();
			signup.frame.setVisible(true);
	}
	}
	
	
	public static void main(String[] args)
	{
		new Login();
	}

}
