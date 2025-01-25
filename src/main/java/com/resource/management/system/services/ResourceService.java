package com.resource.management.system.services;

import java.util.List;

import com.resource.management.system.model.Resource;
 

public interface ResourceService {

	public List<Resource> getAllResources();
	
	Resource addResource(Resource resource);
	
	List<Resource> getLowStockResources();
	
	Resource updateResource(Long id, Resource resourceDetails);
}
