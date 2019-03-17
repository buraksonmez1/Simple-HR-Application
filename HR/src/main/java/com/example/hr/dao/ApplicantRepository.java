package com.example.hr.dao;

import com.example.hr.model.Applicant;
import org.springframework.data.repository.CrudRepository;

public interface ApplicantRepository extends CrudRepository<Applicant,Integer> {
}
