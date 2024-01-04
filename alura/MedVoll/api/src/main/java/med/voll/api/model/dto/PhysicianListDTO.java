package med.voll.api.model.dto;

import med.voll.api.model.Physician;
import med.voll.api.model.Specialty;

public record PhysicianListDTO(
        String name,
        String email,
        String crm,
        Specialty specialty
) {
    public PhysicianListDTO(Physician physician) {
        this(physician.getName(), physician.getEmail(), physician.getCrm(), physician.getSpecialty());
    }
}
