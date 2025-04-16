//package finki.ukim.mk.lab_emt.web;
//
//import finki.ukim.mk.lab_emt.dto.CreateReservationDto;
//import finki.ukim.mk.lab_emt.dto.DisplayReservationDto;
//import finki.ukim.mk.lab_emt.service.ApplicationServices.ReservationApplicationService;
//import finki.ukim.mk.lab_emt.service.ApplicationServices.UserApplicationService;
//import io.swagger.v3.oas.annotations.Operation;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/user")
//public class UserReservation {
//    public final ReservationApplicationService reservationApplicationService;
//
//    public UserReservation(ReservationApplicationService reservationApplicationService) {
//        this.reservationApplicationService = reservationApplicationService;
//    }
//
//
//    @Operation(summary = "Add temporary reservation")
//    @PostMapping("/reservations")
//    public ResponseEntity<DisplayReservationDto> addReservation(@RequestBody CreateReservationDto dto) {
//        try {
//            return reservationApplicationService.addTemporaryReservation(dto)
//                    .map(ResponseEntity::ok)
//                    .orElse(ResponseEntity.badRequest().build());
//        } catch (IllegalArgumentException e) {
//            return ResponseEntity.badRequest().body(null);
//        }
//    }
//
//    @Operation(summary = "Get temporary reservations")
//    @GetMapping("/reservations/{username}")
//    public List<DisplayReservationDto> getTemporaryReservations(@PathVariable String username) {
//        return reservationApplicationService.getTemporaryReservationsForUser(username);
//    }
//
//    @Operation(summary = "Confirm all reservations")
//    @PostMapping("/reservations/{username}/confirm")
//    public ResponseEntity<Void> confirmReservations(@PathVariable String username) {
//        reservationApplicationService.confirmAllReservationsForUser(username);
//        return ResponseEntity.ok().build();
//    }
//}
