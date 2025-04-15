package finki.ukim.mk.lab_emt.dto;

import finki.ukim.mk.lab_emt.model.Host;
import finki.ukim.mk.lab_emt.model.Smestuvanje;
import finki.ukim.mk.lab_emt.model.enums.Category;

public record CreateSmestuvanjeDto(String name, Long categoryId, Long hostId, Integer numRooms) {

    public Smestuvanje toSmestuvanje(Category category, Host host) {
        Smestuvanje smestuvanje = new Smestuvanje();
        smestuvanje.setName(name);
        smestuvanje.setCategory(category);
        smestuvanje.setHost(host);
        smestuvanje.setNumRooms(numRooms);
        return smestuvanje;
    }
}
