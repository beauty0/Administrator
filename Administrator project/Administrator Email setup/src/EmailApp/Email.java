package EmailApp;

import java.util.Scanner;

public class Email {
	//declaring the object
	
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private int MailboxCapacity;
	private int defaultPasswordLength = 10;
	private String email;
	private String alternateEmail;
	private String companySuffix = "viewmetv.com";
	
	//we need constructor to recieve the firstname & lastname
	public Email(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
		
		System.out.println("Setting up new Worker:" + this.firstName + " " + this.lastName);
		
		//call a method asking for the dept - return deprt
		this.department = setDepartment();
	
		
		//call a method that returns randoms
		this.password = randompassWord(defaultPasswordLength);
		System.out.println("Your password is:" + this.password);
		
		//combine element to generate email
		email = firstName.toLowerCase() + ", " + lastName.toLowerCase() + "@" + department +"."+ companySuffix;
		
	}
	//ask for department
	private String setDepartment() {
		System.out.println(" Enter Department code below \n1 for Sales\n2 for Development\n3 for Production\n0 for None\nEnter Depart code:");
		Scanner in = new Scanner(System.in);
		int deptchoice = in.nextInt();
		if(deptchoice == 1 ) {return "sales";}
		else if(deptchoice == 2 ) {return "dev";}
		else if(deptchoice == 3 ) {return "Production";}
		else {return "";}
		
	}
	//Generate a random password
	private String randompassWord(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWSYZ123456789!@#$%";
		char[] password = new char[length];
		for(int i=0; i<length;i++) {
			int rand = (int)(Math.random()*passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	//set mailbox capacity
	
	public void setMailboxCapacity(int capacity) {
		this.MailboxCapacity = capacity;
	}
	//set the alternate email address
	public void setalternateEmail(String altemail) {
		this.alternateEmail = altemail;
	}
	//change password
	public void changePassword(String password) {
		this.password = password;
		
	}
	
	public int getMailboxCapacity() {return MailboxCapacity; }
	public String getAlternateEmail() {return alternateEmail; }
	public String getPassword() {return password; }
	
	public String showInfo() {
		return "Display Name; " + firstName + " " + lastName +
	             "\nCompany Email:" + email +
	             "\nMailBox CAPACITY:" + MailboxCapacity + "mb";
	}
}
