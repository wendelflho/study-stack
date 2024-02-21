package med.voll.api.domain.physician;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Specialty {
    ORTHOPEDICS("Orthopedics"),
    CARDIOLOGY("Cardiology"),
    GYNECOLOGY("Gynecology"),
    DERMATOLOGY("Dermatology");

    private final String description;
}
