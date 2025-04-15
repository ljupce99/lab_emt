package finki.ukim.mk.lab_emt.service.ApplicationServices;

import finki.ukim.mk.lab_emt.dto.CreateReservationDto;
import finki.ukim.mk.lab_emt.dto.DisplayReservationDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ReservationApplicationService {
    public Optional<DisplayReservationDto> save(CreateReservationDto reservation);//
    public Optional<DisplayReservationDto> findById(Long id);//
    public void delete(Long id);//
    public Optional<DisplayReservationDto> update(Long id,CreateReservationDto reservation);//
    public List<DisplayReservationDto> findAll(); //


}
