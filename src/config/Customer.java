package config;

/* Create a Customer Class Contains All Customer Details & make Getter, Setter and Constructor */
public class Customer {
	private String ssn_no;
	private String cusName;
	private String cusEmail;
	private String cusAdd;
	private String cusContNum;
	private String aadherNo;
	private String panNum;
	private String accNum;
	private String initialDepAmt;
	public String getSsn_no() {
		return ssn_no;
	}
	
	public void setSsn_no(String ssn_no) {
		this.ssn_no = ssn_no;
	}
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public String getCusEmail() {
		return cusEmail;
	}
	public void setCusEmail(String cusEmail) {
		this.cusEmail = cusEmail;
	}
	public String getCusAdd() {
		return cusAdd;
	}
	public void setCusAdd(String cusAdd) {
		this.cusAdd = cusAdd;
	}
	public String getCusContNum() {
		return cusContNum;
	}
	public void setCusContNum(String cusContNum) {
		this.cusContNum = cusContNum;
	}
	public String getAadherNo() {
		return aadherNo;
	}
	public void setAadherNo(String aadherNo) {
		this.aadherNo = aadherNo;
	}
	public String getPanNum() {
		return panNum;
	}
	public void setPanNum(String panNum) {
		this.panNum = panNum;
	}
	public String getAccNum() {
		return accNum;
	}
	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}
	public String getInitialDepAmt() {
		return initialDepAmt;
	}
	public void setInitialDepAmt(String initialDepAmt) {
		this.initialDepAmt = initialDepAmt;
	}
	
	public Customer(String ssn_no, String cusName, String cusEmail, String cusAdd, String cusContNum, String aadherNo,
			String panNum, String accNum, String initialDepAmt) {
		this.ssn_no = ssn_no;
		this.cusName = cusName;
		this.cusEmail = cusEmail;
		this.cusAdd = cusAdd;
		this.cusContNum = cusContNum;
		this.aadherNo = aadherNo;
		this.panNum = panNum;
		this.accNum = accNum;
		this.initialDepAmt = initialDepAmt;
	}

	@Override
	public String toString() {
		return "Customer [ssn_no=" + ssn_no + ", cusName=" + cusName + ", cusEmail=" + cusEmail + ", cusAdd=" + cusAdd
				+ ", cusContNum=" + cusContNum + ", aadherNo=" + aadherNo + ", panNum=" + panNum + ", accNum=" + accNum
				+ ", initialDepAmt=" + initialDepAmt + "]";
	}
	
	
}