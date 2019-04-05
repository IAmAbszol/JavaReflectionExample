package main;

public class Account {
	
	private String username = "";
	private String password = "";
	private double balance = 0.0;
	
	public Account(String username, String password, double balance) {
		this.username = username;
		this.password = password;
		this.balance = balance;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public boolean updateBalance(double balance, String auth) {
		if (auth == password) {
			this.balance = balance;
			return true;
		}
		return false;
	}
	

}
