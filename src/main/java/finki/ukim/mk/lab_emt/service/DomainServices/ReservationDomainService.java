package finki.ukim.mk.lab_emt.service.DomainServices;

import finki.ukim.mk.lab_emt.model.Reservation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ReservationDomainService {
    public Optional<Reservation> save(Reservation reservation);//
    public Optional<Reservation> findById(Long id);//
    public void delete(Long id);//
    public Optional<Reservation> update(Long id, Reservation reservation);//
    public List<Reservation> findAll(); //

}
