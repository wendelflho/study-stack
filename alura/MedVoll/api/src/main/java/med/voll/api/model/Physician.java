package med.voll.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.model.dto.PhysicianDTO;

@Table(name = "physicians")
@Entity(name = "Physician")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Physician {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    @Embedded
    private Address address;

    public Physician(PhysicianDTO physicianDTO) {
        this.name = physicianDTO.name();
        this.email = physicianDTO.email();
        this.phone = physicianDTO.phone();
        this.crm = physicianDTO.crm();
        this.specialty = physicianDTO.specialty();
        this.address = new Address(physicianDTO.address());
    }
}
