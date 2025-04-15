package finki.ukim.mk.lab_emt.dto;

import finki.ukim.mk.lab_emt.model.Country;

public record CreateCountryDto(String name, String continent) {

    public Country toCountry() {
        Country c = new Country();
        c.setName(name);
        c.setContinent(continent);
        return c;
    }
}
