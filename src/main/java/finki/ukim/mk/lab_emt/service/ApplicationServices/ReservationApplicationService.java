package finki.ukim.mk.lab_emt.service.ApplicationServices;

import finki.ukim.mk.lab_emt.dto.CreateReservationDto;
import finki.ukim.mk.lab_emt.dto.DisplayReservationDto;
import finki.ukim.mk.lab_emt.model.Reservation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ReservationApplicationService {

    public Optional<DisplayReservationDto> addTemporaryReservation(CreateReservationDto reservation ,String username);

    public List<DisplayReservationDto> getTemporaryReservationsForUser(String username);

    public void confirmAllReservationsForUser(String username);


    public Optional<DisplayReservationDto> save(CreateReservationDto reservation);//
    public Optional<DisplayReservationDto> findById(Long id);//
    public void delete(Long id);//
    public Optional<DisplayReservationDto> update(Long id,CreateReservationDto reservation,String username);//
    public List<DisplayReservationDto> findAll(); //


}
