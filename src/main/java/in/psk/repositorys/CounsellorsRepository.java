package in.psk.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import in.psk.entities.Counsellors;

public interface CounsellorsRepository extends JpaRepository<Counsellors, Integer> {
	// checking the given emailid is unique or not
	public Counsellors findByEmail(String Email);

	// checking the given emailid and password are there or not
	public Counsellors findByEmailAndPassword(String email, String password);
	
}
