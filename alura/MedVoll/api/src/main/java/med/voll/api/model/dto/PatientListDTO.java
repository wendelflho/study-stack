package med.voll.api.model.dto;

import med.voll.api.model.Patient;

public record PatientListDTO(
        String name,
        String email,
        String taxId
) {

    public PatientListDTO(Patient patient) {
        this(patient.getName(), patient.getEmail(), patient.getTaxId());
    }
}
