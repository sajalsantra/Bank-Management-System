package dao.operation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bank.employee.BankServerEmp;
import com.bank.employee.EmployeeSelfRegister;
import com.process.ProcessUtil;

import config.Customer;
import config.Employee;
import config.Properties;

public class DataStorePoint {

	static List<Employee> empList;
	static Map<String, Integer> empMapp;
	static List<Customer> custList;
	static Map<String, Integer> custMapp;
	static Set<String> aadhar;
	static Set<String> panCard;
	static ProcessUtil pu = new ProcessUtil();
	static BankServerEmp bs = new BankServerEmp();
	Properties pts = new Properties();
	EmployeeSelfRegister er = new EmployeeSelfRegister();
	
	public void initilize() {
		custList = new ArrayList<>();
		custMapp = new HashMap<>();
		aadhar = new HashSet<>();
		panCard = new HashSet<>();
		empList = new ArrayList<>();
		empMapp = new HashMap<>();
	}
	
	/* Add Customer details in List & Map Index in map using Account Number */
	public void addCustomer(Customer cust) throws InterruptedException {
		custList.add(cust);
		custMapp.put(cust.getAccNum(), custList.size()-1);
		aadhar.add(cust.getAadherNo());
		panCard.add(cust.getPanNum());
		pu.submission();
		System.out.println("Account No.:            "+cust.getAccNum());
		System.out.println("--------------"+"       "+"----------------------");
		System.out.println("Account Holder Name:    "+cust.getCusName());
		System.out.println("--------------"+"       "+"----------------------");
		System.out.println("Current Balance:        "+cust.getInitialDepAmt());
		System.out.println("--------------"+"       "+"----------------------");
		System.out.println("You are being re-directed to Home page After "+(pts.STAY_TIME/1000)+" Sec!");
		Thread.sleep(pts.STAY_TIME);
		bs.homePage();
	}

	/* Checking Account is Valid or Not*/
	public boolean isValidAccNum(String accnum) {
		if(custMapp.isEmpty()) return true;
		if(custMapp.containsKey(accnum)) return false;
		return true;
	}

	public int getIdxCustList() {
		return custList.size();
	}

	/* Display Customer Full Details For Preview */
	public void displayCustDetails(Customer cust) {
		System.out.println("SSN No.:                          "+cust.getSsn_no().substring(0, 2)+"XXXX"+cust.getSsn_no().substring(6));
		System.out.println("--------------"+"                 "+"------------------------");
		System.out.println("Customer Name:                    "+cust.getCusName());
		System.out.println("--------------"+"                 "+"------------------------");
		System.out.println("Customer Contact No.:             "+cust.getCusContNum());
		System.out.println("--------------"+"                 "+"------------------------");
		System.out.println("Customer Email:                   "+cust.getCusEmail());
		System.out.println("--------------"+"                 "+"------------------------");
		System.out.println("Customer Address:                 "+cust.getCusAdd());
		System.out.println("--------------"+"                 "+"------------------------");
		System.out.println("Customer Aadhar No.:              "+cust.getAadherNo());
		System.out.println("--------------"+"                 "+"------------------------");
		System.out.println("Customer Pan Card No.:            "+cust.getPanNum());
		System.out.println("--------------"+"                 "+"------------------------");
		System.out.println("Customer Initial Deposit Amount.: "+cust.getInitialDepAmt());
	}

	/* To get Customer through Their Account Number */
	public Customer getCustDetails(String accNum) {
		if(custList.isEmpty() || !custMapp.containsKey(accNum)) {
			System.out.println("No Account Found!");
			return null;
		}
		return custList.get(custMapp.get(accNum));
	}
	
	/* To Check Duplicate Aadhar Number */
	public boolean isUseAadhar(String aadharNo) {
		return aadhar.contains(aadharNo);
	}
	
	/* To Check Duplicate PanCard Number */
	public boolean isUsePanCard(String panNum) {
		return panCard.contains(panNum);
	}
	
	
	//add employee details
	public void addEmplyoee(Employee emp) throws InterruptedException {
		empList.add(emp);
		empMapp.put(emp.getEmpId(), empList.size()-1);
		pu.submission();
	}
	
	public boolean isEmpAva() {
		return empList.isEmpty();
	}
	
	//display employee details
	public void displayEmp(String empId, String passWord) throws InterruptedException {
//		System.out.println(empList.size());
		if(!empMapp.containsKey(empId)) {
			System.out.println("No Employee Found!");
			System.out.println("You are being re-directed to Home page After "+(pts.STAY_TIME/1000)+" Sec!");
			Thread.sleep(pts.STAY_TIME_ERROR);
		}else {
			Employee emp = empList.get(empMapp.get(empId)); 
			String pass = emp.getEmpPassword();
			if(passWord.equals(pass)) {
				System.out.println("EmpId:              "+emp.getEmpId());
				System.out.println("-----------         ---------------------");
				System.out.println("Emp Name:           "+emp.getEmpName());
				System.out.println("-----------         ---------------------");
				System.out.println("Emp Email:          "+emp.getEmpEmail());
				System.out.println("-----------         ---------------------");
				System.out.println("Emp Adress:         "+emp.getEmpAdd());
				System.out.println("-----------         ---------------------");
				System.out.println("Emp Contact Number: "+emp.getEmpCont());
				System.out.println("-----------         ---------------------");
				System.out.println("You are being re-directed to Home page After "+(pts.STAY_TIME/1000)+" Sec!");
				Thread.sleep(pts.STAY_TIME);
			}else {
				System.out.println("PassWord incorrect, Try Again!");
				Thread.sleep(pts.STAY_TIME_DELAY);
				er.displayEmpDetails();
			}
		}
	}


	public void deleteCust(Customer cust, String accNum) {
		int idx = custMapp.get(accNum);
		custList.remove(idx);
		custMapp.remove(accNum);
	}
}