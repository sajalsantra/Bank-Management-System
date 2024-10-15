package com.bank.employee;

import java.util.Scanner;

import com.process.ProcessUtil;

import config.Customer;
import config.Properties;
import dao.operation.DataStorePoint;

public class EmpOperation {
	Scanner sc = new Scanner(System.in);
	ProcessUtil pu = new ProcessUtil();
	DataStorePoint dsp = new DataStorePoint();
	Properties pts = new Properties();
	static BankServerEmp bse = new BankServerEmp();
	
	public void displayFullCutomerDetails() throws InterruptedException {
		System.out.println("================================");
		System.out.print("Enter Account Number: ");
		String accNum = sc.nextLine();
		while(!pu.isValisNumber(accNum)) {
			System.out.print("InValid Acount No., Enter Correct No.: ");
			accNum = sc.nextLine();
		}
		displayCustomerDetais(accNum, 0);
		
	}

	private void displayCustomerDetais(String accNum, int i) throws InterruptedException {
		Customer cust = dsp.getCustDetails(accNum);
		if(cust==null) {
			if (i == 2) {
				System.out.println("================================");
				System.out.println("You make 3 unsuccessful try, You are being re-directed to Home page After "+(pts.STAY_TIME_ERROR/1000)+" Sec!");
				Thread.sleep(pts.STAY_TIME_ERROR);
				bse.homePage();
			}
			Thread.sleep(pts.STAY_TIME_DELAY);
			System.out.print("Enter Correct Account Number: ");
			accNum = sc.nextLine();
			while(!pu.isValisNumber(accNum)) {
				System.out.print("InValid Acount No., Enter Correct No.: ");
				accNum = sc.nextLine();
			}
			displayCustomerDetais(accNum, i+1);
		}else {
			System.out.println("Account Holder Name:              "+cust.getCusName());
			System.out.println("--------------"+"                 "+"------------------------");
			System.out.println("Account Number:                   "+cust.getAccNum());
			System.out.println("--------------"+"                 "+"------------------------");
			System.out.println("Total Balance:                    "+cust.getInitialDepAmt());
			System.out.println("--------------"+"                 "+"------------------------");
			System.out.println("Aadhar No.:                       "+cust.getAadherNo());
			System.out.println("--------------"+"                 "+"------------------------");
			System.out.println("Pan Card No.:                     "+cust.getPanNum());
			System.out.println("--------------"+"                 "+"------------------------");
			System.out.println("Contact No.:                      "+cust.getCusContNum());
			System.out.println("--------------"+"                 "+"------------------------");
			System.out.println("Email:                            "+cust.getCusEmail());
			System.out.println("--------------"+"                 "+"------------------------");
			System.out.println("Address:                          "+cust.getCusAdd());
			System.out.println("--------------"+"                 "+"------------------------");
			System.out.println("You are being re-directed to Home page After "+(pts.STAY_TIME/1000)+" Sec!");
			Thread.sleep(pts.STAY_TIME);
			bse.homePage();
		}
	}

	public void editCustDetails() throws InterruptedException {
		System.out.println("================================");
		System.out.print("Enter Account Number: ");
		String accNum = sc.nextLine();
		while(!pu.isValisNumber(accNum)) {
			System.out.print("InValid Acount No., Enter Correct No.: ");
			accNum = sc.nextLine();
		}
		editCustomerDetais(accNum, 0);
	}

