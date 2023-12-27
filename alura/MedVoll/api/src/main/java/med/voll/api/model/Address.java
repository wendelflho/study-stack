package med.voll.api.model;

public record Address(
        String publicPlace,
        String district,
        String zipCode,
        String city,
        String fu,
        String number,
        String complement
) {
}
