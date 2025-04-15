package finki.ukim.mk.lab_emt.dto;

import finki.ukim.mk.lab_emt.model.Reservation;
import finki.ukim.mk.lab_emt.model.Smestuvanje;

import java.time.LocalDate;
public record CreateReservationDto(String name, LocalDate oddatum, LocalDate dodatum, int smesteni, Long smestuvanjeId) {

    public Reservation toReservation(Smestuvanje smestuvanje) {
        Reservation r = new Reservation();
        r.setName(name);
        r.setOddatum(oddatum);
        r.setDodatum(dodatum);
        r.setSmesteni(smesteni);
        r.setSmestuvanje(smestuvanje);
        return r;
    }
}
