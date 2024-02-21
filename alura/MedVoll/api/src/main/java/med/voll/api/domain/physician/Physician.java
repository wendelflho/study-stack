package med.voll.api.domain.physician;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.domain.address.Address;
import med.voll.api.domain.physician.dto.PhysicianDTO;
import med.voll.api.domain.physician.dto.PhysicianUpdateDTO;

@Table(name = "physicians")
@Entity(name = "Physician")
@Getter
@Setter
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

    private Boolean active;

    public Physician(PhysicianDTO physicianDTO) {
        this.active = true;
        this.name = physicianDTO.name();
        this.email = physicianDTO.email();
        this.phone = physicianDTO.phone();
        this.crm = physicianDTO.crm();
        this.specialty = physicianDTO.specialty();
        this.address = new Address(physicianDTO.address());
    }

    public void updateInfo(PhysicianUpdateDTO physicianUpdate) {
        if (physicianUpdate.name() != null) {
            this.name = physicianUpdate.name();
        }
        if (physicianUpdate.phone() != null) {
            this.phone = physicianUpdate.phone();
        }
        if (physicianUpdate.address() != null) {
            this.address.updateInfo(physicianUpdate.address());
        }
    }

    public void delete() {
        this.active = false;
    }
}
