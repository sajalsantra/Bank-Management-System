package config;

public class Employee {
	private String empId;
	private String empName;
	private String empEmail;
	private String empPassword;
	private String empAdd;
	private String empCont;
	
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public String getEmpPassword() {
		return empPassword;
	}
	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}
	public String getEmpAdd() {
		return empAdd;
	}
	public void setEmpAdd(String empAdd) {
		this.empAdd = empAdd;
	}
	public String getEmpCont() {
		return empCont;
	}
	public void setEmpCont(String empCont) {
		this.empCont = empCont;
	}

	public Employee(String empId, String empName, String empEmail, String empPassword, String empAdd, String empCont) {
		this.empId = empId;
		this.empName = empName;
		this.empEmail = empEmail;
		this.empPassword = empPassword;
		this.empAdd = empAdd;
		this.empCont = empCont;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empEmail=" + empEmail + ", empPassword="
				+ empPassword + ", empAdd=" + empAdd + ", empCont=" + empCont + "]";
	}
}