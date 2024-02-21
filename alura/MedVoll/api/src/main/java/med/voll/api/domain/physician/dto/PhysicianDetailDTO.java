package med.voll.api.domain.physician.dto;

import med.voll.api.domain.address.Address;
import med.voll.api.domain.physician.Specialty;
import med.voll.api.domain.physician.Physician;

public record PhysicianDetailDTO(
        Long id,
        String name,
        String email,
        String crm,
        String phone,
        Specialty specialty,
        Address address
) {
    public PhysicianDetailDTO(Physician physician) {
        this(
                physician.getId(),
                physician.getName(),
                physician.getEmail(),
                physician.getCrm(),
                physician.getPhone(),
                physician.getSpecialty(),
                physician.getAddress()
        );
    }
}
