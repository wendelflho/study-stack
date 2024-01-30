package med.voll.api.repository;

import med.voll.api.domain.physician.Physician;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

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
}
