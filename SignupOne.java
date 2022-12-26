import java.awt.Color;
import java.awt.Font;
import java.util.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne implements ActionListener{

	JFrame frame = new JFrame();
	
	JTextField nametext,fnametext,dobtext,emailtext,addresstext,citytext,statetext,pincodetext;
	JButton next;
	JRadioButton male,female,other,married,unmarried;
	JDateChooser datechooser;
	
	Random ran = new Random();
	long random = (ran.nextLong() % 9000L)+1000L;
	String formnumber = "" + Math.abs(random);
	
	SignupOne()
	
	{
		
		frame.setLayout(null);
		
		
		
		JLabel formno = new JLabel("APPLICATION FORM NO. "+ random);
		formno.setFont(new Font("Raleway",Font.BOLD,38));
		formno.setBounds(150,20,600,40);
		frame.add(formno);
		
		JLabel personaldetails = new JLabel("Page 1:Personal Details");
		personaldetails.setFont(new Font("Raleway",Font.BOLD,28));
		personaldetails.setBounds(280,80,600,40);
		frame.add(personaldetails);
		
		JLabel name = new JLabel("Name:");
		name.setFont(new Font("Raleway",Font.BOLD,18));
		name.setBounds(100,140,600,40);
		frame.add(name);
		
		nametext = new JTextField();
		nametext.setFont(new Font("Raleway",Font.BOLD,14));
		nametext.setBounds(300, 140, 400, 30);
		frame.add(nametext);
		
		
		JLabel fname = new JLabel("Father's Name:");
		fname.setFont(new Font("Raleway",Font.BOLD,18));
		fname.setBounds(100,190,600,40);
		frame.add(fname);
		 fnametext = new JTextField();
		fnametext.setFont(new Font("Raleway",Font.BOLD,14));
		fnametext.setBounds(300, 190, 400, 30);
		frame.add(fnametext);
		
		
		JLabel dob = new JLabel("Date of Birth:");
		dob.setFont(new Font("Raleway",Font.BOLD,18));
		dob.setBounds(100,240,600,40);
		frame.add(dob);
		datechooser = new JDateChooser();
		datechooser.setBounds(300, 240, 400, 30);
		frame.add(datechooser);
		
		
		JLabel gender = new JLabel("Gender:");
		gender.setFont(new Font("Raleway",Font.BOLD,18));
		gender.setBounds(100,290,600,40);
		frame.add(gender);
		
		 male = new JRadioButton("Male");
		male.setBounds(300,290,60,30);
		male.setBackground(Color.white);
		frame.add(male);

		 female = new JRadioButton("Female");
		female.setBounds(450,290,80,30);
		female.setBackground(Color.white);
		frame.add(female);
		
		ButtonGroup gendergroup = new ButtonGroup();
		gendergroup.add(male);
		gendergroup.add(female);
		
		
		JLabel email = new JLabel("Email Address:");
		email.setFont(new Font("Raleway",Font.BOLD,18));
		email.setBounds(100,340,600,40);
		frame.add(email);
		 emailtext = new JTextField();
		emailtext.setFont(new Font("Raleway",Font.BOLD,14));
		emailtext.setBounds(300, 340, 400, 30);
		frame.add(emailtext);
		
		
		JLabel mstatus = new JLabel("Maritial Status:");
		mstatus.setFont(new Font("Raleway",Font.BOLD,18));
		mstatus.setBounds(100,390,600,40);
		frame.add(mstatus);
		
		 married = new JRadioButton("Married");
		married.setBounds(300,390,80,30);
		married.setBackground(Color.white);
		frame.add(married);
		
		unmarried = new JRadioButton("Unmarried");
		unmarried.setBounds(420,390,100,30);
		unmarried.setBackground(Color.white);
		frame.add(unmarried);
		
		other = new JRadioButton("Other");
		other.setBounds(550,390,80,30);
		other.setBackground(Color.white);
		frame.add(other);
		
		ButtonGroup maritialgroup = new ButtonGroup();
		maritialgroup.add(married);
		maritialgroup.add(unmarried);
		maritialgroup.add(other);
		
		
		JLabel address = new JLabel("Address:");
		address.setFont(new Font("Raleway",Font.BOLD,18));
		address.setBounds(100,440,600,40);
		frame.add(address);
		addresstext = new JTextField();
		addresstext.setFont(new Font("Raleway",Font.BOLD,14));
		addresstext.setBounds(300, 440, 400, 30);
		frame.add(addresstext);
		
		
		JLabel city = new JLabel("City:");
		city.setFont(new Font("Raleway",Font.BOLD,18));
		city.setBounds(100,490,600,40);
		frame.add(city);
		 citytext = new JTextField();
		citytext.setFont(new Font("Raleway",Font.BOLD,14));
		citytext.setBounds(300, 490, 400, 30);
		frame.add(citytext);
		
		
		JLabel state= new JLabel("State:");
		state.setFont(new Font("Raleway",Font.BOLD,18));
		state.setBounds(100,540,600,40);
		frame.add(state);
		 statetext = new JTextField();
		statetext.setFont(new Font("Raleway",Font.BOLD,14));
		statetext.setBounds(300, 540, 400, 30);
		frame.add(statetext);
		
		
		JLabel pincode = new JLabel("Pincode");
		pincode.setFont(new Font("Raleway",Font.BOLD,18));
		pincode.setBounds(100,590,600,40);
		frame.add(pincode);
		pincodetext = new JTextField();
		pincodetext.setFont(new Font("Raleway",Font.BOLD,14));
		pincodetext.setBounds(300, 590, 400, 30);
		frame.add(pincodetext);
		
		JButton next = new JButton("Next");
		next.setBounds(620,660,80,30);
		next.setForeground(Color.white);
		next.setBackground(Color.black);
		next.addActionListener(this);
		frame.add(next);
		
		
		
		frame.getContentPane().setBackground(Color.white);
		frame.setSize(850, 800);
		frame.setLocation(350, 10);
		frame.setVisible(true);
	}
		
		
		public void actionPerformed(ActionEvent ae) 
		{
			String formno =formnumber ;//random is integer here
			String name = nametext.getText();
			String fname = fnametext.getText();
			String dob =((JTextField) datechooser.getDateEditor().getUiComponent()).getText();			
			String gender=null;
			if(male.isSelected()) {
				gender="Male";
			}else if(female.isSelected()) {
				gender="Female";
			}
			String email= emailtext.getText() ;
			String maritial=null;
			if(married.isSelected()) {
				maritial="Married";
			}else if (unmarried.isSelected()) {
				maritial="Unmarried";
			}else if (other.isSelected()) {
				maritial="other";
			}
			
			String address = addresstext.getText();
			String city = citytext.getText();
			String state = statetext.getText();
			String pin = pincodetext.getText();
			
			
			try {
				if(name.equals("")) {
					JOptionPane.showMessageDialog(null, "Name is Required");
				}else {
					Conn c = new Conn();
					String query="insert into signup values ('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+maritial+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
					c.s.executeUpdate(query);
					
					//values inserted by user then next form will open
					frame.setVisible(false);
					SignupTwo signuptwo =new SignupTwo(formnumber);
					signuptwo.frame.setVisible(true);
				}
			
			}catch(Exception e) {
				System.out.println(e);
			}
		}
	
	public static void main(String[] args)
	{
	new SignupOne();	

	}
}
