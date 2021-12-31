package persistence;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "project")
public class ProjectEmployee {
	
	@Id
	@Column(name = "pro_id")
	private String proId;
	
	private String empId;
	private LocalDate startDate;
	
	public ProjectEmployee() {
	}

	public ProjectEmployee(String proId, String empId, LocalDate startDate) {
		this.proId = proId;
		this.empId = empId;
		this.startDate = startDate;
	}

	public String getProId() {
		return proId;
	}

	public void setProId(String proId) {
		this.proId = proId;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	@Override
	public String toString() {
		return "ProjectEmployee [proId=" + proId + ", empId=" + empId + ", startDate=" + startDate + "]";
	}
	
	
}
