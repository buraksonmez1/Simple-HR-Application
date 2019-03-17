package com.example.hr.services;

import com.example.hr.dao.ApplicantRepository;
import com.example.hr.model.Applicant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ApplicantService {

    @Autowired
    ApplicantRepository applicantRepository;
    public void save(Applicant a){
        applicantRepository.save(a);
    }
}
