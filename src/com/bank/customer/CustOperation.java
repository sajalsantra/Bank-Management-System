package com.bank.customer;

import java.util.Scanner;

import com.process.ProcessUtil;

import config.Customer;
import config.Properties;
import dao.operation.DataStorePoint;

public class CustOperation {
	Scanner sc = new Scanner(System.in);
	DataStorePoint dsp = new DataStorePoint();
	ProcessUtil pu = new ProcessUtil();
	static BankServerCust bsc = new BankServerCust();
	Properties pts = new Properties();

	/* Deposit Amount Existing Account using Account Number */
	public void depositeAmount() throws InterruptedException {
		System.out.println("================================");
		System.out.print("Enter Account Number: ");
		String accNum = sc.nextLine();
		while (!pu.isValisNumber(accNum)) {
			System.out.print("InValid Acount No., Enter Correct No.: ");
			accNum = sc.nextLine();
		}
		System.out.print("Enter Amount: ");
		String amount = sc.nextLine();
		while (!pu.isValisNumber(amount)) {
			System.out.print("InValid Amount, Enter Correct Amount: ");
			accNum = sc.nextLine();
		}
		System.out.print("Enter reconfirm Account Number: ");
		String rAccNum = sc.nextLine();
		if (accNum.contentEquals(rAccNum)) {
			Customer cust = dsp.getCustDetails(accNum);
			if (cust == null) {
				bsc.homePage();
			}
			int iniAmt = Integer.parseInt(cust.getInitialDepAmt());
			int debitAmt = Integer.parseInt(amount);
			pu.displyPreview(cust, amount);
			System.out.println("Click To Continue: \n1. Submit." + "\n2. Cancle & Back to Home Page");
			System.out.print("Enter Your Choice: ");
			String input = sc.next();
			while (!pu.isValisNumber(input) || Integer.parseInt(input) > 2) {
				System.out.print("Invalid Type Choice, Enter Valid Choice: ");
				input = sc.next();
			}
			int val = Integer.parseInt(input);
			switch (val) {
			case 1:
				cust.setInitialDepAmt(Integer.toString(iniAmt + debitAmt));
				pu.depositBalanceMessage();
				System.out.println("================================");
				displayBalanceDetails(cust, cust.getAccNum(), cust.getAadherNo(), 0);
			case 2:
				bsc.homePage();
			default:
				System.out.print("Invalid Input!!, Re-Enter your choice: ");
			}
		} else {
			System.out.println("Account Number Not Match, Try Again!");
			depositeAmount();
		}
	}

	/*
	 * WithDraw Amount Existing Account using Account Number & SSN No or Aadhar
	 * Number
	 */
	public void withdrawAmount() throws InterruptedException {
		System.out.println("================================");
		System.out.print("Enter Account Number: ");
		String accNum = sc.nextLine();
		while (!pu.isValisNumber(accNum)) {
			System.out.print("InValid Acount No., Enter Correct No.: ");
			accNum = sc.nextLine();
		}
		System.out.print("Enter Amount: ");
		String amount = sc.nextLine();
		while (!pu.isValisNumber(amount)) {
			System.out.print("InValid Amount, Enter Correct Amount: ");
			amount = sc.nextLine();
		}
		System.out.print("Enter reconfirm Account Number: ");
		String rAccNum = sc.nextLine();
		System.out.print("Enter SSN No./Aadhar Number: ");
		String securityKey = sc.nextLine();
		if (accNum.contentEquals(rAccNum)) {
			Customer cust = dsp.getCustDetails(accNum);
			if (cust == null)
				bsc.homePage();
			else
				withdrawProcess(cust, securityKey, accNum, 0, amount);
		} else {
			System.out.println("Account Number Not Match, Try Again!");
			depositeAmount();
		}
	}

