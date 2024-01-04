package med.voll.api.service;

import med.voll.api.model.Patient;
import med.voll.api.model.dto.PatientDTO;
import med.voll.api.model.dto.PatientListDTO;
import med.voll.api.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    public Patient createPatient(PatientDTO patientDTO) {
        Patient patient = new Patient(patientDTO);
        return patientRepository.save(patient);
    }

    public Page<PatientListDTO> patientList(Pageable pageable) {
        return patientRepository
                .findAll(pageable)
                .map(PatientListDTO::new);
    }

}
