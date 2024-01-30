package med.voll.api.domain.patient.dto;

import med.voll.api.domain.address.dto.AddressDTO;

public record PatientDTO(
        String name,
        String email,
        String phone,
        String taxId,
        AddressDTO address
) {
}
