package finki.ukim.mk.lab_emt.service.DomainServices.imp;

import finki.ukim.mk.lab_emt.model.Reservation;
import finki.ukim.mk.lab_emt.model.Smestuvanje;
import finki.ukim.mk.lab_emt.model.User;
import finki.ukim.mk.lab_emt.model.exceptions.SmestuvanjeIsIznajmenoExeption;
import finki.ukim.mk.lab_emt.repository.ReservationRepository;
import finki.ukim.mk.lab_emt.repository.SmestuvanjeRepository;
import finki.ukim.mk.lab_emt.repository.UserRepository;
import finki.ukim.mk.lab_emt.service.DomainServices.ReservationDomainService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservationDomainServiceimp implements ReservationDomainService {
    private final ReservationRepository reservationRepository;
    private  final SmestuvanjeRepository smestuvanjeRepository;
    private  final UserRepository userRepository;

    public ReservationDomainServiceimp(ReservationRepository reservationRepository, SmestuvanjeRepository smestuvanjeRepository, UserRepository userRepository) {
        this.reservationRepository = reservationRepository;
        this.smestuvanjeRepository = smestuvanjeRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Optional<Reservation> addTemporaryReservation(Reservation reservation) {
        if(reservation.getSmestuvanje().isIznajmeno()){
            throw new SmestuvanjeIsIznajmenoExeption("Iznajmeno");
        }
        return Optional.of(reservationRepository.save(reservation));
    }


    @Override
    public List<Reservation> getTemporaryReservationsForUser(String username) {
        return reservationRepository.findAll().stream().filter(reservation -> reservation.getUser().getUsername().equals(username)&&!reservation.isConfirmed()).collect(Collectors.toList());

    }

    @Override
    public void confirmAllReservationsForUser(String username) {
        List<Reservation> reservations = getTemporaryReservationsForUser(username);
        reservations.forEach(reservation -> {
            reservation.setConfirmed(true);
            Smestuvanje smestuvanje =smestuvanjeRepository.findById(reservation.getSmestuvanje().getId()).get();

            smestuvanje.setIznajmeno(true);

            smestuvanjeRepository.save(smestuvanje);
            reservationRepository.save(reservation);
        });
    }


    @Override
    public Optional<Reservation> save(Reservation reservation) {
        return Optional.of(reservationRepository.save(new Reservation(reservation.getSmestuvanje(),reservation.getSmesteni(),reservation.getDodatum(),reservation.getOddatum(),reservation.getName(),reservation.getUser())));
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
    public Optional<Reservation> update(Long id, Reservation reservation,String username) {
        return reservationRepository.findById(id).map(exist->{
            exist.setName(reservation.getName());
            exist.setSmesteni(reservation.getSmesteni());
            exist.setDodatum(reservation.getDodatum());
            exist.setOddatum(reservation.getOddatum());
            exist.setSmestuvanje(reservation.getSmestuvanje());
            exist.setUser(userRepository.findByUsername(username).get());
//            exist.setConfirmed(reservation.isConfirmed());
            return reservationRepository.save(exist);
        });
    }

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }


}
