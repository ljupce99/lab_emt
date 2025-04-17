package finki.ukim.mk.lab_emt.web;

import finki.ukim.mk.lab_emt.dto.CreateReservationDto;
import finki.ukim.mk.lab_emt.dto.DisplayReservationDto;
import finki.ukim.mk.lab_emt.model.exceptions.SmestuvanjeIsIznajmenoExeption;
import finki.ukim.mk.lab_emt.service.ApplicationServices.ReservationApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<?> addReservation(@RequestBody CreateReservationDto dto) {
        String usernam = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<DisplayReservationDto> dtoret;
        try {
//            dto.
            dtoret = reservationApplicationService.addTemporaryReservation(dto,usernam);

        }catch (SmestuvanjeIsIznajmenoExeption e) {
//            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("No rooms available for this accommodation.");

        }
        return ResponseEntity.ok(dtoret.get());

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


    @GetMapping("/list")
    public List<DisplayReservationDto> getAllreservation() {
        return reservationApplicationService.findAll();
    }


//    @PostMapping("/add")
//    public DisplayReservationDto addReservation(@RequestBody CreateReservationDto reservationDto ) {
//        return reservationApplicationService.save(reservationDto);
//    }

    @DeleteMapping("/delete/{id}")
    public void deleteReservation(@PathVariable Long id) {
        reservationApplicationService.delete(id);
    }
    @PostMapping("/edit/{id}")
    public DisplayReservationDto editReservation(@PathVariable Long id, @RequestBody CreateReservationDto reservationDto) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        return reservationApplicationService.update(id,reservationDto,username).get();
    }

}
//statistika kolku smestuvanja ima
