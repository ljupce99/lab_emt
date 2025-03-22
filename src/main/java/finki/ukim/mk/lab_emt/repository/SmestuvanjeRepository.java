package finki.ukim.mk.lab_emt.repository;

import finki.ukim.mk.lab_emt.model.Smestuvanje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmestuvanjeRepository extends JpaRepository<Smestuvanje,Long> {
}
