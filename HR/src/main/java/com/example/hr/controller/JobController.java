package com.example.hr.controller;



import com.example.hr.model.JobListings;
import com.example.hr.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class JobController {


    @Autowired
    JobService jobService;

    @GetMapping("/")
    public String getJobs(HttpServletRequest request){

         request.setAttribute("jobs",jobService.findAll());
        request.setAttribute("mode","MODE_HOME");
        return "index";


    }
    @GetMapping("/new-job")
    public String createJob(HttpServletRequest request ){
        request.setAttribute("mode","MODE_NEW");

        return "index";


    }

    @PostMapping("/save-job")
    public String saveJob(@ModelAttribute JobListings newJob, BindingResult bindingResult, HttpServletRequest request ){
        newJob.setLastApplicationDate(new Date());

        jobService.save(newJob);
        request.setAttribute("jobs",jobService.findAll());
        request.setAttribute("mode","MODE_HOME");


        return "index";


    }
    @GetMapping("/update-job")
    public String updateJobs(@RequestParam int id ,HttpServletRequest request){

        request.setAttribute("jobs",jobService.findJobWith(id));
        request.setAttribute("mode","MODE_UPDATE");
        return "index";


    }



    @DeleteMapping("/delete-jobs ")
    public String deleteJob(@RequestParam int id, HttpServletRequest request){

        jobService.delete(id);
        request.setAttribute("jobs",jobService.findAll());
        request.setAttribute("mode","MODE_UPDATE");
        return "delete was called";

    }





}
