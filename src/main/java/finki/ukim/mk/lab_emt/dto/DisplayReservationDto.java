package finki.ukim.mk.lab_emt.dto;

import finki.ukim.mk.lab_emt.model.Reservation;

import java.time.LocalDate;
import java.util.List;

public record DisplayReservationDto(Long id, String name, LocalDate oddatum, LocalDate dodatum, int smesteni, String smestuvanjeName) {

    public static DisplayReservationDto from(Reservation r) {
        return new DisplayReservationDto(
                r.getId(),
                r.getName(),
                r.getOddatum(),
                r.getDodatum(),
                r.getSmesteni(),
                r.getSmestuvanje().getName()
        );
    }

    public static List<DisplayReservationDto> from(List<Reservation> list) {
        return list.stream().map(DisplayReservationDto::from).toList();
    }
}

