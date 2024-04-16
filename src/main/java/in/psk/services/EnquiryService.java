package in.psk.services;

import java.util.List;

import in.psk.dashboard.Dashboard;
import in.psk.entities.Enquiry;

public interface EnquiryService {

	//get Dashboard Information
	public  Dashboard getDashBoardInfo(Integer counsellorId);
	//Save the Enquiry data into db table
	public boolean addEnquiry(Enquiry enquiry,Integer counsellorId);
	//Retrieving the Enquiry table data to the Web page by filtering (classMode,course,status)
	public List<Enquiry> getEnquiries(Enquiry enquiry,Integer counsellorId);
	//For to update the enquiry table
	public Enquiry getEnquiry(Integer enqId);
}
