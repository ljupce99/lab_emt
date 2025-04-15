package finki.ukim.mk.lab_emt.web;

import finki.ukim.mk.lab_emt.model.Reservation;
import finki.ukim.mk.lab_emt.model.dto.ReservationDto;
import finki.ukim.mk.lab_emt.service.DomainServices.ReservationDomainService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {
    private final ReservationDomainService reservationDomainService;

    public ReservationController(ReservationDomainService reservationDomainService) {
        this.reservationDomainService = reservationDomainService;
    }

    @GetMapping("/list")
    public List<Reservation> getAllreservation() {
        return reservationDomainService.findAll();
    }


    @PostMapping("/add")
    public Reservation addReservation(@RequestBody ReservationDto reservationDto ) {
        return reservationDomainService.save(reservationDto);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteReservation(@PathVariable Long id) {
        reservationDomainService.delete(id);
        return "redirect:/api/reservation/list";
    }
    @PostMapping("/edit/{id}")
    public Reservation editReservation(@PathVariable Long id, @RequestBody ReservationDto reservationDto) {
        return reservationDomainService.update(id,reservationDto).get();
    }



}
