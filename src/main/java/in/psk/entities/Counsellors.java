package in.psk.entities;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Counsellors {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer counsellorId;
	private String  name;
	private String email;
	private String password;
	private String phno;
	@CreationTimestamp
	private LocalDate createdDate;
	@UpdateTimestamp
	private LocalDate updatedDated;
	@OneToMany(mappedBy="counsellor",cascade=CascadeType.ALL)
	private List<Enquiry> enquiries;
	public Integer getCounsellorId() {
		return counsellorId;
	}
	public void setCounsellorId(Integer counsellorId) {
		this.counsellorId = counsellorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	public LocalDate getUpdatedDated() {
		return updatedDated;
	}
	public void setUpdatedDated(LocalDate updatedDated) {
		this.updatedDated = updatedDated;
	}
	public List<Enquiry> getEnquiries() {
		return enquiries;
	}
	public void setEnquiries(List<Enquiry> enquiries) {
		this.enquiries = enquiries;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	@Override
	public String toString() {
		return "Counsellors [counsellorId=" + counsellorId + ", name=" + name + ", email=" + email + ", password="
				+ password + ", phno=" + phno + ", createdDate=" + createdDate + ", updatedDated=" + updatedDated
				+ ", enquiries=" + enquiries + "]";
	}
	
	
}
