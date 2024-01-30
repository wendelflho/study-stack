package med.voll.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import med.voll.api.domain.patient.Patient;
import med.voll.api.domain.patient.dto.PatientDTO;
import med.voll.api.domain.patient.dto.PatientListDTO;
import med.voll.api.domain.patient.dto.PatientUpdateDTO;
import med.voll.api.service.PatientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "patient")
public class PatientController {

    private final PatientService patientService;

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

    @PutMapping
    @Transactional
    public ResponseEntity<Patient> updatePatient(@RequestBody @Valid PatientUpdateDTO patientUpdate) {
        patientService.updatePatient(patientUpdate);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/{id}")
    @Transactional
    public ResponseEntity<Patient> deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return ResponseEntity.ok().build();
    }
}
