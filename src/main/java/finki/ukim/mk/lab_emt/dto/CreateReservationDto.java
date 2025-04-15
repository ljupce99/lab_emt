package finki.ukim.mk.lab_emt.dto;

import finki.ukim.mk.lab_emt.model.Reservation;
import finki.ukim.mk.lab_emt.model.Smestuvanje;
import finki.ukim.mk.lab_emt.model.User;

import java.time.LocalDate;
public record CreateReservationDto(String name, LocalDate oddatum, LocalDate dodatum, int smesteni, Long smestuvanjeId, String user) {

    public Reservation toReservation(Smestuvanje smestuvanje, User user) {
        Reservation r = new Reservation();
        r.setName(name);
        r.setOddatum(oddatum);
        r.setDodatum(dodatum);
        r.setSmesteni(smesteni);
        r.setSmestuvanje(smestuvanje);
        r.setUser(user);

        return r;
    }
}