	/* Withdraw Process */
	private void withdrawProcess(Customer cust, String securityKey, String accNum, int i, String amount)
			throws InterruptedException {
		if (securityKey.equals(cust.getAadherNo()) || securityKey.equals(cust.getSsn_no())) {
			int iniAmt = Integer.parseInt(cust.getInitialDepAmt());
			int debitAmt = Integer.parseInt(amount);
			if (iniAmt <= 250) {
				System.out.println("Your Balance is Less Then 500. So, You Can't Withdraw Money!");
				System.out.println(
						"You are being re-directed to Home page After " + (pts.STAY_TIME_ERROR / 1000) + " Sec!");
				Thread.sleep(pts.STAY_TIME_ERROR);
				bsc.homePage();
			}
			if (iniAmt < debitAmt) {
				System.out.println("Account Balance Insufficient, First Check Your Balance Then Try!");
				System.out.println(
						"You are being re-directed to Home page After " + (pts.STAY_TIME_ERROR / 1000) + " Sec!");
				Thread.sleep(pts.STAY_TIME_ERROR);
				bsc.homePage();
			}
			pu.displyPreview(cust, amount);
			System.out.println("Click To Continue: \n1. Submit." + "\n2. Cancle & Back to Home Page");
			System.out.print("Enter Your Choice: ");
			String input = sc.next();
			while (!pu.isValisNumber(input) || Integer.parseInt(input) > 2) {
				System.out.print("Invalid Type Choice, Enter Valid Choice: ");
				input = sc.next();
			}
			int val = Integer.parseInt(input);
			switch (val) {
			case 1:
				cust.setInitialDepAmt(Integer.toString(iniAmt - debitAmt));
				pu.withdrawBalanceMessage();
				System.out.println("================================");
				displayBalanceDetails(cust, cust.getAccNum(), cust.getAadherNo(), 0);
			case 2:
				bsc.homePage();
			default:
				System.out.print("Invalid Input!!, Re-Enter your choice: ");

			}

		} else {
			if (i == 2) {
				System.out.println("================================");
				System.out.println("You make 3 unsuccessful try, You are being re-directed to Home page After "
						+ (pts.STAY_TIME_ERROR / 1000) + " Sec!");
				Thread.sleep(pts.STAY_TIME_ERROR);
				bsc.homePage();
			}
			System.out.println("SSN No./Aadhar Number is InValid, Try Again!");
			System.out.print("Enter Correct SSN No./Aadhar Number: ");
			securityKey = sc.nextLine();
			withdrawProcess(cust, securityKey, accNum, i + 1, amount);
		}
	}

	/* Balance Checking Using Account Number & SSN No or Aadhar Number */
	public void balanceChecking() throws InterruptedException {
		System.out.println("================================");
		System.out.print("Enter Account Number: ");
		String accNum = sc.nextLine();
		while (!pu.isValisNumber(accNum)) {
			System.out.print("InValid Acount No., Enter Correct No.: ");
			accNum = sc.nextLine();
		}
		System.out.print("Enter SSN No./Aadhar Number: ");
		String securityKey = sc.nextLine();
		Customer customer = dsp.getCustDetails(accNum);
		if (customer == null) {
			bsc.homePage();
			return;
		}
		displayBalanceDetails(customer, accNum, securityKey, 0);
	}

	/* Display Balance Details */
	public void displayBalanceDetails(Customer customer, String accNum, String securityKey, int i)
			throws InterruptedException {
		String ssnNo = customer.getSsn_no();
		String aadharNum = customer.getAadherNo();
		if (securityKey.equals(ssnNo) || securityKey.equals(aadharNum)) {
			System.out.println("Account Holder Name:    " + customer.getCusName());
			System.out.println("--------------" + "     " + "----------------------");
			System.out.println("Account No.:            " + customer.getAccNum());
			System.out.println("--------------" + "     " + "----------------------");
			System.out.println("Current Balance:        " + customer.getInitialDepAmt());
			System.out.println("--------------" + "     " + "----------------------");
			System.out.println("Current Time:           " + pu.getCurrDateTime());
			System.out.println("--------------" + "     " + "----------------------");
			System.out.println("You are being re-directed to Home page After " + (pts.STAY_TIME / 1000) + " Sec!");
			Thread.sleep(pts.STAY_TIME);
			bsc.homePage();
		} else {
			if (i == 2) {
				System.out.println("================================");
				System.out.println("You make 3 unsuccessful try, You are being re-directed to Home page After "
						+ (pts.STAY_TIME_ERROR / 1000) + " Sec!");
				Thread.sleep(pts.STAY_TIME_ERROR);
				bsc.homePage();
			}
			System.out.println("SSN No./Aadhar Number is InValid, Try Again!");
			System.out.print("Enter Correct SSN No./Aadhar Number: ");
			securityKey = sc.nextLine();
			displayBalanceDetails(customer, accNum, securityKey, i + 1);
		}

	}

}