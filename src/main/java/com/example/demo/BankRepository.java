package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BankRepository extends JpaRepository<Banks, String>{
	
	// Getting bank details by state
		List<Banks> findAllByState(String state);
		// Getting bank details by City
		List<Banks> findAllByCity(String name);
		// Getting bank details by BankName
		List<Banks> findAllByBankname(String bankname);
		// Getting bank details by BankName and City
		List<Banks> findAllByBanknameAndCity(String bankname, String city);

}
