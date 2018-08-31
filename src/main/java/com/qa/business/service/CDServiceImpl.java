package com.qa.business.service;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.persistence.repository.CDRepository;

public class CDServiceImpl implements CDService {
	
	private static final Logger LOGGER = Logger.getLogger(CDService.class);
	
	@Inject
	private CDRepository repo;

	public String getAllCDs() {
		LOGGER.info("In CDServiceImpl getAllCDs ");
		return repo.getAllCDs();
	}

	public String addCD(String cd) {
		return repo.createCD(cd);
	}

	public String updateCD(Long id, String cd) {
		return repo.updateCD(id, cd);
	}

	public String deleteCD(Long id) {
		return repo.deleteCD(id);
	}
	
	public void setRepo(CDRepository repo) {
		this.repo = repo;
	}
	

}
