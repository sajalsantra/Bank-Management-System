package com.bank.customer;

import java.util.Scanner;

import com.bank.employee.BankServerEmp;
import com.process.ProcessUtil;

import config.Customer;
import dao.operation.DataStorePoint;

public class CustomerRegistration {
	Scanner sc;
	ProcessUtil pu = new ProcessUtil();
	DataStorePoint dsp = new DataStorePoint();
	BankServerEmp bs = new BankServerEmp();
	
	public void customerRegister() throws InterruptedException {
		String ssn_no;
		String cusName;
		String cusEmail;
		String cusAdd;
		String cusContNum;
		String aadharNo;
		String panNum;
		String cusAccNum;
		String initialDepAmt;
		sc = new Scanner(System.in);
		System.out.println("===========================");
		System.out.println("Enter Following Information: ");
		System.out.print("Enter SSN No. (7 digit Number): ");
		ssn_no = sc.nextLine();
		while(!pu.isValisNumber(ssn_no) || ssn_no.length()!=7) {			
			System.out.print("InValid SSN No., Enter Correct No.: ");
			ssn_no = sc.nextLine();
		}
		cusAccNum = pu.genRandNum();
		while(!pu.isValidAcc(cusAccNum)) {			
			cusAccNum = pu.genRandNum();
		}
		System.out.print("Enter Customer Name: ");
		cusName = sc.nextLine();
		while(!pu.isValidName(cusName)) {
			System.out.print("Not a Valid Name, Enter Correct Name: ");
			cusName = sc.nextLine();
		}
		System.out.print("Enter Email: ");
		cusEmail = sc.nextLine();
		while(!pu.isValidEmail(cusEmail)) {
			System.out.print("InValid Email, Enter Correct Email: ");
			cusEmail = sc.nextLine();
		}
		System.out.print("Enter Full Address: ");
		cusAdd = sc.nextLine();
		while(!pu.isValidAdd(cusAdd)) {
			System.out.print("InValid Address, Enter Correct Address: ");
			cusAdd = sc.nextLine();
		}
		System.out.print("Enter Contact Number: ");
		cusContNum = sc.nextLine();
		while(!pu.isValidContactNumber(cusContNum)) {
			System.out.print("InValid Contact Number, Enter Correct Number: ");
			cusContNum = sc.nextLine();
		}
		System.out.print("Enter Aadhar Number (12 digit number): ");
		aadharNo = sc.nextLine();
		while(!pu.isValidaadharNum(aadharNo)) {
			aadharNo = sc.nextLine();
		}
		System.out.print("Enter Pan Card Number (AAAAA1234A): ");
		panNum = sc.nextLine().toUpperCase();
		while(!pu.isValidPanNum(panNum)) {
			panNum = sc.nextLine().toUpperCase();
		}
		System.out.print("Enter Initial Deposit amount: ");
		initialDepAmt = sc.nextLine();
		while(!pu.isValisNumber(initialDepAmt)) {
			System.out.print("InValid Amount., Enter Correct Amount: ");
			initialDepAmt = sc.nextLine();
		}
		
		Customer cust = new Customer(ssn_no, cusName.toUpperCase(), cusEmail, cusAdd.toUpperCase(), cusContNum, aadharNo, panNum, cusAccNum, initialDepAmt);
		System.out.println("================================");
		System.out.println("Please Re-Check Your Information");
		System.out.println("================================");
		dsp.displayCustDetails(cust);
		System.out.println("================================");
		System.out.println("Click To Continue: \n1. Submit & Create Account"+"\n2. Cancel & Back to Home Page");
		System.out.print("Enter Your Choice: ");
		int val = sc.nextInt();
		while(val > 0 && val < 3) {
			switch (val) {
			case 1:
				dsp.addCustomer(cust);
				break;
			case 2:
				bs.homePage();
			default:
				System.out.print("Invalid Input!!, Re-Enter your choice: ");
				val = sc.nextInt();
			}
		}
	}
}