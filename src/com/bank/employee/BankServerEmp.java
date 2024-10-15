package com.bank.employee;

import java.util.Scanner;

import com.bank.customer.CustomerRegistration;
import com.process.ProcessUtil;

import dao.operation.DataStorePoint;

public class BankServerEmp {
	Scanner sc = new Scanner(System.in);
	DataStorePoint dsp = new DataStorePoint();
	static EmployeeSelfRegister er = new EmployeeSelfRegister();
	ProcessUtil pu = new ProcessUtil();
	static CustomerRegistration cr = new CustomerRegistration();
	EmpOperation empo = new EmpOperation();
	
	public void homePage() throws InterruptedException {
		boolean flag = false;
//		try {
//			flag = dsp.isEmpAva();
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
		if(!flag) {
			System.out.println("===========================");
			System.out.println("Chose Your Service:");
			System.out.println("1. Employee Self Register.");
			System.out.println("2. Employee Deatils Check.");
			System.out.println("3. New Customer Registration.");
			System.out.println("4. Get Customer Details");
			System.out.println("5. Edit Customer Details.");
			System.out.println("6. Delete Customer Details.");
			System.out.println("7. Exit");
			System.out.println("===========================");
			System.out.print("Enter Your Choice:");
			String input = sc.next();
			while(!pu.isValisNumber(input)) {
				System.out.print("Invalid Type Choice, Enter Valid Choice: ");
				input = sc.next();
			}
			int val = Integer.parseInt(input);
			switch(val) {
				case 1:
					er.registerEmployee();
					break;
				case 2:
					er.displayEmpDetails();
					break;
				case 3:
					cr.customerRegister();
					break;
				case 4:
					empo.displayFullCutomerDetails();
					break;
				case 5:
					empo.editCustDetails();
					break;
				case 6:
					empo.deleteCustomer();
					break;
				case 7: 
					pu.exit();
				default:
					System.out.println("Invalid Input!!!");
					homePage();
			}		
		}else {
			System.out.println("===========================");
			System.out.println("Chose Your Service:");
			System.out.println("1. Employee Self Register.");
			System.out.println("2. Exit");
			System.out.println("===========================");
			System.out.print("Enter Your Choice:");
			String input = sc.next();
			while(!pu.isValisNumber(input)) {
				System.out.print("Invalid Type Choice, Enter Valid Choice: ");
				input = sc.next();
			}
			int val = Integer.parseInt(input);
			switch(val) {
				case 1:
					er.registerEmployee();
					break;
				case 2:
					pu.exit();
				default:
					System.out.println("Invalid Input!!!");
					homePage();
			}
		}
	}
	public static void main(String []args) throws InterruptedException {
		DataStorePoint bsp = new DataStorePoint();
		bsp.initilize();
		BankServerEmp bs = new BankServerEmp();
		bs.homePage();
	}
}