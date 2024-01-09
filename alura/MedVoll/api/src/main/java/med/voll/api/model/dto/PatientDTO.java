package med.voll.api.model.dto;

public record PatientDTO(
        String name,
        String email,
        String phone,
        String taxId,
        AddressDTO address
) {
}
