package finki.ukim.mk.lab_emt.model;

import finki.ukim.mk.lab_emt.model.enums.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Smestuvanje {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @Enumerated(EnumType.STRING)
    Category category;
    @ManyToOne
    Host host;
    Integer numRooms;

    boolean iznajmeno = false;

    public Smestuvanje(String name, Category category, Host host, Integer numRooms) {
        this.name = name;
        this.category = category;
        this.host = host;
        this.numRooms = numRooms;
    }

}
