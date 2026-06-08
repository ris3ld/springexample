package com.riseld.springbexc.Services;

import com.riseld.springbexc.Models.Doctor;
import com.riseld.springbexc.Repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    private final DoctorRepository repo;

    public DoctorService(DoctorRepository repo){
        this.repo = repo;
    }

    public List<Doctor> getAll(){
        return repo.findAll();
    }

    public Optional<Doctor> getbyId(Long id){
        return repo.findById(id);
    }

    public Doctor add(Doctor newdoc){
        return repo.save(newdoc);
    }

    public Optional<Doctor> update(Long id, Doctor newupDoc){
        return repo.findById(id).map(existing ->{
            existing.setFirstName(newupDoc.getFirstName());
            existing.setLastName(newupDoc.getLastName());
            existing.setEmail(newupDoc.getEmail());
            existing.setSpeciality(newupDoc.getSpeciality());
            return repo.save(newupDoc);
        });
    }


}
