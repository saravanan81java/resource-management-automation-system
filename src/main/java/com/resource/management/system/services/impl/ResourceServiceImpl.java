package com.resource.management.system.services.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resource.management.system.model.Resource;
import com.resource.management.system.repository.ResourceRepository;
import com.resource.management.system.services.ResourceService;

@Service
public class ResourceServiceImpl implements ResourceService{
	
	@Autowired
    private ResourceRepository resourceRepository;
    

    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }

    public Resource addResource(Resource resource) {
    	resource.setLastUpdated(LocalDateTime.now());
        return resourceRepository.save(resource);
    }
    
    public Resource updateResource(Long id, Resource resourceDetails) {
        Resource resource = resourceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Resource not found"));

        resource.setName(resourceDetails.getName());
        resource.setCategory(resourceDetails.getCategory());
        resource.setQuantity(resourceDetails.getQuantity());
        resource.setThreshold(resourceDetails.getThreshold());
        resource.setLastUpdated(LocalDateTime.now());

        return resourceRepository.save(resource);
    }

    public List<Resource> getLowStockResources() {
        return resourceRepository.findByQuantityLessThan(10);
    }

}
