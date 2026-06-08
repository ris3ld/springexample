package com.riseld.springbexc.Repository;

import com.riseld.springbexc.Models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {


    Optional<Patient> findByFirstName(String firstName);
}
