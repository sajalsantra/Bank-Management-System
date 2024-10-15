package com.bank.customer;

import java.util.Scanner;


import com.process.ProcessUtil;

import config.Properties;
import dao.operation.DataStorePoint;

public class BankServerCust {
	Scanner sc = new Scanner(System.in);
	static DataStorePoint dsp;
	static CustomerRegistration cr = new CustomerRegistration();
	ProcessUtil pu = new ProcessUtil();
	CustOperation am = new CustOperation();
	Properties pts = new Properties();
	
	public void homePage() throws InterruptedException {
		
		System.out.println("===========================");
		System.out.println("Chose Your Service:");
		System.out.println("1. Create Account.");
		System.out.println("2. Deposit Amount.");
		System.out.println("3. Withdraw Money.");
		System.out.println("4. Balance Bhecking.");
		System.out.println("5. Exit");
		System.out.println("===========================");
		System.out.print("Enter Your Choice:");
		String input = sc.next();
		while(!pu.isValisNumber(input)) {
			System.out.print("Invalid Type Choice, Enter Valid Choice: ");
			input = sc.next();
		}
		int val = Integer.parseInt(input);
		switch (val) {
		case 1:
//			cr.customerRegister();
			System.out.println("You are not Authorize To Create Account!");
			Thread.sleep(pts.STAY_TIME_ERROR);
			homePage();
			break;
		case 2:
			am.depositeAmount();
			break;
		case 3:
			am.withdrawAmount();
			break;
		case 4:
			am.balanceChecking();
			break;
		case 5:
			pu.exit();
		default:
			System.out.println("Invalid Input, Try Again!");
			homePage();
		}
	}
}