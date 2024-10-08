package com.usermanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usermanagement.entity.UserDetails;

import jakarta.transaction.Transactional;
@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserDetails,Integer> {
	

}
