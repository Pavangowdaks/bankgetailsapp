package com.sudev;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface BankRepository extends JpaRepository<Bank, String> {
	// Getting bank details by state
	List<Bank> findAllByState(String state);
	// Getting bank details by City
	List<Bank> findAllByCity(String name);
	// Getting bank details by BankName
	List<Bank> findAllByBankname(String bankname);
	// Getting bank details by BankName and City
	List<Bank> findAllByBanknameAndCity(String bankname, String city);
	
}

