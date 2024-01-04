import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.regex.*; 
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class UserPage extends JFrame{
	
	private final JTabbedPane tabs;
	private final JTable historyTable;
	private final JScrollPane scrollPane;
	private final Container c;
	private final ImageIcon icon;
	private ImageIcon homeIcon;
	private JPanel homePanel, historyPanel, withdrawPanel, depositPanel, transferPanel, updatePanel, deletePanel;
	private JLabel labelDelete, withdrawAmountLabel, depositAmountLabel, transferAccontLabel, transferAmountLabel, labelTransferPassword;
	private JLabel infoUsername, infoName, infoBalance, infoEmail, infoPhone, infoAddress, infoDateOfBirth, infoGender;
	private JLabel withdrawMessage, depositMessage, transferMessage;
	private JTextField withdrawText, depositText, balanceText, transferAccountText, transferAmountText;
	private JPasswordField withdrawPass, depositPass, passwordTransfer, deletePass;
	private JButton withdrawOk, depositOk, transferOk, deleteOk, buttonLogOut;

	UserPage(User user, int x, int y)
	{
		/*********************** Same Everywhere**********************/
		Color backgroundColor = new Color(133,172,233);
		Font labelFont, errorFont;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(user.getFirstName());
		this.setBounds(x,y, 1000,1000);
		this.setResizable(false);
		this.c = this.getContentPane();
		this.c.setLayout(null);
		this.c.setBackground(backgroundColor);  
		this.icon = new ImageIcon(getClass().getResource("images/icon.png"));
		this.setIconImage(icon.getImage());
		/**************************************************/

		Font textFont = new Font("Gotham",Font.PLAIN,20);

		ImageIcon userIconImg = new ImageIcon(getClass().getResource("images/icons/user.png"));
		JLabel userIcon = new JLabel(userIconImg);
		userIcon.setBounds(20,0,100,100);
		c.add(userIcon);
		JLabel userIconName = new JLabel(user.getFirstName());
		userIconName.setBounds(120,0,300,100);
		userIconName.setFont(new Font("Gotham",Font.BOLD,25));
		c.add(userIconName);


		tabs = new JTabbedPane(JTabbedPane.LEFT);
		tabs.setBackground(Color.WHITE);
		tabs.setBounds(15,100,960,730);

		
		homePanel = new JPanel();
		Color homePanelColor = new Color (204,255,204);
		homePanel.setBackground(Color.WHITE);
		homePanel.setLayout(null);

		historyPanel = new JPanel();
		historyPanel.setBackground(Color.WHITE);
		historyPanel.setLayout(null);

		withdrawPanel = new JPanel();
		withdrawPanel.setBackground(Color.WHITE);
		withdrawPanel.setLayout(null);


		depositPanel = new JPanel();
		depositPanel.setBackground(Color.WHITE);
		depositPanel.setLayout(null);


		transferPanel = new JPanel();
		transferPanel.setBackground(Color.WHITE);
		transferPanel.setLayout(null);


		updatePanel = new JPanel();
		Color updatePanelColor = new Color (255,229,204);
		updatePanel.setBackground(Color.WHITE);
		updatePanel.setLayout(null);


		deletePanel = new JPanel();
		deletePanel.setBackground(Color.WHITE);
		deletePanel.setLayout(null);

		tabs.addTab("Home",homePanel);
		tabs.addTab("History",historyPanel);
		tabs.addTab("Withdraw", withdrawPanel);
		tabs.addTab("Deposit",depositPanel);
		tabs.addTab("Transfer",transferPanel);
		tabs.addTab("Update", updatePanel);
		tabs.addTab("Delete",deletePanel);

		ImageIcon homeIcon = new ImageIcon(getClass().getResource("images/icons/home.png"));
		JLabel home = new JLabel(homeIcon);
		home.setPreferredSize(new Dimension(200, 100));
		tabs.setTabComponentAt(0,home);

		ImageIcon historyIcon = new ImageIcon(getClass().getResource("images/icons/history.png"));
		JLabel history = new JLabel(historyIcon);
		history.setPreferredSize(new Dimension(200, 100));
		tabs.setTabComponentAt(1,history);

		ImageIcon withdrawIcon = new ImageIcon(getClass().getResource("images/icons/withdraw.png"));
		JLabel withdraw = new JLabel(withdrawIcon);
		withdraw.setPreferredSize(new Dimension(200, 100));
		tabs.setTabComponentAt(2,withdraw);
		
		ImageIcon depositIcon = new ImageIcon(getClass().getResource("images/icons/deposit.png"));
		JLabel deposit = new JLabel(depositIcon);
		deposit.setPreferredSize(new Dimension(200, 100));
		tabs.setTabComponentAt(3,deposit);
		
		ImageIcon transferIcon = new ImageIcon(getClass().getResource("images/icons/transfer.png"));
		JLabel transfer = new JLabel(transferIcon);
		transfer.setPreferredSize(new Dimension(200, 100));
		tabs.setTabComponentAt(4,transfer);

		ImageIcon updateIcon = new ImageIcon(getClass().getResource("images/icons/update.png"));
		JLabel update = new JLabel(updateIcon);
		update.setPreferredSize(new Dimension(200, 100));
		tabs.setTabComponentAt(5,update);

		ImageIcon deleteicon = new ImageIcon(getClass().getResource("images/icons/delete.png"));
		JLabel delete = new JLabel(deleteicon);
		delete.setPreferredSize(new Dimension(200, 100));
		tabs.setTabComponentAt(6,delete);


		c.add(tabs);

//#####################################  PANELS  ############################################################################



		//************************************* Home Panel *************************************

		JLabel homeLabel = new JLabel("HOME");
		homeLabel.setBounds(250,20, 400, 50);
		homeLabel.setFont(new Font("Gotham",Font.BOLD,45));
		homePanel.add(homeLabel);

			// Name ###########################
		JPanel namePanel = new JPanel();
		namePanel.setLayout(null);
		namePanel.setBounds(15,100,700, 50);
		namePanel.setBackground(homePanelColor);
		homePanel.add(namePanel);
			
		JLabel nameLabel = new JLabel("Full Name:");
		nameLabel.setBounds(30, 0, 200,50);
		nameLabel.setFont(new Font("Gotham",Font.BOLD,22));
		namePanel.add(nameLabel);

		infoName = new JLabel(user.getFirstName()+" "+user.getLastName());
		infoName.setBounds(250,0,500,50);
		infoName.setFont(new Font("Gotham",Font.BOLD,18));
		infoName.setFont(new Font("Gotham",Font.BOLD,22));
		namePanel.add(infoName); 
		
		 //Username ###########################


		JPanel usernamePanel = new JPanel();
		usernamePanel.setLayout(null);
		usernamePanel.setBounds(15,175,700, 50);
		usernamePanel.setBackground(homePanelColor);
		homePanel.add(usernamePanel);

		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(30, 0, 200,50);
		usernameLabel.setFont(new Font("Gotham",Font.BOLD,22));
		usernamePanel.add(usernameLabel);

		infoUsername = new JLabel(user.getUsername());
		infoUsername.setBounds(250,0,300,50);
		infoUsername.setFont(new Font("Gotham",Font.BOLD,22));
		usernamePanel.add(infoUsername); 

			//Balance ###########################

		JPanel balancePanel = new JPanel();
		balancePanel.setLayout(null);
		balancePanel.setBounds(15,250,700, 50);
		balancePanel.setBackground(homePanelColor);
		homePanel.add(usernamePanel);

		JLabel balanceLabel = new JLabel("Balance:");
		balanceLabel.setBounds(30, 0, 200,50);
		balanceLabel.setFont(new Font("Gotham",Font.BOLD,22));
		balancePanel.add(balanceLabel);
		homePanel.add(balancePanel);

		infoBalance = new JLabel(""+user.getBalance());
		infoBalance.setBounds(250,0,300,50);
		infoBalance.setFont(new Font("Gotham",Font.BOLD,22));
		balancePanel.add(infoBalance);
			
			//Email ###########################

		JPanel emailPanel = new JPanel();
		emailPanel.setLayout(null);
		emailPanel.setBounds(15,325,700, 50);
		emailPanel.setBackground(homePanelColor);
		homePanel.add(emailPanel);

		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setBounds(30, 0, 200,50);
		emailLabel.setFont(new Font("Gotham",Font.BOLD,22));
		emailPanel.add(emailLabel);

		infoEmail = new JLabel(user.getEmail());
		infoEmail.setBounds(250,0,500,50);
		infoEmail.setFont(new Font("Gotham",Font.BOLD,22));
		emailPanel.add(infoEmail);

			//Phone ###########################

		JPanel phonePanel = new JPanel();
		phonePanel.setLayout(null);
		phonePanel.setBounds(15,400,700, 50);
		phonePanel.setBackground(homePanelColor);
		homePanel.add(phonePanel);

		JLabel phoneLabel = new JLabel("Phone:");
		phoneLabel.setBounds(30, 0, 200,50);
		phoneLabel.setFont(new Font("Gotham",Font.BOLD,22));
		phonePanel.add(phoneLabel);



		infoPhone = new JLabel(user.getPhone());
		infoPhone.setBounds(250,0,300,50);
		infoPhone.setFont(new Font("Gotham",Font.BOLD,22));
		phonePanel.add(infoPhone);

			// Address ###########################

		JPanel addressPanel = new JPanel();
		addressPanel.setLayout(null);
		addressPanel.setBounds(15,475,700, 50);
		addressPanel.setBackground(homePanelColor);
		homePanel.add(addressPanel);

		JLabel addressLabel = new JLabel("Address:");
		addressLabel.setBounds(30, 0, 200,50);
		addressLabel.setFont(new Font("Gotham",Font.BOLD,22));
		addressPanel.add(addressLabel);


		infoAddress = new JLabel(user.getAddress());
		infoAddress.setBounds(250,0,300,50);
		infoAddress.setFont(new Font("Gotham",Font.BOLD,22));
		addressPanel.add(infoAddress);

			// Date Of Birth ###########################

		JPanel dobPanel = new JPanel();
		dobPanel.setLayout(null);
		dobPanel.setBounds(15,550,700, 50);
		dobPanel.setBackground(homePanelColor);
		homePanel.add(dobPanel);

		JLabel dobLabel = new JLabel("Date of Birth:");
		dobLabel.setBounds(30, 0, 200,50);
		dobLabel.setFont(new Font("Gotham",Font.BOLD,22));
		dobPanel.add(dobLabel);

		infoDateOfBirth = new JLabel(user.getDateOfBirth());
		infoDateOfBirth.setBounds(250,0,300,50);
		infoDateOfBirth.setFont(new Font("Gotham",Font.BOLD,22));
		dobPanel.add(infoDateOfBirth);
		
			//Gender ###########################

		JPanel genderPanel = new JPanel();
		genderPanel.setLayout(null);
		genderPanel.setBounds(15,625,700, 50);
		genderPanel.setBackground(homePanelColor);
		homePanel.add(genderPanel);

		JLabel genderLabel = new JLabel("Gender:");
		genderLabel.setBounds(30, 0, 200,50);
		genderLabel.setFont(new Font("Gotham",Font.BOLD,22));
		genderPanel.add(genderLabel);

		infoGender = new JLabel(user.getGender());
		infoGender.setBounds(250,0,300,50);
		infoGender.setFont(new Font("Gotham",Font.BOLD,22));
		genderPanel.add(infoGender);

		//************************************* History Panel ************************************* 

		JLabel historyLabel = new JLabel("HISTORY");
		historyLabel.setBounds(200,20, 400, 50);
		historyLabel.setFont(new Font("Gotham",Font.BOLD,45));
		historyPanel.add(historyLabel);

		String[] columnName = {"Events", "Amount", "Date & Time"};
		Vector<String[]> records= user.getRecords();
		String[][] userRecords = new String[records.size()][3];
		int j=0;
		for(int i= (records.size()-1); i>=0; i--)
		{
			userRecords[j] = records.get(i);  j++;
		}
		historyTable = new JTable(userRecords,columnName);
		historyTable.setFont(new Font("Gotham",Font.BOLD,15)); 
		historyTable.setRowHeight(50);
		historyTable.getTableHeader().setFont(new Font("Gotham",Font.BOLD,18));
		historyTable.getTableHeader().setBackground(backgroundColor);
		scrollPane = new JScrollPane(historyTable);
		scrollPane.setBounds(8,100,715,615);
		historyPanel.add(scrollPane);

		//************************************* Withdraw Panel ************************************* 

		JPanel topWithdrawPanel = new JPanel();
		topWithdrawPanel.setLayout(null);
		topWithdrawPanel.setBounds (15,100,700, 610);
		topWithdrawPanel.setBackground(new Color (204,229,255));
		withdrawPanel.add(topWithdrawPanel);

		JLabel withdrawLabel = new JLabel("WITHDRAW");
		withdrawLabel.setBounds(200,20, 700, 50);
		withdrawLabel.setFont(new Font("Gotham",Font.BOLD,45));
		withdrawPanel.add(withdrawLabel);

		withdrawAmountLabel = new JLabel("Enter Amount to Withdraw: ");
		withdrawAmountLabel.setFont(new Font("Gotham",Font.BOLD,25));
		withdrawAmountLabel.setBounds(150, 150, 500, 100);
		topWithdrawPanel.add(withdrawAmountLabel);

		withdrawText = new JTextField();
		withdrawText.setFont(textFont);
		withdrawText.setHorizontalAlignment(JTextField.CENTER);
		withdrawText.setBounds(100,250,500,50);
		topWithdrawPanel.add(withdrawText);

		withdrawOk = new JButton("Withdraw");
		withdrawOk.setBounds(230, 350, 200,50);
		withdrawOk.setForeground(Color.WHITE);
		withdrawOk.setBackground(Color.BLACK);
		withdrawOk.setFont(new Font("Gotham",Font.BOLD,18));
		topWithdrawPanel.add(withdrawOk);

		JLabel withdrawErrorLabel = new JLabel("");
		withdrawErrorLabel.setBounds(250, 300, 300, 50);
		topWithdrawPanel.add(withdrawErrorLabel);

		withdrawMessage = new JLabel("");
		withdrawMessage.setBounds(150,50, 500,50);
		withdrawMessage.setFont(new Font("Gotham",Font.BOLD,22));
		topWithdrawPanel.add(withdrawMessage);



		//************************************* Deposit Panel ************************************* 

		JPanel topDepositPanel = new JPanel();
		topDepositPanel.setLayout(null);
		topDepositPanel.setBounds (15,100,700, 610);
		topDepositPanel.setBackground(new Color(204,255,204));
		depositPanel.add(topDepositPanel);

		JLabel depositLabel = new JLabel("DEPOSIT");
		depositLabel.setBounds(200,20, 700, 50);
		depositLabel.setFont(new Font("Gotham",Font.BOLD,45));
		depositPanel.add(depositLabel);

		depositAmountLabel = new JLabel("Enter Amount to Deposit: ");
		depositAmountLabel.setFont(new Font("Gotham",Font.BOLD,25));
		depositAmountLabel.setBounds(150, 150, 500, 100);
		topDepositPanel.add(depositAmountLabel);

		depositText = new JTextField();
		depositText.setFont(textFont);
		depositText.setHorizontalAlignment(JTextField.CENTER);
		depositText.setBounds(100,250,500,50);
		topDepositPanel.add(depositText);

		depositOk = new JButton("Deposit");
		depositOk.setBounds(230, 350, 200,50);
		depositOk.setForeground(Color.WHITE);
		depositOk.setBackground(Color.BLACK);
		depositOk.setFont(new Font("Gotham",Font.BOLD,18));
		topDepositPanel.add(depositOk);

		JLabel depositErrorLabel = new JLabel("");
		depositErrorLabel.setBounds(250, 300, 300, 50);
		topDepositPanel.add(depositErrorLabel);

		depositMessage = new JLabel("");
		depositMessage.setBounds(150,50, 500,50);
		depositMessage.setFont(new Font("Gotham",Font.BOLD,22));
		topDepositPanel.add(depositMessage);


	//************************************* Transfer Panel ************************************* 

		JPanel toptransferPanel = new JPanel();
		toptransferPanel.setLayout(null);
		toptransferPanel.setBounds (15,100,700, 610);
		toptransferPanel.setBackground(new Color(255,204,229));
		transferPanel.add(toptransferPanel);

		JLabel transferLabel = new JLabel("TRANSFER");
		transferLabel.setBounds(200,20, 700, 50);
		transferLabel.setFont(new Font("Gotham",Font.BOLD,45));
		transferPanel.add(transferLabel);


		transferAccontLabel = new JLabel("Enter Account username:");
		transferAccontLabel.setFont(new Font("Gotham",Font.BOLD,25));
		transferAccontLabel.setBounds(150, 125, 500, 100);
		toptransferPanel.add(transferAccontLabel);

		transferAccountText = new JTextField();
		transferAccountText.setFont(textFont);
		transferAccountText.setHorizontalAlignment(JTextField.CENTER);
		transferAccountText.setBounds(100,200,500,50);
		toptransferPanel.add(transferAccountText);


		transferAmountLabel = new JLabel("Enter Amount to transfer: ");
		transferAmountLabel.setFont(new Font("Gotham",Font.BOLD,25));
		transferAmountLabel.setBounds(150, 275, 500, 100);
		toptransferPanel.add(transferAmountLabel);

		transferAmountText = new JTextField();
		transferAmountText.setFont(textFont);
		transferAmountText.setHorizontalAlignment(JTextField.CENTER);
		transferAmountText.setBounds(100,350,500,50);
		toptransferPanel.add(transferAmountText);

		transferOk = new JButton("Transfer");
		transferOk.setBounds(230, 450, 200,50);
		transferOk.setForeground(Color.WHITE);
		transferOk.setBackground(Color.BLACK);
		transferOk.setFont(new Font("Gotham",Font.BOLD,18));
		toptransferPanel.add(transferOk);

		JLabel transferErrorLabel_1 = new JLabel("");
		transferErrorLabel_1.setBounds(250, 400, 300, 50);
		toptransferPanel.add(transferErrorLabel_1);

		JLabel transferErrorLabel_2 = new JLabel("");
		transferErrorLabel_2.setBounds(250, 250, 300, 50);
		toptransferPanel.add(transferErrorLabel_2);

		transferMessage = new JLabel("");
		transferMessage.setBounds(100,50, 500,50);
		transferMessage.setFont(new Font("Gotham",Font.BOLD,20));
		toptransferPanel.add(transferMessage);


		//*************************************  Update Panel ************************************* 

		JLabel updateLabel = new JLabel("UPDATE");
		updateLabel.setBounds(200,20, 400, 50);
		updateLabel.setFont(new Font("Gotham",Font.BOLD,45));
		updatePanel.add(updateLabel);
	
		Font updateFont = new Font("Gotham",Font.BOLD,20);
		Font erroeUpdateFont = new Font("Ariel", Font.ITALIC+Font.BOLD,12);
		
		// Name ###########################
		JPanel nameUpdatePanel = new JPanel();
		nameUpdatePanel.setLayout(null);
		nameUpdatePanel.setBounds(15,100,700, 50);
		nameUpdatePanel.setBackground(updatePanelColor);
		updatePanel.add(nameUpdatePanel);
			
		JLabel nameUpdateLabel = new JLabel("Change Name:");
		nameUpdateLabel.setBounds(30, 0, 200,50);
		nameUpdateLabel.setFont(new Font("Gotham",Font.BOLD,18));
		nameUpdatePanel.add(nameUpdateLabel);

		JLabel firstNameError = new JLabel("");
		firstNameError.setBounds(270, 145, 200,25);
		firstNameError.setFont(erroeUpdateFont);
		updatePanel.add(firstNameError);

		JLabel lastNameError = new JLabel("");
		lastNameError.setBounds(495, 145, 200,25);
		lastNameError.setFont(erroeUpdateFont);
		updatePanel.add(lastNameError);

		JTextField firstNameUpdateText = new JTextField(user.getFirstName());
		firstNameUpdateText.setBounds(250,5,175,40);
		firstNameUpdateText.setHorizontalAlignment(JTextField.CENTER);
		firstNameUpdateText.setFont(new Font("Gotham",Font.ITALIC,18));

		JTextField lastNameUpdateText = new JTextField(user.getLastName());
		lastNameUpdateText.setHorizontalAlignment(JTextField.CENTER);
		lastNameUpdateText.setBounds(475,5,175,40);
		lastNameUpdateText.setFont(new Font("Gotham",Font.ITALIC,18));

		nameUpdatePanel.add(firstNameUpdateText); 
		nameUpdatePanel.add(lastNameUpdateText);


		//Email ###########################

		JPanel emailUpdatePanel = new JPanel();
		emailUpdatePanel.setLayout(null);
		emailUpdatePanel.setBounds(15,175,700, 50);
		emailUpdatePanel.setBackground(updatePanelColor);
		updatePanel.add(emailUpdatePanel);

		JLabel emailUpdateLabel = new JLabel("Change Email:");
		emailUpdateLabel.setBounds(30, 0, 200,50);
		emailUpdateLabel.setFont(new Font("Gotham",Font.BOLD,18));
		emailUpdatePanel.add(emailUpdateLabel);

		JLabel emailErrorLabel = new JLabel("");
		emailErrorLabel.setBounds(270, 220, 200,25);
		emailErrorLabel.setFont(erroeUpdateFont);
		updatePanel.add(emailErrorLabel);

		JTextField updateEmailText = new JTextField(user.getEmail());
		updateEmailText.setHorizontalAlignment(JTextField.CENTER);
		updateEmailText.setBounds(250,5,400,40);
		updateEmailText.setFont(new Font("Gotham",Font.ITALIC,22));
		emailUpdatePanel.add(updateEmailText);


		//Phone ###########################

		JPanel phoneUpdatePanel = new JPanel();
		phoneUpdatePanel.setLayout(null);
		phoneUpdatePanel.setBounds(15,250,700, 50);
		phoneUpdatePanel.setBackground(updatePanelColor);
		updatePanel.add(phoneUpdatePanel);

		JLabel phoneUpdateLabel = new JLabel("Change Phone:");
		phoneUpdateLabel.setBounds(30, 0, 200,50);
		phoneUpdateLabel.setFont(new Font("Gotham",Font.BOLD,18));
		phoneUpdatePanel.add(phoneUpdateLabel);

		JLabel phoneErrorLabel = new JLabel("");
		phoneErrorLabel.setBounds(270, 295, 200,25);
		phoneErrorLabel.setFont(erroeUpdateFont);
		updatePanel.add(phoneErrorLabel);

		JTextField phoneUpdateText = new JTextField(user.getPhone());
		phoneUpdateText.setBounds(250,5,400,40);
		phoneUpdateText.setHorizontalAlignment(JTextField.CENTER);
		phoneUpdateText.setFont(new Font("Gotham",Font.ITALIC,22));
		phoneUpdatePanel.add(phoneUpdateText);


			// Address ###########################

		JPanel addressUpdatePanel = new JPanel();
		addressUpdatePanel.setLayout(null);
		addressUpdatePanel.setBounds(15,325,700, 50);
		addressUpdatePanel.setBackground(updatePanelColor);
		updatePanel.add(addressUpdatePanel);

		JLabel addressUpdateLabel = new JLabel("Change Address:");
		addressUpdateLabel.setBounds(30, 0, 200,50);
		addressUpdateLabel.setFont(new Font("Gotham",Font.BOLD,18));
		addressUpdatePanel.add(addressUpdateLabel);

		JLabel addressErrorLabel = new JLabel("");
		addressErrorLabel.setBounds(270, 370, 200,25);
		addressErrorLabel.setFont(erroeUpdateFont);
		updatePanel.add(addressErrorLabel);


		JTextField addressUpdateText = new JTextField(user.getAddress());
		addressUpdateText.setHorizontalAlignment(JTextField.CENTER);
		addressUpdateText.setBounds(250,5,400,40);
		addressUpdateText.setFont(new Font("Gotham",Font.ITALIC,22));
		addressUpdatePanel.add(addressUpdateText);


			// Date Of Birth ###########################

		JPanel dobUPanel = new JPanel();
		dobUPanel.setLayout(null);
		dobUPanel.setBounds(15,400,700, 50);
		dobUPanel.setBackground(updatePanelColor);
		updatePanel.add(dobUPanel);

		JLabel dobULabel = new JLabel("Change Birthday:");
		dobULabel.setBounds(30, 0, 300,50);
		dobULabel.setFont(new Font("Gotham",Font.BOLD,18));
		dobUPanel.add(dobULabel);

		JLabel dobErrorLabel = new JLabel("");
		dobErrorLabel.setBounds(270, 445, 200,25);
		dobErrorLabel.setFont(erroeUpdateFont);
		updatePanel.add(dobErrorLabel);

		JTextField dobUpdateText = new JTextField(user.getDateOfBirth());
		dobUpdateText.setHorizontalAlignment(JTextField.CENTER);
		dobUpdateText.setBounds(250,5,400,40);
		dobUpdateText.setFont(new Font("Gotham",Font.ITALIC,22));
		dobUPanel.add(dobUpdateText);

		//Gender ###########################

		JPanel genderUpdatePanel = new JPanel();
		genderUpdatePanel.setLayout(null);
		genderUpdatePanel.setBounds(15,475,700, 50);
		genderUpdatePanel.setBackground(updatePanelColor);
		updatePanel.add(genderUpdatePanel);

		JLabel genderUpdateLabel = new JLabel("Change Gender:");
		genderUpdateLabel.setBounds(30, 0, 200,50);
		genderUpdateLabel.setFont(new Font("Gotham",Font.BOLD,18));
		genderUpdatePanel.add(genderUpdateLabel);

		JLabel genderErrorLabel = new JLabel("");
		genderErrorLabel.setBounds(270, 520, 200,25);
		updatePanel.add(genderErrorLabel);

		JRadioButton maleRadio = new JRadioButton("Male");
		maleRadio.setBounds(250, 0, 60,50);
		maleRadio.setBackground(updatePanelColor);
		genderUpdatePanel.add(maleRadio);
		JRadioButton femaleRadio = new JRadioButton("Female");
		femaleRadio.setBounds(400, 0, 100,50);
		femaleRadio.setBackground(updatePanelColor);
		genderUpdatePanel.add(femaleRadio);

		JRadioButton otherRadio = new JRadioButton("Other");
		otherRadio.setBounds(550, 0, 100,50);
		otherRadio.setBackground(updatePanelColor);
		genderUpdatePanel.add(otherRadio);

		if((user.getGender()).equals("Male"))
		{
			maleRadio.setSelected(true);
		}
		else if((user.getGender()).equals("Female"))
		{
			femaleRadio.setSelected(true);
		}
		else{
			otherRadio.setSelected(true);
		}

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(maleRadio);
		buttonGroup.add(femaleRadio);
		buttonGroup.add(otherRadio);
	

		//****************** Update Password  ******************
		JPanel passwordUpdatePanel = new JPanel();
		passwordUpdatePanel.setLayout(null);
		passwordUpdatePanel.setBounds(15,550,700, 50);
		passwordUpdatePanel.setBackground(updatePanelColor);
		updatePanel.add(passwordUpdatePanel);

		JLabel passwordUpdatelabel = new JLabel("Change Password:");
		passwordUpdatelabel.setBounds(30, 0, 250,50);
		passwordUpdatelabel.setFont(new Font("Gotham",Font.BOLD,18));
		passwordUpdatePanel.add(passwordUpdatelabel);

		JLabel passErrorLabel = new JLabel("");
		passErrorLabel.setBounds(270, 595, 200,25);
		passErrorLabel.setFont(erroeUpdateFont);
		updatePanel.add(passErrorLabel);

		JPasswordField updatePasswordText = new JPasswordField(user.getPassword());
		updatePasswordText.setHorizontalAlignment(JTextField.CENTER);
		updatePasswordText.setBounds(250,5,400,40);
		updatePasswordText.setFont(new Font("Gotham",Font.ITALIC,22));
		passwordUpdatePanel.add(updatePasswordText);
		
		
		JLabel updateLabelForPassword = new JLabel("Enter password:");
		updateLabelForPassword.setBounds(20,640,200,50);
		updateLabelForPassword.setFont(new Font("Gotham",Font.BOLD,18));
		updatePanel.add(updateLabelForPassword);

		JLabel oldPassError = new JLabel("");
		oldPassError.setBounds(240,680,200,50);
		oldPassError.setFont(erroeUpdateFont);
		updatePanel.add(oldPassError);

		JPasswordField passText = new JPasswordField();
		passText.setHorizontalAlignment(JTextField.CENTER);
		passText.setFont(new Font("Gotham",Font.ITALIC,22));
		passText.setBounds(220,640,310,50);
		updatePanel.add(passText);

		JLabel updatable = new JLabel("");
		updatable.setBounds(550,680, 200,50);
		updatePanel.add(updatable);

		JButton updateButton = new JButton("UPDATE");
		updateButton.setBounds(550,640, 150,50);
		updateButton.setBackground(new Color(153,76,0));
		updateButton.setForeground(Color.WHITE);
		updateButton.setFont(new Font("Gotham",Font.ITALIC+Font.BOLD,22));

		updatePanel.add(updateButton);


		//************************************* Delete Panel ************************************* 

			JPanel topDeletePanel = new JPanel();
		topDeletePanel.setLayout(null);
		topDeletePanel.setBounds (15,100,700, 610);
		topDeletePanel.setBackground(new Color(255,204,204));
		deletePanel.add(topDeletePanel);

		JLabel deleteLabel = new JLabel("DELETE");
		deleteLabel.setBounds(200,20, 700, 50);
		deleteLabel.setFont(new Font("Gotham",Font.BOLD,45));
		deletePanel.add(deleteLabel);

		JLabel deleteTextLabel = new JLabel("Enter password to Confirm: ");
		deleteTextLabel.setFont(new Font("Gotham",Font.BOLD,25));
		deleteTextLabel.setBounds(150, 150, 500, 100);
		topDeletePanel.add(deleteTextLabel);

		deletePass = new JPasswordField();
		deletePass.setFont(textFont);
		deletePass.setHorizontalAlignment(JTextField.CENTER);
		deletePass.setBounds(100,250,500,50);
		topDeletePanel.add(deletePass);

		deleteOk = new JButton("Delete");
		deleteOk.setBounds(230, 350, 200,50);
		deleteOk.setForeground(Color.WHITE);
		deleteOk.setBackground(Color.BLACK);
		deleteOk.setFont(new Font("Gotham",Font.BOLD,18));
		topDeletePanel.add(deleteOk);

		JLabel deleteErrorLabel = new JLabel("");
		deleteErrorLabel.setBounds(250, 300, 300, 50);
		topDeletePanel.add(deleteErrorLabel);



	//_________________________________________ PANEL ENDS  ______________________________________________________________________________

	

		JButton zero = new JButton();  // Captures first Button
		zero.setBounds(0,0,0,0);
		c.add(zero);


		JButton refreshButton = new JButton("Refresh");
		refreshButton.setBounds(425,850,150,50);
		refreshButton.setFont(new Font("Gotham",Font.BOLD,25));
		refreshButton.setForeground(Color.WHITE);
		refreshButton.setBackground(new Color(0,153,0));
		c.add(refreshButton);	


		//Logout Button *************************************************************************

		buttonLogOut = new JButton("Logout");
		buttonLogOut.setBounds(800,25, 150,50);
		buttonLogOut.setBackground(Color.RED);
		buttonLogOut.setForeground(Color.WHITE);
		buttonLogOut.setFont(new Font("Gotham",Font.BOLD,25));
		c.add(buttonLogOut);

		buttonLogOut.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				Point point = getLocation();
				int x = (int)point.getX(); int y = (int)point.getY();
				MainPage main = new MainPage(x,y);
				main.setVisible(true);
				dispose();


			}
		});


		refreshButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				Point point = getLocation();
				int x = (int)point.getX(); int y = (int)point.getY();
				
				UserPage main = new UserPage(user,x,y);
				main.setVisible(true);
				dispose();


			}
		});


		updateButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{					Color greenColor = new Color(0,153,0);
				Color redColor = new Color(204,0,0);

				/// ****************** INPUTS *****************************
				String firstName = firstNameUpdateText.getText();
				String lastName = lastNameUpdateText.getText();
				String email = updateEmailText.getText();
				Matcher matcher = (Pattern.compile("^(.+)@(.+)$")).matcher(email);
				String phone = phoneUpdateText.getText();
				String address = addressUpdateText.getText();
				String dateOfBirth = dobUpdateText.getText();
			 	String newPassword = String.valueOf(updatePasswordText.getPassword());
			 	String password = String.valueOf(passText.getPassword());
				String gender;
				passText.setText("");

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

				 if((user.getFirstName()).equals(firstName) && (user.getLastName()).equals(lastName) && (user.getEmail()).equals(email) && (user.getPhone()).equals(phone) && (user.getAddress()).equals(address) && (user.getDateOfBirth()).equals(dateOfBirth) && (user.getGender()).equals(gender) && (user.getPassword()).equals(newPassword) && (user.getPassword()).equals(password))
				 {

				 	oldPassError.setText("");
				 	firstNameError.setText("");
				 	lastNameError.setText("");
				 	emailErrorLabel.setText("");
				 	phoneErrorLabel.setText("");
				 	addressErrorLabel.setText("");
				 	dobErrorLabel.setText("");
				 	genderErrorLabel.setText("");
				 	passErrorLabel.setText("");
				 	JOptionPane.showMessageDialog(null, "Nothing has been changed!", "Not updated", -1);
				 }
				 else
				 {
				 	
					//************************************************
					if(!(firstName.equals("")) && !(lastName.equals("")) && !(email.equals("")) && !(phone.equals("")) && !(address.equals("")) && !(dateOfBirth.equals("")) && !(password.equals("")) && password.length()>=8 && matcher.matches())
					{
						 if((user.getPassword()).equals(password))
						 {
						 	oldPassError.setText("");
						 	

						 	//Update labels************************************** 
						 	if((user.getFirstName()).equals(firstName))
						 	{
						 		firstNameError.setText("");
						 	}
						 	else
						 	{	user.changeFirstName(firstName);
						 		firstNameError.setText("First name updated");
						 		firstNameError.setForeground(greenColor);
						 	}
						 	if((user.getLastName()).equals(lastName))
						 	{
						 		lastNameError.setText("");
						 	}
						 	else
						 	{	user.changeLastName(lastName);
						 		lastNameError.setText("Last name updated");
						 		lastNameError.setForeground(greenColor);
						 	}
						 	if((user.getEmail()).equals(email))
						 	{
						 		emailErrorLabel.setText("");
						 	}
						 	else
						 	{	
						 		user.changeEmail(email);
						 		emailErrorLabel.setText("Email updated");
						 		emailErrorLabel.setForeground(greenColor);
						 	}
  						 	if((user.getPhone()).equals(phone))
						 	{
						 		phoneErrorLabel.setText("");
						 	}
						 	else
						 	{
						 		user.changePhone(phone);
						 		phoneErrorLabel.setText("Phone no updated");
						 		phoneErrorLabel.setForeground(greenColor);	
						 	}
						 	if((user.getAddress()).equals(address))
						 	{
						 		addressErrorLabel.setText("");
						 	}
						 	else
						 	{
						 		user.changeAddress(address);
						 		addressErrorLabel.setText("Address updated");
						 		addressErrorLabel.setForeground(greenColor);
						 	}
						 	if((user.getDateOfBirth()).equals(dateOfBirth))
						 	{
						 		dobErrorLabel.setText("");
						 	}
						 	else
						 	{
						 		user.changeDateOfBirth(dateOfBirth);
						 		dobErrorLabel.setText("Date of Birth Updated");
						 		dobErrorLabel.setForeground(greenColor);

						 	}

						 	if((user.getGender()).equals(gender))
						 	{
						 		genderErrorLabel.setText("");
						 	}
						 	else
						 	{
						 		user.changeGender(gender);
						 		genderErrorLabel.setText("Gender updated");
						 		genderErrorLabel.setForeground(greenColor);
						 	}

						 	if((user.getPassword()).equals(newPassword))
						 	{
						 		passErrorLabel.setText("");
						 	}
						 	else
						 	{
						 		user.changePassword(newPassword);
						 		passErrorLabel.setText("Password updated");
						 		passErrorLabel.setForeground(greenColor);	
						 	}


					 	//************************************************************************
						 
						 	JOptionPane.showMessageDialog(null, "Account successfully updated!\n\tRefresh the page.", "Updated", -1);
						 	LocalDateTime unformatedDate = LocalDateTime.now();
						    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
						    String date = unformatedDate.format(format);
							String[] record = {"Account Updated", "", date};
							user.addRecord(record);
							user.saveFile();
						 
						 }
						 else
						 {
						 	oldPassError.setText("Wrong Password");
						 }
					}
					else
					{
						
					 	if(firstName.equals(""))
					 	{
					 		firstNameError.setText("Empty first name");
					 		firstNameError.setForeground(redColor);
					 	}
					 	else{
					 		firstNameError.setText("");
					 	}

					 	if(lastName.equals(""))
					 	{
					 		lastNameError.setText("Empty last name");
					 		lastNameError.setForeground(redColor);
					 	}
					 	else
				 		{
					 		lastNameError.setText("");
					 	}
					 	if(email.equals(""))
					 	{
					 		emailErrorLabel.setText("Empty email");
					 		emailErrorLabel.setForeground(redColor);
					 	}
					 	else if(!(matcher.matches()))
					 	{
					 		emailErrorLabel.setText("Invalid Email format");
					 		emailErrorLabel.setForeground(redColor);
					 	}
					 	else
				 		{
					 		emailErrorLabel.setText("");
					 	}
					 	if(phone.equals(""))
					 	{
					 		phoneErrorLabel.setText("Empty phone no");
					 		phoneErrorLabel.setForeground(redColor);
					 	}
					 	else
					 	{
					 		phoneErrorLabel.setText("");
					 	}
					 	if(address.equals(""))
					 	{
					 		phoneErrorLabel.setText("Empty address");
					 		phoneErrorLabel.setForeground(redColor);
					 	}
					 	else
					 	{
					 		addressErrorLabel.setText("");
					 	}
					 	if(dateOfBirth.equals(""))
					 	{
					 		dobErrorLabel.setText("Empty date of birth");
					 		dobErrorLabel.setForeground(redColor);
					 	}
					 	else
				 		{
					 		dobErrorLabel.setText("");
					 	}
					 	if(newPassword.equals(""))
					 	{
					 		passErrorLabel.setText("Empty Password");
					 		passErrorLabel.setForeground(redColor);
					 	}
					 	else if(newPassword.length()<8)
					 	{
					 		passErrorLabel.setText("Password should have at least 8 characters");
					 		passErrorLabel.setForeground(redColor);	
					 	}
					 	else
				 		{
					 		passErrorLabel.setText("");
					 	}
					 	if(password.equals("") || !(user.getPassword()).equals(password))
					 	{
					 		oldPassError.setText("Wrong Password");
					 		oldPassError.setForeground(redColor);
					 	}
					 	else
					 	{
					 		oldPassError.setText("");	
					 	}

					}


				 }


			}
		});






		//Buttons

		withdrawOk.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				try{
					double amount = Double.parseDouble(withdrawText.getText()); 
					withdrawErrorLabel.setText("");
					if(user.getBalance()>=amount)
					{
						user.withdraw(amount);
						withdrawMessage.setText(amount+" Taka withdraw successful!");
						infoBalance.setText(""+user.getBalance());
						withdrawText.setText("");
						//

						LocalDateTime unformatedDate = LocalDateTime.now();
					    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
					    String date = unformatedDate.format(format);
						//
						String[] record = {"Withdraw", ""+amount, date.toString()};
						user.addRecord(record);
						user.saveFile();
					}
					else{
						withdrawMessage.setText("");
						withdrawErrorLabel.setText("Insufficient balance");
						withdrawErrorLabel.setForeground(Color.RED);
					}
				} 
				catch(Exception ex)
				{
					withdrawMessage.setText("");
					withdrawErrorLabel.setText("Invalid amount");
					withdrawErrorLabel.setForeground(Color.RED);
				}
				

			}
		});

		depositOk.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{	try{
					double amount = Double.parseDouble(depositText.getText()); 
					user.deposit(amount);

					depositMessage.setText(amount+" Taka deposit successful!");
					infoBalance.setText(""+user.getBalance());
					depositText.setText("");
					depositErrorLabel.setText("");


					LocalDateTime unformatedDate = LocalDateTime.now();
				    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
				    String date = unformatedDate.format(format);
					String[] record = {"Deposit", ""+amount, date.toString()};
					user.addRecord(record);
	 				user.saveFile();
 				}
 				catch(Exception ex)
 				{
 					depositMessage.setText("");
 					depositErrorLabel.setText("Invalid amount");
					depositErrorLabel.setForeground(Color.RED);
 				}
			}

	});

		transferOk.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				Username username = new Username(transferAccountText.getText());
				
				try{
					double amount = Double.parseDouble(transferAmountText.getText()); 
					if(username.exists() && !((username.get()).equals(user.getUsername())))
					{	
						transferErrorLabel_1.setText("");
						transferErrorLabel_2.setText("");
						User tuser;
						try{
							ObjectInputStream file = new ObjectInputStream(new FileInputStream("users/"+username.get()+".dat"));
							tuser = (User)file.readObject();
						
							if(user.getBalance()>=amount)
							{
								transferAccountText.setText("");
								transferAmountText.setText("");
								transferErrorLabel_1.setText("");
								transferErrorLabel_2.setText("");
								user.withdraw(amount);
								tuser.deposit(amount);
								transferMessage.setText(amount+" Taka transfer to "+tuser.getUsername()+" successful!");
								infoBalance.setText(""+user.getBalance());
								LocalDateTime unformatedDate = LocalDateTime.now();
							    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
							    String date = unformatedDate.format(format);
								String[] userRecord = {"Transfer to "+tuser.getUsername(), ""+amount, date.toString()};
								String[] tUserRecord = {"Transfer from "+user.getUsername(), ""+amount, date.toString()};
								user.addRecord(userRecord);
								tuser.addRecord(tUserRecord);
								user.saveFile();
								tuser.saveFile();
							}
							else
							{
								transferErrorLabel_1.setText("Insufficient balance!");
								transferErrorLabel_1.setForeground(Color.RED);
							}
								
							
							
						}
						catch(Exception ex)
						{
							System.out.println("An error occured during Transfer");
							System.out.println(e.toString());
						} 
					
					}
					else
					{
						transferErrorLabel_1.setText("");
						transferErrorLabel_2.setText("Account Not found");
						transferErrorLabel_2.setForeground(Color.RED);
					}
						
				}
				catch(Exception ex1)
				{
					if(!username.exists())
					{
						transferErrorLabel_2.setText("Account Not found");
						transferErrorLabel_2.setForeground(Color.RED);
					}
					else
					{
						transferErrorLabel_2.setText("");
					}
					transferMessage.setText("");
					transferErrorLabel_1.setText("Invalid amount");
					transferErrorLabel_1.setForeground(Color.RED);
				}
					
			}

		});

		deleteOk.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				String password = String.valueOf(deletePass.getPassword());
				if(user.getPassword().equals(password))
				{
					user.deleteAccount();
					JOptionPane.showMessageDialog(null, "Account deleted!", "Delete", -1);
					Point point = getLocation();
					int x = (int)point.getX(); int y = (int)point.getY();
					MainPage main = new MainPage(x,y);
					main.setVisible(true);
					dispose();

				}
				else
				{
					deleteErrorLabel.setText("Wrong Password");
					deleteErrorLabel.setForeground(Color.RED);
				}
			}

	});

	}

}