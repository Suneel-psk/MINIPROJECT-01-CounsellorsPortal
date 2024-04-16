package in.psk.services;

import org.springframework.stereotype.Service;

import in.psk.entities.Counsellors;


public interface CounsellorsService {
 
	//For To register counsellor data into db table
	public boolean saveCounsellorData(Counsellors counsellor);
	 
	//For To Check Login Credintials 
	public Counsellors getCounsellor(String email,String password);
	
}
