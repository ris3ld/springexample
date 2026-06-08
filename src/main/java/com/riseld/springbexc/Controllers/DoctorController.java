package com.riseld.springbexc.Controllers;

import com.riseld.springbexc.Models.Doctor;
import com.riseld.springbexc.Services.DoctorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService service;

    public DoctorController(DoctorService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Doctor>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getById(@PathVariable Long id){
        return service.getbyId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<Doctor> update(@PathVariable Long id, @Valid @RequestBody Doctor doctor){
        return service.update(id, doctor)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

   /* @GetMapping("/search")
    public List searchDoc(@RequestParam String specialty){

    }

    @GetMapping
    public Long allSpecials(@RequestParam String specialty){

    }

    @PostMapping
    public Doctor create(@RequestBody Doctor doctor){
    }
    \*
    */
}
