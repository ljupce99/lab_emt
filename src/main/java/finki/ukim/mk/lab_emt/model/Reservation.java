package finki.ukim.mk.lab_emt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    LocalDate oddatum;
    LocalDate dodatum;
    int smesteni;

    @ManyToOne
    Smestuvanje smestuvanje;

    public Reservation(Smestuvanje smestuvanje, int smesteni, LocalDate dodatum, LocalDate oddatum, String name) {
        this.smestuvanje = smestuvanje;
        this.smesteni = smesteni;
        this.dodatum = dodatum;
        this.oddatum = oddatum;
        this.name = name;
    }

}
