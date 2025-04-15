package finki.ukim.mk.lab_emt.service.DomainServices.imp;

import finki.ukim.mk.lab_emt.model.Reservation;
import finki.ukim.mk.lab_emt.repository.ReservationRepository;
import finki.ukim.mk.lab_emt.service.DomainServices.ReservationDomainService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationDomainServiceimp implements ReservationDomainService {
    private final ReservationRepository reservationRepository;

    public ReservationDomainServiceimp(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }


    @Override
    public Optional<Reservation> save(Reservation reservation) {
        return Optional.of(reservationRepository.save(new Reservation(reservation.getSmestuvanje(),reservation.getSmesteni(),reservation.getDodatum(),reservation.getOddatum(),reservation.getName())));
    }

    @Override
    public Optional<Reservation> findById(Long id) {
        return reservationRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public Optional<Reservation> update(Long id, Reservation reservation) {
        return reservationRepository.findById(id).map(exist->{
            exist.setName(reservation.getName());
            exist.setSmesteni(reservation.getSmesteni());
            exist.setDodatum(reservation.getDodatum());
            exist.setOddatum(reservation.getOddatum());
            exist.setSmestuvanje(reservation.getSmestuvanje());
            return reservationRepository.save(exist);
        });
    }

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }
}
