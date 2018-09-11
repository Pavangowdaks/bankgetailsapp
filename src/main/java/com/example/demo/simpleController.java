package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class simpleController {
	@Autowired
	BankRepository bankRepository;
	
	ModelAndView mv= new ModelAndView();;
	
	@RequestMapping("/")
	public String home() {
		return "Home";
	}
	
	// Getting bank details by IFSC code
		@RequestMapping("getBankDetails")
		public ModelAndView getBankDetails(@RequestParam ("ifsc") String ifsc) {
			System.out.println("entered the get");
			//List<Bank> list=(List<Bank>)bankRepository.findAll();

			Banks bank=bankRepository.findById(ifsc.toUpperCase()).orElseThrow(() -> new DataNotFoundException("Bank with IFSC "+ifsc+" not found "));
			List<Banks> banks=new ArrayList<>();
			banks.add(bank);
			mv.setViewName("Display");
			mv.addObject("BankDetails", banks);
			//System.out.println("fetched daata"+bank);
			return mv;
		}
		
		//getting bank details by BankName
		@RequestMapping("getBankDetailsByName")
		public ModelAndView getBankDetailByName(@RequestParam ("bankname") String bankname) {
			List<Banks> banks=(List<Banks>)bankRepository.findAllByBankname(bankname.toUpperCase());
			//Bank banks=bankRepository.findById(name).orElse(new Bank());
			if(banks.isEmpty()) {
				throw new DataNotFoundException("Bank with the name " + bankname+" not found");
			}else {
			mv.setViewName("Display");
			mv.addObject("BankDetails", banks);
			return mv;
			}
		}
		
		//getting bank details by City
		@RequestMapping("getBankDetailsByCity")
		public ModelAndView getBankDetailByCity(@RequestParam ("city") String city) {
			List<Banks> banks=(List<Banks>)bankRepository.findAllByCity(city.toUpperCase());
			if(banks.isEmpty()) {
				throw new DataNotFoundException("Bank in the " + city + " not found");
			}else {
			mv.setViewName("Display");
			mv.addObject("BankDetails", banks);
			return mv;
			}
		}
		
		//getting bank details by Name and City
		@RequestMapping("getBankDetailsByNameandCity")
		public ModelAndView getBankDetailByNameandCity(@RequestParam ("bankname") String bankname, @RequestParam ("city") String city) {
			List<Banks> banks=(List<Banks>)bankRepository.findAllByBanknameAndCity(bankname.toUpperCase(), city.toUpperCase());
			if(banks.isEmpty()) {
				throw new DataNotFoundException("Bank with the name  " + bankname+" and in city "+ city+" not found");
			}else {
			mv.setViewName("Display");
			mv.addObject("BankDetails", banks);
			return mv;
			}
		}
		
		// Getting bank details by IFSC code using RESTapi	
		@GetMapping("getBankDetailsByIfsc/{ifsc}")
		@ResponseBody
		public Banks getBankDetailsByIfsc(@PathVariable ("ifsc") String ifsc) {
			Banks bank=bankRepository.findById(ifsc.toUpperCase()).orElseThrow(() -> new DataNotFoundException("Bank with IFSC "+ifsc+" not found "));
			return bank;
		}
		
		@GetMapping("getBankDetailsByName/{bankname}")
		@ResponseBody
		public List<Banks> getBankDetailsByName(@PathVariable ("bankname") String bankname) {
			List<Banks> banks=(List<Banks>)bankRepository.findAllByBankname(bankname.toUpperCase());
			if(banks.isEmpty()) {
				throw new DataNotFoundException("Bank with the name " + bankname+" not found");
			}else {
			return banks;
			}
		}
		
		@GetMapping("getBankDetailsByCity/{city}")
		@ResponseBody
		public List<Banks> getBankDetailsByCity(@PathVariable ("city") String city) {
			List<Banks> banks=(List<Banks>)bankRepository.findAllByCity(city.toUpperCase());
			if(banks.isEmpty()) {
				throw new DataNotFoundException("Bank in the " + city + " not found");
				}else {
					return banks;
				}
		}
		
		@GetMapping("getBankDetailsByName/{bankname}/City/{city}")
		@ResponseBody
		public List<Banks> getBankDetailsByNameandCity(@PathVariable ("bankname") String bankname, @PathVariable ("city") String city) {
			List<Banks> banks=(List<Banks>)bankRepository.findAllByBanknameAndCity(bankname.toUpperCase(), city.toUpperCase());
			if(banks.isEmpty()) {
				throw new DataNotFoundException("Bank with the name  " + bankname+" and in city "+ city+" not found");
			}else {
			return banks;
			}
		}

}
