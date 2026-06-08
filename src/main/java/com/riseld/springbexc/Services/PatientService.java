package com.riseld.springbexc.Services;

import com.riseld.springbexc.Models.Patient;
import com.riseld.springbexc.Repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository prepo;

    public PatientService(PatientRepository prepo){
        this.prepo = prepo;
    }

    public List<Patient> getAll(){
        return prepo.findAll();
    }

    public Optional<Patient> getbyId(Long id){
        return prepo.findById(id);
    }

    public Patient add(Patient newpatient){
        return prepo.save(newpatient);
    }

    public Optional<Patient> update(Long id, Patient updatedpatient){
        return prepo.findById(id).map(existing -> {
            existing.setFirstName(updatedpatient.getFirstName());
            existing.setLastName(updatedpatient.getLastName());
            existing.setEmail(updatedpatient.getEmail());
            return prepo.save(updatedpatient);
        });
    }

}