	private void editCustomerDetais(String accNum, int i) throws InterruptedException {
		Customer cust = dsp.getCustDetails(accNum);
		if(cust==null) {
			if (i == 2) {
				System.out.println("================================");
				System.out.println("You make 3 unsuccessful try, You are being re-directed to Home page After "+(pts.STAY_TIME_ERROR/1000)+" Sec!");
				Thread.sleep(pts.STAY_TIME_ERROR);
				bse.homePage();
			}
			Thread.sleep(pts.STAY_TIME_DELAY);
			System.out.print("Enter Correct Account Number: ");
			accNum = sc.nextLine();
			while(!pu.isValisNumber(accNum)) {
				System.out.print("InValid Acount No., Enter Correct No.: ");
				accNum = sc.nextLine();
			}
			editCustomerDetais(accNum, i+1);
		}else {
			System.out.println("1. Name \n2. Email \n3. Contact Number \n4. Address \n5. Back Home Page");
			System.out.print("Enter Your Choice: ");
			String input = sc.next();
			while(!pu.isValisNumber(input) || Integer.parseInt(input)>5) {
				System.out.print("Invalid Type Choice, Enter Valid Choice: ");
				input = sc.next();
			}
			int val = Integer.parseInt(input);
			switch(val) {
				case 1:
					System.out.print("Enter New Name: ");
					String newName = sc.nextLine();
					while(!pu.isValidName(newName)) {
						System.out.print("Not a Valid Name, Enter Correct Name: ");
						newName = sc.nextLine();
					}
					cust.setCusName(newName);
					pu.message("Updating", "Name Updated");
					Thread.sleep(pts.STAY_TIME_DELAY);
					break;
				case 2:
					System.out.print("Enter New Email: ");
					String newEmail = sc.nextLine();
					while(!pu.isValidEmail(newEmail)) {
						System.out.print("Invalid Email, Enter Correct Eamil: ");
						newEmail = sc.nextLine();
					}
					cust.setCusEmail(newEmail);
					pu.message("Updating", "Email Updated");
					Thread.sleep(pts.STAY_TIME_DELAY);
					break;
				case 3:
					System.out.print("Enter New Contact Number: ");
					String newCont = sc.nextLine();
					while(!pu.isValidContactNumber(newCont)) {
						System.out.print("Invalid Number, Enter Correct Number: ");
						newCont = sc.nextLine();
					}
					cust.setCusContNum(newCont);
					pu.message("Updating", "Contact Number Updated");
					Thread.sleep(pts.STAY_TIME_DELAY);
					break;
				case 4:
					System.out.print("Enter New Address: ");
					String newAdd = sc.nextLine();
					while(!pu.isValidName(newAdd)) {
						System.out.print("Invalid Address, Enter Correct Address: ");
						newAdd = sc.nextLine();
					}
					cust.setCusAdd(newAdd);
					pu.message("Updating", "Address Updated");
					Thread.sleep(pts.STAY_TIME_DELAY);
					break;
				case 5:
					Thread.sleep(pts.STAY_TIME_DELAY);
					bse.homePage();
					break;
				default:
					System.out.println("Invalid Input!!");
			}
			editCustomerDetais(accNum, 0);
		}
	}

	public void deleteCustomer() throws InterruptedException {
		System.out.println("================================");
		System.out.print("Enter Account Number: ");
		String accNum = sc.nextLine();
		while(!pu.isValisNumber(accNum)) {
			System.out.print("InValid Acount No., Enter Correct No.: ");
			accNum = sc.nextLine();
		}
		deleteCustomerDetais(accNum, 0);
	}

	private void deleteCustomerDetais(String accNum, int i) throws InterruptedException {
		Customer cust = dsp.getCustDetails(accNum);
		if(cust==null) {
			if (i == 2) {
				System.out.println("================================");
				System.out.println("You make 3 unsuccessful try, You are being re-directed to Home page After "+(pts.STAY_TIME_ERROR/1000)+" Sec!");
				Thread.sleep(pts.STAY_TIME_ERROR);
				bse.homePage();
			}
			Thread.sleep(pts.STAY_TIME_DELAY);
			System.out.print("Enter Correct Account Number: ");
			accNum = sc.nextLine();
			while(!pu.isValisNumber(accNum)) {
				System.out.print("InValid Acount No., Enter Correct No.: ");
				accNum = sc.nextLine();
			}
			editCustomerDetais(accNum, i+1);
		}else {
			pu.deletePrev(cust);
			System.out.println("Click To Continue: \n1. Submit." + "\n2. Cancle & Back to Home Page");
			System.out.print("Enter Your Choice: ");
			String input = sc.next();
			while(!pu.isValisNumber(input) || Integer.parseInt(input)>2) {
				System.out.print("Invalid Type Choice, Enter Valid Choice: ");
				input = sc.next();
			}
			int val = Integer.parseInt(input);
			switch (val) {
			case 1:
				dsp.deleteCust(cust, accNum);
				pu.delete();
				Thread.sleep(pts.STAY_TIME_DELAY);
				bse.homePage();
			case 2:
				bse.homePage();
			default:
				System.out.print("Invalid Input!!");
			}
		}
		
	}

}