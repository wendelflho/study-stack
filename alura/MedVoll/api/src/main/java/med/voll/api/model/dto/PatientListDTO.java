package med.voll.api.model.dto;

import med.voll.api.model.Patient;

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
