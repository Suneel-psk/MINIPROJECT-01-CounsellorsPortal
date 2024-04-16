package in.psk.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.psk.dashboard.Dashboard;
import in.psk.entities.Counsellors;
import in.psk.entities.Enquiry;
import in.psk.repositorys.CounsellorsRepository;
import in.psk.repositorys.EnquiryRepository;
@Service
public class EnquiryServiceImpl implements EnquiryService {

	@Autowired
	private EnquiryRepository enqRepo;
	
	@Autowired
	private CounsellorsRepository counsellorRepo;
	@Override
	public Dashboard getDashBoardInfo(Integer counsellorId) {
		Long totalEnq=enqRepo.getEnquirys(counsellorId);
		Long openEnqCnt=enqRepo.getEnquirys(counsellorId,"new");
		Long lostEnqCnt=enqRepo.getEnquirys(counsellorId,"lost");
		Long enrolledEnqCnt=enqRepo.getEnquirys(counsellorId,"enrolled");
		Dashboard d=new Dashboard();
		d.setTotalEnqs(totalEnq);
		d.setOpenEnqs(openEnqCnt);
		d.setEnrolledEnqs(enrolledEnqCnt);
		d.setLostEnqs(lostEnqCnt);
		
		return d;
	}

	@Override
	public boolean addEnquiry(Enquiry enquiry,Integer counsellorId) {
		Counsellors counsellor=counsellorRepo.findById(counsellorId).orElseThrow();
		enquiry.setCounsellor(counsellor);//association for foreign key
	Enquiry savedEnq=enqRepo.save(enquiry);
	
		return savedEnq.getEnquiryId()!=null;
	}

	@Override
	public List<Enquiry> getEnquiries(Enquiry enquiry, Integer counsellorId) {
		//Counsellors counsellor=enquiry.getCounsellor();
		Counsellors counsellor=new Counsellors();
		counsellor.setCounsellorId(counsellorId);
		//why i am creating this enauiry objcet this is for adding filter values to entity
		Enquiry searchEnquiry=new Enquiry();
		searchEnquiry.setCounsellor(counsellor);
			//set fkid to enquiry 
		//Dynamic Query will create based on filtering
		//!"".equals(enquiry.getCourse()) ---> if we write like this we can avoid nullpointer exception and empty also
		//!enquiry.getClassMode().equals("")  ---> if i write we can check not empty only but we get nullpointer exception
		//if(null!=enquiry.getClassMode() && !"".equals(enquiry.getClassMode()){//body} better to go this one
		if(null!=enquiry.getCourse()&&!"".equals(enquiry.getCourse()))
		{
			searchEnquiry.setCourse(enquiry.getCourse());
		}
		if(null!=enquiry.getClassMode()&&!"".equals(enquiry.getClassMode()))
		{
			searchEnquiry.setClassMode(enquiry.getClassMode());
			
		}
		if(null!=enquiry.getStatus()&&!"".equals(enquiry.getStatus()))
		{
			searchEnquiry.setStatus(enquiry.getStatus());
		}
		Example<Enquiry> exp=Example.of(searchEnquiry);
		return enqRepo.findAll(exp);
	}

	@Override
	public Enquiry getEnquiry(Integer enqId) {
		
		return enqRepo.findById(enqId).orElseThrow();
	}

}
