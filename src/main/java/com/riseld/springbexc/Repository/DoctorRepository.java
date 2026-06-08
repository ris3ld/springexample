package com.riseld.springbexc.Repository;

import com.riseld.springbexc.Models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    List findBySpeciality(String speciality);

    Optional<Doctor> findByLastName(String lastname);


    @Query("SELECT d FROM Doctor d WHERE d.firstName = :firstName")
    List<Doctor> findDoctorsByFirstName(@Param("firstName") String firstName);

    // 4. Native SQL query (example: find doctors with experience > X years)
    @Query(value = "SELECT * FROM doctors WHERE years_of_experience > :years", nativeQuery = true)
    List<Doctor> findExperiencedDoctors(@Param("years") int years);
}
