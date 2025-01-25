package com.resource.management.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resource.management.system.model.Resource;
import com.resource.management.system.services.ResourceService;

@RestController
@RequestMapping("/resources")
public class ResourceController {
	@Autowired
    private ResourceService resourceService;

    @GetMapping
    public List<Resource> getAllResources() {
        return resourceService.getAllResources();
    }

    @PostMapping
    public Resource addResource(@RequestBody Resource resource) {
        return resourceService.addResource(resource);
    }

    // Update an existing resource
    @PutMapping("/{id}")
    public ResponseEntity<Resource> updateResource(
            @PathVariable Long id,
            @RequestBody Resource resourceDetails) {
        return ResponseEntity.ok(resourceService.updateResource(id, resourceDetails));
    }

    // Get low stock resources
    @GetMapping("/low-stock")
    public List<Resource> getLowStockResources() {
        return resourceService.getLowStockResources();
    }
}
