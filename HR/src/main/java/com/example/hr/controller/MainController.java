package com.example.hr.controller;


import com.example.hr.model.Applicant;
import com.example.hr.model.Person;

import com.example.hr.services.JobService;
import com.example.hr.services.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

 @Autowired
 ApplicantService applicantService;

 @Autowired
    JobService jobService;

    @PostMapping(path="/save-applicant")
    public String saveApplicant(@ModelAttribute Applicant applicant, BindingResult bindingResult, HttpServletRequest request ){


        applicantService.save(applicant);
        request.setAttribute("jobs",jobService.findAll());
        request.setAttribute("mode","MODE_HOME");


        return "index";

    }


    @GetMapping("/see-details")
    public String createJob(HttpServletRequest request ){

        request.setAttribute("mode","MODE_DETAILS");

        return "index";


    }


}
