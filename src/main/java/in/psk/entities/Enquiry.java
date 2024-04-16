package in.psk.entities;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Enquiry {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer enquiryId;
	private String studName;
	private String studPhno;
	private String classMode;
	private String course;
	private String status;
	@CreationTimestamp
	 private LocalDate createdDate;
	@UpdateTimestamp
	 private LocalDate updatedDate;
	@ManyToOne
	@JoinColumn(name="counsellor_Id")
	private Counsellors counsellor;
	public Integer getEnquiryId() {
		return enquiryId;
	}
	public void setEnquiryId(Integer enquiryId) {
		this.enquiryId = enquiryId;
	}
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	public String getStudPhno() {
		return studPhno;
	}
	public void setStudPhno(String studPhno) {
		this.studPhno = studPhno;
	}
	public String getClassMode() {
		return classMode;
	}
	public void setClassMode(String classMode) {
		this.classMode = classMode;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	public LocalDate getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}
	public Counsellors getCounsellor() {
		return counsellor;
	}
	public void setCounsellor(Counsellors counsellor) {
		this.counsellor = counsellor;
	}
	
	
}
