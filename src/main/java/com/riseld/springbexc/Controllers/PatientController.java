package com.riseld.springbexc.Controllers;

import com.riseld.springbexc.Models.Patient;
import com.riseld.springbexc.Services.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService service;
    PatientController(PatientService service){
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getbyId(@PathVariable Long id){
        return service.getbyId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Patient>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping
    public ResponseEntity<Patient> update(@RequestBody Long id, Patient newpatient){
        return service.update(id, newpatient)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }


    @PostMapping("/add")
    public Patient create(@RequestBody Patient newpat){
        return service.add(newpat);
    }
}
