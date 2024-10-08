package com.usermanagement.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.usermanagement.entity.UserDetails;
@Repository
public interface UserRepository extends JpaRepository<UserDetails,Integer> {
	
	@Query("select e from UserDetails e where e.phoneNo=?1")
	UserDetails findUserByPhoneNo(String phoneNo);
	
	@Query("Select c from UserDetails c order by c.userName ASC")
	List<UserDetails> getAllUsers();
	

}
