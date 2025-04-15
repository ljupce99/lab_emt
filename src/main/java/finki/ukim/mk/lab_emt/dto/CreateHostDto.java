package finki.ukim.mk.lab_emt.dto;

import finki.ukim.mk.lab_emt.model.Country;
import finki.ukim.mk.lab_emt.model.Host;
public record CreateHostDto(String name, String surname, Long countryId) {

    public Host toHost(Country country) {
        Host host = new Host();
        host.setName(name);
        host.setSurname(surname);
        host.setCountry(country);
        return host;
    }
}
