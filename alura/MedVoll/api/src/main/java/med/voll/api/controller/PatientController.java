package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.model.Patient;
import med.voll.api.model.dto.PatientDTO;
import med.voll.api.model.dto.PatientListDTO;
import med.voll.api.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    @Transactional
    public ResponseEntity<Patient> createPatient(@RequestBody @Valid PatientDTO patientDTO) {
        Patient patient = patientService.createPatient(patientDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(patient);
    }

    @GetMapping
    public ResponseEntity<Page<PatientListDTO>> patientList(
            @PageableDefault(size = 10, sort = {"name"}) Pageable pageable
    ) {
        return ResponseEntity.ok(patientService.patientList(pageable));
    }
}