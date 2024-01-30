package med.voll.api.service;

import lombok.RequiredArgsConstructor;
import med.voll.api.domain.patient.Patient;
import med.voll.api.domain.patient.dto.PatientDTO;
import med.voll.api.domain.patient.dto.PatientListDTO;
import med.voll.api.domain.patient.dto.PatientUpdateDTO;
import med.voll.api.repository.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public Patient createPatient(PatientDTO patientDTO) {
        Patient patient = new Patient(patientDTO);
        return patientRepository.save(patient);
    }

    public Page<PatientListDTO> patientList(Pageable pageable) {
        return patientRepository
                .findAllByActiveTrue(pageable)
                .map(PatientListDTO::new);
    }

    public void updatePatient(PatientUpdateDTO patientUpdate) {
        var patient = patientRepository.getReferenceById(patientUpdate.id());
        patient.updateInfo(patientUpdate);
    }

    public void deletePatient(Long id) {
        var patient = patientRepository.getReferenceById(id);
        patient.delete();
    }

}
