package com.example.hr.services;

import com.example.hr.dao.JobListingRepository;
import com.example.hr.model.JobListings;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class JobService  {


   private  final JobListingRepository jobListingRepository;

    public JobService(JobListingRepository jobListingRepository) {
        this.jobListingRepository = jobListingRepository;
    }

    public List<JobListings>findAll(){
        List<JobListings>jobs =new ArrayList<>();
        for(JobListings job :jobListingRepository.findAll() ){
            jobs.add(job);
        }

            return jobs;
    }
    public JobListings findJobWith(int id){
        return jobListingRepository.findById(id).get();
    }

    public void save(JobListings job){

        jobListingRepository.save(job);

    }
    public void delete(int id){

        jobListingRepository.deleteById(id);
    }



}
