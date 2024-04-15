package model;

public class EmpVO {
	int empNo;
	String empId;
	String empPw;
	int grade;
	String empName;
	String empJob;
	String hireDate;
	String updateDate;
	String createDate;
	String active;
	
	public EmpVO(int empNo, String empId, String empPw, int grade, String empName, String empJob, String hireDate,
			String updateDate, String createDate, String active) {
		super();
		this.empNo = empNo;
		this.empId = empId;
		this.empPw = empPw;
		this.grade = grade;
		this.empName = empName;
		this.empJob = empJob;
		this.hireDate = hireDate;
		this.updateDate = updateDate;
		this.createDate = createDate;
		this.active = active;
	}

	public EmpVO(String empId, String empPw, int grade, String empName, String empJob, String hireDate, String active) {
		super();
		this.empId = empId;
		this.empPw = empPw;
		this.grade = grade;
		this.empName = empName;
		this.empJob = empJob;
		this.hireDate = hireDate;
		this.active = active;
	}

	public EmpVO() {
		super();
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpPw() {
		return empPw;
	}

	public void setEmpPw(String empPw) {
		this.empPw = empPw;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpJob() {
		return empJob;
	}

	public void setEmpJob(String empJob) {
		this.empJob = empJob;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}
}
