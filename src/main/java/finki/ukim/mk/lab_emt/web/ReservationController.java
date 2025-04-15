package finki.ukim.mk.lab_emt.web;

import finki.ukim.mk.lab_emt.dto.CreateReservationDto;
import finki.ukim.mk.lab_emt.dto.DisplayReservationDto;
import finki.ukim.mk.lab_emt.service.ApplicationServices.ReservationApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservation")
@Tag(name = "Reservations api", description = "Endpoints for managing reservations")

public class ReservationController {
    private final ReservationApplicationService reservationApplicationService;

    public ReservationController(ReservationApplicationService reservationApplicationService) {
        this.reservationApplicationService = reservationApplicationService;
    }
    @Operation(summary = "get list of all reservations")
    @GetMapping("/list")
    public List<DisplayReservationDto> getAllreservation() {
        return reservationApplicationService.findAll();
    }

    @Operation(summary = "add new reservation to app")
    @PostMapping("/add")
    public DisplayReservationDto addReservation(@RequestBody CreateReservationDto reservationDto ) {
        return reservationApplicationService.save(reservationDto).get();
    }
    @Operation(summary = "delete reservation with id")
    @DeleteMapping("/delete/{id}")
    public void deleteReservation(@PathVariable Long id) {
        reservationApplicationService.delete(id);
//        return "redirect:/api/reservation/list";
    }
    @Operation(summary = "edit reservation with id")
    @PostMapping("/edit/{id}")
    public DisplayReservationDto editReservation(@PathVariable Long id, @RequestBody CreateReservationDto reservationDto) {
        return reservationApplicationService.update(id,reservationDto).get();
    }



}
