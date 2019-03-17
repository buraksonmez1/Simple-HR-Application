package com.example.hr.services;

import com.example.hr.dao.PersonRepository;
import com.example.hr.model.CustomUserDetails;
import com.example.hr.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Person>optionalPerson=personRepository.findByEmail(email);




        optionalPerson
                .orElseThrow(() -> new UsernameNotFoundException("email not found"));
        return optionalPerson
                .map(CustomUserDetails::new).get();
    }
}
