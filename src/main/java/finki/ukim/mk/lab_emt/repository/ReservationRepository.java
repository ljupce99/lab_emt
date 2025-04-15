package finki.ukim.mk.lab_emt.repository;

import finki.ukim.mk.lab_emt.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
