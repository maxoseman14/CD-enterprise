package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.qa.persistence.domain.CD;
import com.qa.util.JSONUtil;


@ApplicationScoped
@Alternative
public class CDMapRepository implements CDRepository {
	
	private final Long INITIAL_COUNT = 1L;
	private Map<Long, CD> cdMap;
	private Long ID;
	
	@Inject
	private JSONUtil util;

	
	public CDMapRepository() {
		this.cdMap = new HashMap<Long, CD>();
		ID = INITIAL_COUNT;
		initCDMap();
	}
	
	
	public String getAllCDs() {
		return util.getJSONForObject(cdMap.values());
		
	}

	public String createCD(String cd) {
		ID++;
		CD newCD = util.getObjectForJSON(cd, CD.class);
		cdMap.put(ID, newCD);
		return cd;
	}

	public String deleteCD(Long id) {
		cdMap.remove(id);
		return "{\"message\": \"accout sucessfully removed\"}";
	}

	public String updateCD(Long id, String cdToUpdate) {
		CD newCD = util.getObjectForJSON(cdToUpdate, CD.class);
		cdMap.put(id, newCD);
		return cdToUpdate;
	}
	
	private void initCDMap() {
		CD cd = new CD ();
		cdMap.put(1L, cd);
	}
	

}
