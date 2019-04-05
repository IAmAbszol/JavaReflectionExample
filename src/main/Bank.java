package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Bank {
	
	private ArrayList<Account> accounts;
	
	public Bank() {
		accounts = new ArrayList<Account>();
	}
	/*
	 * Take accounts from database and load them into current bank.
	 */
	private void loadAccounts() {
		Character[] password = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		List<Character> passwordList = Arrays.asList(password);
		for(int i = 0; i < 10; i++) {
			Collections.shuffle(passwordList);
			String shuffled = passwordList.stream().map(e -> e.toString()).collect(Collectors.joining());
			accounts.add(new Account(Integer.toString(i), shuffled.substring(0, 5), 0));
		}
	}
	
	/*
	 * List accounts from bank.
	 */
	private void listAccounts() {
		Iterator<Account> iter = accounts.iterator();
		while(iter.hasNext()) {
			Account tmp = (Account)iter.next();
			System.out.format("%s - %s - %f\n", tmp.getUsername(), tmp.getPassword(), tmp.getBalance());
		}
		System.out.println("----------------------------");
	}
	
	/*
	 * Return all accounts.
	 */
	private ArrayList<Account> getAccounts() {
		return accounts;
	}

}
