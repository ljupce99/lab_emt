package finki.ukim.mk.lab_emt.service.ApplicationServices.imp;

import finki.ukim.mk.lab_emt.dto.CreateReservationDto;
import finki.ukim.mk.lab_emt.dto.DisplayReservationDto;
import finki.ukim.mk.lab_emt.service.ApplicationServices.ReservationApplicationService;
import finki.ukim.mk.lab_emt.service.DomainServices.ReservationDomainService;
import finki.ukim.mk.lab_emt.service.DomainServices.SmestuvanjeDomainService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationApplicationServiceimp implements ReservationApplicationService {
    private final ReservationDomainService reservationDomainService;
    private final SmestuvanjeDomainService smestuvanjeDomainService;

    public ReservationApplicationServiceimp(ReservationDomainService reservationDomainService, SmestuvanjeDomainService smestuvanjeDomainService) {
        this.reservationDomainService = reservationDomainService;
        this.smestuvanjeDomainService = smestuvanjeDomainService;
    }

    @Override
    public Optional<DisplayReservationDto> save(CreateReservationDto reservation) {
        return reservationDomainService.save(reservation.toReservation(smestuvanjeDomainService.findById(reservation.smestuvanjeId()).get())).map(DisplayReservationDto::from);
    }

    @Override
    public Optional<DisplayReservationDto> findById(Long id) {
        return reservationDomainService.findById(id).map(DisplayReservationDto::from);
    }

    @Override
    public void delete(Long id) {
        reservationDomainService.delete(id);
    }

    @Override
    public Optional<DisplayReservationDto> update(Long id, CreateReservationDto reservation) {
        return reservationDomainService.update(id,reservation.toReservation(smestuvanjeDomainService.findById(reservation.smestuvanjeId()).get())).map(DisplayReservationDto::from);
    }

    @Override
    public List<DisplayReservationDto> findAll() {
        return DisplayReservationDto.from(reservationDomainService.findAll());
    }
}
