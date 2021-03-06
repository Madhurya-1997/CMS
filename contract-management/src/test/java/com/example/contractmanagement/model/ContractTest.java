package com.example.contractmanagement.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

class ContractTest {

	Contract contract = new Contract();
	private Validator validator;
	@Test
	void testId() {
		contract.setId(1);
		assertEquals(contract.getId(), 1);
	}
	
	@Test
	void testContractType() {
		contract.setContractType("Some Text");
		assertEquals(contract.getContractType(), "Some Text");
	}
	@Test
	void testContractDuration() {
		contract.setContractDuration(1);
		assertEquals(contract.getContractDuration(), 1);
	}
	
	@Test
	void testContractTermsAndConditions() {
		contract.setTermsAndConditions("Some Text");
		assertEquals(contract.getTermsAndConditions(), "Some Text");
	}
	
	@Test
	void testStatus() {
		contract.setStatus("dummy status");
		assertEquals(contract.getStatus(), "dummy status");
	}
	

	
	@Test
	void testSupplier() {
		contract.setId(1);
		contract.setContractType("Some Text");
		contract.setContractDuration(1);
		contract.setTermsAndConditions("Some Text");
		contract.setStatus("dummy status");
		Supplier supplier = new Supplier();
		supplier.setId(1);
		contract.setSupplier(supplier);

		String tostring="Contract [id=1, contractType=Some Text, contractDuration=1, termsAndConditions=Some Text, supplier=1, status=dummy status]";
		assertEquals(contract.toString(), tostring);
	}
	
	 @BeforeEach
	    public void setUp() {
	        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	        validator = factory.getValidator();
	    }
	@Test
	void testContractTypeLength() {
		String ctype="";
		for (int i = 0; i<=600; i++)
			ctype = ctype+"a";
		contract.setContractType(ctype);
		contract.setTermsAndConditions(ctype);
		Set<ConstraintViolation<Contract>> violations = validator.validate(contract);
		assertFalse(violations.isEmpty());
	}

	 @BeforeEach
	    public void anothersetUp() {
	        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	        validator = factory.getValidator();
	    }
	@Test
	void anothertestContractTypeLength() {
		String ctype="";
		
		contract.setContractType(ctype);
		contract.setTermsAndConditions(ctype);
		Set<ConstraintViolation<Contract>> violations = validator.validate(contract);
		assertFalse(violations.isEmpty());
	}
	
}
