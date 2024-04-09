package med.voll.api.domain.patient.dto;

import med.voll.api.domain.patient.Patient;

public record PatientListDTO(
        Long id,
        String name,
        String email,
        String taxId
) {

    public PatientListDTO(Patient patient) {
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getTaxId());
    }
}
