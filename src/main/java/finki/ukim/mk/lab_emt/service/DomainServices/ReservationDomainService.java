package finki.ukim.mk.lab_emt.service.DomainServices;

import finki.ukim.mk.lab_emt.model.Reservation;
import finki.ukim.mk.lab_emt.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ReservationDomainService {

    public Optional<Reservation> addTemporaryReservation(Reservation reservation );

    public List<Reservation> getTemporaryReservationsForUser(String username);

    public void confirmAllReservationsForUser(String username);

//
    public Optional<Reservation> save(Reservation reservation);//
    public Optional<Reservation> findById(Long id);//
    public void delete(Long id);//
    public Optional<Reservation> update(Long id, Reservation reservation);//
    public List<Reservation> findAll(); //

}
