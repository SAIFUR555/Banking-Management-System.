import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;    
public class SignupPage extends JFrame{
	private Container c;
	private ImageIcon icon;
	
	private JLabel firstNameLabel, lastNameLabel, nameLabel, usernameLabel, passwordLabel, phoneLabel, emailLabel, dateOfBirthLabel,  dateOfBirthLabel_2, genderLabel, addressLabel;
	private JLabel usernameError, firstNameError, lastNameError,  balanceError, phoneError, emailError, dateOfBirthError, genderError, passwordError, addressError; /*Warnings*/
	private JTextField usernameText, firstNameText, lastNameText,  balanceText, phoneText, emailText, dateOfBirthText, genderText, addressText;
	private JPasswordField passText;
	private JButton signpButton, clearButton, cancelButton, backButton;
	private JRadioButton maleRadio, femaleRadio, otherRadio;
	private ButtonGroup buttonGroup;
	SignupPage(int x, int y)
	{

		/*********************** Same Everywhere**********************/
		Color backgroundColor = new Color(133,172,233);
		Font labelFont, errorFont;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Create New Account");
		this.setBounds(x,y, 1000,1000);
		this.setResizable(false);
		this.c = this.getContentPane();
		this.c.setLayout(null);
		this.c.setBackground(backgroundColor);  
		this.icon = new ImageIcon(getClass().getResource("images/icon.png"));
		this.setIconImage(icon.getImage());
		/**************************************************/


		//******************  Fonts ******************

		labelFont = new Font("Gotham",Font.BOLD,20);
		Font textFont = new Font("Gotham",Font.PLAIN,20);
		errorFont = new Font("Ariel", Font.ITALIC+Font.BOLD,12);



		//******************  Username ******************
		usernameLabel = new JLabel("USERNAME");
		usernameLabel.setBounds(60,50,150,50);
		usernameLabel.setFont(labelFont);
		c.add(usernameLabel);

		JLabel finalUsername = new JLabel("[ Account will be known as and cannot change later]");
		finalUsername.setBounds(530,100,400,25);
		c.add(finalUsername);

		usernameError = new JLabel("");
		usernameError.setBounds(360, 100, 200,25);
		usernameError.setForeground(Color.RED);
		usernameError.setFont(errorFont);
		c.add(usernameError);

		////textFiled ******************

		usernameText = new JTextField("");
		usernameText.setFont(textFont);
		usernameText.setBounds(350, 50, 550,50);
		usernameText.setHorizontalAlignment(JTextField.CENTER);
		c.add(usernameText);


		//****************** Name ******************
		nameLabel = new JLabel("NAME");
		nameLabel.setFont(labelFont);
		nameLabel.setBounds(60,150,200,50);
		c.add(nameLabel);
		firstNameError = new JLabel("");
		firstNameError.setBounds(420, 200, 200, 25);
		firstNameError.setForeground(Color.RED);
		firstNameError.setFont(errorFont);
		c.add(firstNameError);
		lastNameError = new JLabel("");
		lastNameError.setBounds(720, 200, 200, 25);
		lastNameError.setForeground(Color.RED);
		lastNameError.setFont(errorFont);
		c.add(lastNameError);

		firstNameLabel = new JLabel("First");
		firstNameLabel.setBounds(360, 200, 100, 25);
		c.add(firstNameLabel);

		lastNameLabel = new JLabel("Last");
		lastNameLabel.setBounds(660, 200, 100, 25);
		c.add(lastNameLabel);


		// Text Field ***********

		firstNameText = new JTextField("");
		firstNameText.setBounds(350, 150, 250,50);
		firstNameText.setFont(textFont);
		firstNameText.setHorizontalAlignment(JTextField.CENTER);
		c.add(firstNameText);
		lastNameText = new JTextField("");
		lastNameText.setBounds(650,150,250,50);
		lastNameText.setFont(textFont);
		lastNameText.setHorizontalAlignment(JTextField.CENTER);
		c.add(lastNameText);

		//****************** Email ******************
		emailLabel = new JLabel("EMAIL");
		emailLabel.setBounds(60,250,150,50);
		emailLabel.setFont(labelFont);
		c.add(emailLabel);
		emailError = new JLabel("");
		emailError.setBounds(360, 300, 200,25);
		emailError.setForeground(Color.RED);
		emailError.setFont(errorFont);
		c.add(emailError);

		////textFiled ******************

		emailText = new JTextField("");
		emailText.setFont(textFont);
		emailText.setHorizontalAlignment(JTextField.CENTER);
		emailText.setBounds(350, 250, 550,50);
		c.add(emailText);


	//****************** Phone ******************
		phoneLabel = new JLabel("PHONE");
		phoneLabel.setBounds(60,350,150,50);
		phoneLabel.setFont(labelFont);
		c.add(phoneLabel);
		phoneError = new JLabel("");
		phoneError.setBounds(360, 400, 200,25);
		phoneError.setForeground(Color.RED);
		phoneError.setFont(errorFont);
		c.add(phoneError);

		////textFiled ******************

		phoneText = new JTextField("");
		phoneText.setFont(textFont);
		phoneText.setHorizontalAlignment(JTextField.CENTER);
		phoneText.setBounds(350, 350, 550,50);
		c.add(phoneText);



		//****************** Address  ****************** 
		addressLabel = new JLabel("ADDRESS");
		addressLabel.setBounds(60,450,150,50);
		addressLabel.setFont(labelFont);
		c.add(addressLabel);
		addressError = new JLabel("");
		addressError.setBounds(360, 500, 200,25);
		addressError.setForeground(Color.RED);
		addressError.setFont(errorFont);
		c.add(addressError);

		////textFiled ******************

		addressText = new JTextField("");
		addressText.setFont(textFont);
		addressText.setHorizontalAlignment(JTextField.CENTER);
		addressText.setBounds(350, 450, 550,50);
		c.add(addressText);



		//****************** Date Of Birth ******************
		dateOfBirthLabel = new JLabel("DATE OF BIRTH");
		dateOfBirthLabel.setBounds(60,550,200,50);
		dateOfBirthLabel.setFont(labelFont);
		c.add(dateOfBirthLabel);
		dateOfBirthError = new JLabel("");
		dateOfBirthError.setBounds(560, 600, 200,25);
		dateOfBirthError.setForeground(Color.RED);
		dateOfBirthError.setFont(errorFont);
		c.add(dateOfBirthError);

		dateOfBirthLabel_2 = new JLabel("(DD-MM-YYYY)");
		dateOfBirthLabel_2.setBounds(360, 600, 200,25);
		c.add(dateOfBirthLabel_2);

		////textFiled ******************

		dateOfBirthText = new JTextField("");
		dateOfBirthText.setFont(textFont);
		dateOfBirthText.setHorizontalAlignment(JTextField.CENTER);
		dateOfBirthText.setBounds(350, 550, 550,50);
		c.add(dateOfBirthText);


		//****************** Gender ******************
		genderLabel = new JLabel("GENDER");
		genderLabel.setBounds(60,650,150,50);
		genderLabel.setFont(labelFont);
		c.add(genderLabel);
		maleRadio = new JRadioButton("Male");
		maleRadio.setBounds(350, 650, 60,50);
		maleRadio.setBackground(backgroundColor);
		c.add(maleRadio);
		femaleRadio = new JRadioButton("Female");
		femaleRadio.setBounds(500, 650, 100,50);
		femaleRadio.setBackground(backgroundColor);
		c.add(femaleRadio);

		otherRadio = new JRadioButton("Other");
		otherRadio.setBounds(650, 650, 100,50);
		otherRadio.setBackground(backgroundColor);
		otherRadio.setSelected(true);
		c.add(otherRadio);

		buttonGroup = new ButtonGroup();
		buttonGroup.add(maleRadio);
		buttonGroup.add(femaleRadio);
		buttonGroup.add(otherRadio);

		

		//****************** Password  ******************
		passwordLabel = new JLabel("PASSWORD");
		passwordLabel.setBounds(60,750,150,50);
		passwordLabel.setFont(labelFont);
		c.add(passwordLabel);
		passwordError = new JLabel("");
		passwordError.setBounds(360, 800, 300,25);
		passwordError.setForeground(Color.RED);
		passwordError.setFont(errorFont);
		c.add(passwordError);

		////textFiled ******************

		passText = new JPasswordField("");
		passText.setFont(textFont);
		passText.setBounds(350,750, 550,50);
		passText.setHorizontalAlignment(JTextField.CENTER);
		c.add(passText);


		// ****************** Buttons ******************

		// Signup Button **********

		signpButton = new JButton("SIGNUP");
		signpButton.setBackground(new Color(0,153,0));
		signpButton.setForeground(Color.WHITE);
		signpButton.setFont(new Font("Gotham",Font.BOLD,25));
		signpButton.setBounds(400, 850, 200,50);
		c.add(signpButton);

		clearButton = new JButton("Clear");
		clearButton.setBackground(new Color(255,128,0));
		clearButton.setForeground(Color.WHITE);
		clearButton.setBounds(700, 850, 100,50);
		c.add(clearButton);


		cancelButton = new JButton("Cancel");
		cancelButton.setBackground(new Color(204,0,0));
		cancelButton.setForeground(Color.WHITE);
		cancelButton.setBounds(200, 850, 100,50);
		c.add(cancelButton);


		signpButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				 Username username = new Username(usernameText.getText());
				 String firstName = firstNameText.getText();
				 String lastName = lastNameText.getText();
				 String email = emailText.getText();
				 Matcher matcher = (Pattern.compile("^(.+)@(.+)$")).matcher(email);
				 String phone = phoneText.getText();
				 String address = addressText.getText();
				 String dateOfBirth = dateOfBirthText.getText();
				 String password = String.valueOf(passText.getPassword());
				 String gender;
				 if(maleRadio.isSelected())
				 {
				 	gender = "Male";
				 }
				 else if(femaleRadio.isSelected())
				 {
				 	gender = "Female";
				 }
				 else{
				 	gender = "Other";
				 }
				
				
				 if(!(username.get()).equals("") && !(firstName.equals("")) && !(lastName.equals("")) && !(email.equals("")) && !(phone.equals("")) && !(address.equals("")) && !(dateOfBirth.equals("")) && !(password.equals("")) && password.length()>=8 && matcher.matches())
				 {
				 	if(!(username.exists()))
				 	{
					 	User user = new User(username.get(), firstName, lastName, email, phone, address, dateOfBirth, gender, password);
					 	user.saveFile(); //for dat file
					 	username.write(); //for txt file
					 	JOptionPane.showMessageDialog(null, "Account successfully created \n Now you can login", "Signup successful", -1);
						
					 	Point point = getLocation();
						int x = (int)point.getX(); int y = (int)point.getY();
						MainPage main = new MainPage(x,y);
						main.setVisible(true);
						dispose();
				 	}
				 	else
				 	{
				 		usernameError.setText("Username already exists");
				 	}
				 }

				 else
				 {	
				 	if(username.exists())
				 	{
				 		usernameError.setText("Username already exists");
				 	}
				 	else if((username.get()).equals("")){
				 		usernameError.setText("Empty username");
				 	}
				 	else
				 	{
				 		usernameError.setText("");
				 	}


				 	if(firstName.equals(""))
				 	{
				 		firstNameError.setText("Empty first name");
				 	}
				 	else{
				 		firstNameError.setText("");
				 	}

				 	if(lastName.equals(""))
				 	{
				 		lastNameError.setText("Empty last name");
				 	}
				 	else
			 		{
				 		lastNameError.setText("");
				 	}
				 	if(email.equals(""))
				 	{
				 		emailError.setText("Empty email");
				 	}
				 	else if(!(matcher.matches()))
				 	{
				 		emailError.setText("Invalid Email format");
				 	}
				 	else
			 		{
				 		emailError.setText("");
				 	}
				 	if(phone.equals(""))
				 	{
				 		phoneError.setText("Empty phone no");
				 	}
				 	else
				 	{
				 		phoneError.setText("");
				 	}
				 	if(address.equals(""))
				 	{
				 		addressError.setText("Empty address");
				 	}
				 	else
				 	{
				 		addressError.setText("");
				 	}
				 	if(dateOfBirth.equals(""))
				 	{
				 		dateOfBirthError.setText("Empty date of birth");
				 	}
				 	else
			 		{
				 		dateOfBirthError.setText("");
				 	}
				 	if(password.equals(""))
				 	{
				 		passwordError.setText("Empty Password");
				 	}
				 	else if(password.length()<8)
				 	{
				 		passwordError.setText("Password should have at least 8 characters");	
				 	}
				 	else
			 		{
				 		passwordError.setText("");
				 	}
				 }
				 

			}
		});
		
		clearButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				usernameText.setText("");
				usernameError.setText("");
				firstNameText.setText("");
				firstNameError.setText("");
				lastNameText.setText("");
				lastNameError.setText("");
				emailText.setText("");
				emailError.setText("");
				phoneText.setText("");
				phoneError.setText("");
				addressText.setText("");
				addressError.setText("");
				dateOfBirthText.setText("");
				dateOfBirthError.setText("");
				passText.setText("");
				passwordError.setText("");



			}
		});

		cancelButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				
				Point point = getLocation();
				int x = (int)point.getX(); int y = (int)point.getY();
				MainPage main = new MainPage(x,y);
				 main.setVisible(true);
				dispose();


			}
		});
		
	}
}
