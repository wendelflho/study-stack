package med.voll.api.model;

public record Patient(
        String name,
        String email,
        String phone,
        String taxId,
        Address address
) {
}
