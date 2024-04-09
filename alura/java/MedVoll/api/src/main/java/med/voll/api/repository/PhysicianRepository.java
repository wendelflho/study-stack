package med.voll.api.repository;

import med.voll.api.domain.physician.Physician;
import med.voll.api.domain.physician.Specialty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface PhysicianRepository extends JpaRepository<Physician, Long> {
    /*
    Se montarmos um método com determinado padrão de nomenclatura
    o spring JPA consegue montar a query e gerar o comando sql
    da maneira que precisarmos

    findAll é o pai
    active é o atributo
    como é booleano, true é o valor que queremos
    */

    Page<Physician> findAllByActiveTrue(Pageable pageable);

    @Query("""
        FROM Physician ph
        WHERE ph.active = TRUE
        AND ph.specialty = :specialty
        AND ph.id NOT IN(
            SELECT sc.physician.id FROM Schedule sc
            WHERE sc.dateTime = :dateTime
        )
        ORDER BY RAND()
        LIMIT 1
    """)
    Physician findRandomPhysicianAvailableAtDate(Specialty specialty, LocalDateTime dateTime);
}
