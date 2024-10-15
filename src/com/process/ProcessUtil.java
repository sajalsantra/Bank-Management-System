package com.process;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import config.Customer;
import config.Properties;
import dao.operation.DataStorePoint;


public class ProcessUtil {
	Scanner sc;
	static DataStorePoint dsp = new DataStorePoint();
	Properties pts = new Properties();
	
	/* Validation Check For EmpId */
	public boolean isValisEmpId(String empId) {
		if(empId.isEmpty()) return false;
		for (int i = 0; i < empId.length(); ++i) {
	        char ch = empId.charAt(i);
	        if (!Character.isDigit(ch) && !Character.isWhitespace(ch) || ch==' ') return false;
	    }
	    return true;
	}
	
	/* Validation Check For Any Number/String which only Contains Integer */
	public boolean isValisNumber(String number) {
		if(number.isEmpty()) return false;
		for (int i = 0; i < number.length(); ++i) {
	        char ch = number.charAt(i);
	        if (!Character.isDigit(ch) && !Character.isWhitespace(ch) || ch==' ') return false;
	    }
	    return true;
	}
	
	/* Validation Check For Name/String which only Contains Letter */
	public boolean isValidName(String name) {
		if(name.isEmpty()) return false;
		for (int i = 0; i < name.length(); i++) {
			char ch = name.charAt(i);
			if (!Character.isLetter(ch) && !Character.isWhitespace(ch)) return false;
		}
		return true;
	}
	
	/* Validation Check For Email Id Using Regex Pattern Matcher */
	public boolean isValidEmail(String email){                             
        Pattern pat = Pattern.compile(pts.EMAIL_PATTERN); 
        if (email == null) return false; 
        return pat.matcher(email).matches(); 
    } 
	
	/* Validation Check For PassWord Using Regex Pattern Matcher */
	public boolean isValidPassword(String password){
		if(password.length()<8 || password == null) {
			System.out.print("Password size is less then 8");
			return false;
		}
        Pattern p = Pattern.compile(pts.PASSWORD_PATTERN); 
        Matcher m = p.matcher(password);
        return m.matches();
    }
	
	/* Validation Check For Mobile Number Using Regex Pattern Matcher */
	public boolean isValidContactNumber(String number) {
		Pattern p = Pattern.compile(pts.MOBILE_PATTERN);
        Matcher m = p.matcher(number);
        return (m.matches());
	}
	
	/* Method For Exit or Stop Program */
	public void exit() throws InterruptedException {
		System.out.print("Exiting");
		for(int i=0; i<5; i++) {
			Thread.sleep(500);
			System.out.print(".");
		}
		System.out.print("\nExit Successfuly");
		System.exit(0);
	}
	
	/* Custom Submission Method To Display Completion Message*/
	public void submission() throws InterruptedException {
		System.out.print("Data Savings");
		for(int i=0; i<5; i++) {
			Thread.sleep(500);
			System.out.print(".");
		}
		System.out.println("\nCustomer Registration Successfully!");
	}
	
	public void delete() throws InterruptedException {
		System.out.print("Data Deleting");
		for(int i=0; i<5; i++) {
			Thread.sleep(500);
			System.out.print(".");
		}
		System.out.println("\nSucessfully Delete Customer Account!");
	}
	
	public void message(String str, String str2) throws InterruptedException {
		System.out.print(str);
		for(int i=0; i<5; i++) {
			Thread.sleep(500);
			System.out.print(".");
		}
		System.out.println("\nSucessfully "+str2+"!");
	}
	/* For Generate Random Number (12 digit) */
	public String genRandNum() {
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder((50000000 + rnd.nextInt(9000909)) + ""+rnd.nextInt(9009));
		return sb.toString();
	}
	
	/* Check Previous Account Number Use Or Not */
	public boolean isValidAcc(String cusAccNum) {
		return dsp.isValidAccNum(cusAccNum);
	}
	
	/* Generate Custom SSN_No */
	public String getSSNId() {
		return 10001 + "" + dsp.getIdxCustList();
	}
	
	/* Checking Address Validation */
	public boolean isValidAdd(String cusAdd) {
		if(cusAdd.isEmpty() || cusAdd.length()<4) return false;
		return true;
	}
	
	/* Checking Aadhar Number Validation (12 digit or Not & Any Letter or Space Available or not)*/
	public boolean isValidaadharNum(String aadharNo) {
		if(aadharNo.length()!=12) {
			System.out.print("InValid Aadhar Number, Enter Correct Aadhar Number: ");
			return false;
		}
		if(dsp.isUseAadhar(aadharNo)) {
			System.out.print("Aadhar Number Already Use, Check & re-Enter Correct Aadhar No.: ");
			return false;
		}
		for (int i = 0; i < aadharNo.length(); ++i) {
	        char ch = aadharNo.charAt(i);
	        if (!Character.isDigit(ch) && !Character.isWhitespace(ch) || ch==' ') {
				System.out.print("InValid Aadhar Number, Enter Correct Aadhar Number: ");
				return false;
			}
	    }
		return true;
	}
	
	/* Validation Check For PanCard Number Using Regex Pattern Matcher */
	public boolean isValidPanNum(String panNum) {
		if(panNum.isEmpty()) {
			System.out.print("InValid Pan Number, Enter Correct Pan Number: ");
			return false;
		}
		if(dsp.isUsePanCard(panNum)) {
			System.out.print("PanCard Number Already Use, Check & re-Enter Correct Pan No.: ");
			return false;
		}
		Pattern p = Pattern.compile(pts.PAN_PATTERN); 
	    Matcher m = p.matcher(panNum);
	    if(!m.matches()) {
			System.out.print("InValid Pan Number, Enter Correct Pan Number: ");
			return false;
		}
	    return true;
	}
	
	/* Method For get Current Date & Time */
	public String getCurrDateTime() {
		 SimpleDateFormat formatter = new SimpleDateFormat(pts.DATE_TIME_FORMAT);  
		 Date date = new Date();  
		return formatter.format(date);
	}
	
	/* After successfully Completion Deposit Completion Message */
	public void depositBalanceMessage() throws InterruptedException {
		System.out.print("Processing");
		for(int i=0; i<5; i++) {
			Thread.sleep(500);
			System.out.print(".");
		}
		System.out.println("\nAmount Deposit Successfully!");
		
	}
	
	/* After successfully Completion Withdraw Completion Message */
	public void withdrawBalanceMessage() throws InterruptedException {
		System.out.print("Processing");
		for(int i=0; i<5; i++) {
			Thread.sleep(500);
			System.out.print(".");
		}
		System.out.println("\nAmount Withdraw Successfully!");
		
	}
	
	/* Preview Information To Re-Check */
	public void displyPreview(Customer cust, String amount) {
		System.out.println("================================");
		System.out.println("Plese Re-Check Your Information");
		System.out.println("================================");
		System.out.println("Account No.:            "+cust.getAccNum());
		System.out.println("--------------"+"       "+"----------------------");
		System.out.println("Account Holder Name:    "+cust.getCusName());
		System.out.println("--------------"+"       "+"----------------------");
		System.out.println("Balance:                "+amount);
		System.out.println("--------------"+"       "+"----------------------");
	}

	public void deletePrev(Customer cust) {
		System.out.println("Account No.:            "+cust.getAccNum());
		System.out.println("--------------"+"       "+"----------------------");
		System.out.println("Account Holder Name:    "+cust.getCusName());
		System.out.println("--------------"+"       "+"----------------------");
		System.out.println("Balance:                "+cust.getInitialDepAmt());
		System.out.println("--------------"+"       "+"----------------------");
	}
}