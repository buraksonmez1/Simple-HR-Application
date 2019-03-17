package com.example.hr.dao;

import com.example.hr.model.JobListings;
import org.springframework.data.repository.CrudRepository;

public interface JobListingRepository extends CrudRepository<JobListings,Integer> {



}
