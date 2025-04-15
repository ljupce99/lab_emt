package finki.ukim.mk.lab_emt.web;

import finki.ukim.mk.lab_emt.dto.CreateReservationDto;
import finki.ukim.mk.lab_emt.dto.DisplayReservationDto;
import finki.ukim.mk.lab_emt.service.ApplicationServices.ReservationApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @Operation(summary = "Add temporary reservation")
    @PostMapping("/reservations")
    public DisplayReservationDto addReservation(@RequestBody CreateReservationDto dto) {
        String usernam = SecurityContextHolder.getContext().getAuthentication().getName();
        return reservationApplicationService.addTemporaryReservation(dto,usernam).get();
    }

    @Operation(summary = "Get temporary reservations")
    @GetMapping("/reservations/list")
    public List<DisplayReservationDto> getTemporaryReservations() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return reservationApplicationService.getTemporaryReservationsForUser(username);
    }

    @Operation(summary = "Confirm all reservations")
    @PostMapping("/reservations/confirm")
    public void confirmReservations() {
        String usernam = SecurityContextHolder.getContext().getAuthentication().getName();
        reservationApplicationService.confirmAllReservationsForUser(usernam);
    }


}
