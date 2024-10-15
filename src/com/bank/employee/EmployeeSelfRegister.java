package com.bank.employee;

import java.util.Scanner;

import com.process.ProcessUtil;
import config.Employee;
import config.Properties;
import dao.operation.DataStorePoint;

public class EmployeeSelfRegister {
	Scanner sc;
	ProcessUtil pu = new ProcessUtil();
	Properties pop;
	static DataStorePoint dsp = new DataStorePoint();
	static BankServerEmp bse = new BankServerEmp();
	Properties pts = new Properties();
	
	void registerEmployee() throws InterruptedException {
		sc = new Scanner(System.in);
		String empId;
		String empName;
		String empEmail;
		String empPassword;
		String empAdd;
		String empCont;
		
		System.out.println("Enter Employee Details: ");
		
		System.out.print("Enter Employee Id: ");
		empId = sc.nextLine();
		while(!pu.isValisEmpId(empId)) {
			System.out.print("InValid EmpId, Enter Correct Employee Id:");
			empId = sc.nextLine();
		}
		
		System.out.print("Enter Employee Name: ");
		empName = sc.nextLine();
		while(!pu.isValidName(empName)) {
			System.out.print("Not a Valid Name, Enter Correct Name:");
			empName = sc.nextLine();
		}
		System.out.print("Enter Email Id: ");
		empEmail = sc.nextLine();
		while(!pu.isValidEmail(empEmail)) {
			System.out.print("InValid Email, Enter Correct Email:");
			empEmail = sc.nextLine();
		}
		
		System.out.print("Enter PassWord: ");
		empPassword = sc.nextLine();
		while(!pu.isValidPassword(empPassword)) {
			System.out.print("InValid PassWord, Enter new PassWord:");
			empPassword = sc.nextLine();
		}
		
		System.out.print("Enter Address: ");
		empAdd = sc.nextLine();
		while(!pu.isValidAdd(empAdd)) {
			System.out.print("InValid Address, Enter Correct Address: ");
			empAdd = sc.nextLine();
		}
		
		System.out.print("Enter Contant Number: ");
		empCont = sc.nextLine();
		while(!pu.isValidContactNumber(empCont)) {
			System.out.print("Invalid Number, Enter Correct Number:");
			empCont = sc.nextLine();
		}
		
		Employee emp = new Employee(empId, empName.toUpperCase(), empEmail, empPassword, empAdd.toUpperCase(), empCont);
		dsp.addEmplyoee(emp);
		System.out.println("You are being re-directed to Home page After "+(pts.STAY_TIME)+" Sec!");
		Thread.sleep(pts.STAY_TIME);
		bse.homePage();
	}
	
	public void displayEmpDetails() throws InterruptedException {
		sc = new Scanner(System.in);
		System.out.println("Enter empId: ");
		String empId = sc.nextLine();
		System.out.println("Enter PassWord: ");
		String empPassword = sc.nextLine();
		System.out.println("Employee Details:");
		System.out.println("======================================");
		dsp.displayEmp(empId, empPassword);
		bse.homePage();
	}
}