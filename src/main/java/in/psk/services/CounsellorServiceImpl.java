package in.psk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.psk.entities.Counsellors;
import in.psk.repositorys.CounsellorsRepository;

@Service
public class CounsellorServiceImpl implements CounsellorsService {

	@Autowired
	private CounsellorsRepository counsellorRepo;
	@Override
	public boolean saveCounsellorData(Counsellors counsellor) {
		Counsellors findByEmail=counsellorRepo.findByEmail(counsellor.getEmail());
		if(findByEmail!=null)
		{
			return false;
		}else {
			 counsellorRepo.save(counsellor);
				return true;
		}
	}

	@Override
	public Counsellors getCounsellor(String email, String password) {
	
		return 	counsellorRepo.findByEmailAndPassword(email, password);
	}

}
