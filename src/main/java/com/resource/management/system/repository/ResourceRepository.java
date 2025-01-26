package com.resource.management.system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resource.management.system.model.Resource;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {

    // Custom query to find resources below the threshold
    List<Resource> findByQuantityLessThan(int threshold); 
    

}
