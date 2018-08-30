package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.CD;
import com.qa.util.JSONUtil;

@Transactional (SUPPORTS)
@Default
public class CDDbRepository implements CDRepository{
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	public String getAllCDs() {
		Query query = manager.createQuery("Select a FROM CD a");
		Collection<CD> cds = (Collection<CD>) query.getResultList();
		return util.getJSONForObject(cds);
	}

	@Transactional (REQUIRED)
	public String createCD(String cd) {
		CD aCD = util.getObjectForJSON(cd, CD.class);
		manager.persist(aCD);
		return "{\"message\": \"A CD has been sucessfully added\"}";
	}

	@Transactional (REQUIRED)
	public String deleteCD(Long id) {
		CD CDInDB = findCD(id);
		if (CDInDB != null) {
			manager.remove(CDInDB);
		}
		return "{\"message\": \"CD sucessfully deleted\"}";
	}
	
	@Transactional
	public String updateCD(Long id, String cdToUpdate) {
		CD updatedCD = util.getObjectForJSON(cdToUpdate, CD.class);
		CD CDFromDB = findCD(id);
		if (cdToUpdate != null) {
			CDFromDB = updatedCD;
			manager.merge(CDFromDB);
		}
		return "{\"message\": \"CDsucessfully updated\"}";
	}

	private CD findCD(Long id) {
		return manager.find(CD.class, id);
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}
	

}
