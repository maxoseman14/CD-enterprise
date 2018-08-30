package com.qa.persistence.repository;

public interface CDRepository {
	
	String getAllCDs ();
	String createCD (String cd);
	String deleteCD (Long id);
	String updateCD (Long id, String cdToUpdate);
	
}
