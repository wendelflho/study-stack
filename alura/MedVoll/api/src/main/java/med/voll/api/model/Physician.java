package med.voll.api.model;

public record Physician(
        String name,
        String email,
        String crm,
        Specialty specialty,
        Address address
) {
}
