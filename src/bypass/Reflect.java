package bypass;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import main.Account;
import main.Bank;

public class Reflect {
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		
		/*
		 * Pre-existing knowledge
		 * Java's security manager is not set in place, we can safely access.
		 * If it were in place, we set it back to false.
		 */
		// Retrieve accounts
		Bank bank = new Bank();
		Class cl = bank.getClass();
		
		Method callAccounts = cl.getDeclaredMethod("loadAccounts");
		callAccounts.setAccessible(true);
		callAccounts.invoke(bank);
		callAccounts.setAccessible(false);
		
		Method listAccounts = cl.getDeclaredMethod("listAccounts");
		listAccounts.setAccessible(true);
		listAccounts.invoke(bank);
		listAccounts.setAccessible(false);
		
		Method getAccounts = cl.getDeclaredMethod("getAccounts");
		getAccounts.setAccessible(true);
		ArrayList<Account> accounts = (ArrayList<Account>) getAccounts.invoke(bank);
		getAccounts.setAccessible(false);
		
		// Up my balance =D
		Account myAccount = accounts.get(0);
		Class clAccount = myAccount.getClass();
		
		// Change the balance, I also forgot my password =[
		Field password = clAccount.getDeclaredField("password");
		password.setAccessible(true);
		password.set(myAccount, "bypass");
		password.setAccessible(false);
		
		Class<?> parameters[] = new Class[] { double.class, String.class };
		Method updateBalance = clAccount.getDeclaredMethod("updateBalance", parameters);
		updateBalance.invoke(myAccount, new Object[] { 100.0, "bypass" });
		
		listAccounts.setAccessible(true);
		listAccounts.invoke(bank);
		listAccounts.setAccessible(false);
		
		
	}

}
