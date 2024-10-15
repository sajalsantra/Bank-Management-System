package com.bank;

import java.util.Scanner;

import com.bank.customer.CustOperation;
import com.bank.customer.BankServerCust;
import com.bank.customer.CustomerRegistration;
import com.bank.employee.BankServerEmp;
import com.process.ProcessUtil;

import config.Properties;
import dao.operation.DataStorePoint;

public class BankServer {
	
	Scanner sc = new Scanner(System.in);
	static DataStorePoint dsp;
	static CustomerRegistration cr = new CustomerRegistration();
	ProcessUtil pu = new ProcessUtil();
	CustOperation am = new CustOperation();
	BankServerEmp bse = new BankServerEmp();
	BankServerCust bsc = new BankServerCust();
	Properties pts = new Properties();
	
public void homePage() throws InterruptedException {
		
		System.out.println("===========================");
		System.out.println("Chose Your Role:");
		System.out.println("1. Bank Employee.");
		System.out.println("2. Customer.");
		System.out.println("3. Exit");
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
			Thread.sleep(pts.STAY_TIME_DELAY);
			bse.homePage();
			break;
		case 2:
			Thread.sleep(pts.STAY_TIME_DELAY);
			bsc.homePage();
			break;
		case 3:
			pu.exit();
		default:
			System.out.println("Invalid Input, Try Again!");
			homePage();
		}
	}

	public static void main(String []args) throws InterruptedException {
		System.out.println("!!Welecome To TCS Global Bank!!");
		dsp = new DataStorePoint();
		dsp.initilize();
		BankServer bs = new BankServer();
		bs.homePage();
	}
}