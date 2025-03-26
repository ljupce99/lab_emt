package finki.ukim.mk.lab_emt.model.dto;

import finki.ukim.mk.lab_emt.model.Country;
import finki.ukim.mk.lab_emt.model.Host;
import finki.ukim.mk.lab_emt.service.CountryService;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class HostDto {
    String name;
    String surname;
    Long country;


    public HostDto(String name, Long country, String surname) {
        this.name = name;
        this.country = country;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCountry() {
        return country;
    }

    public void setCountry(Long country) {
        this.country = country;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public static HostDto toDto(Host host) {
        return new HostDto(host.getName(), host.getCountry().getId(), host.getSurname());
    }
//    public static Host fromDto(HostDto hostDto) {
//        return new Host(hostDto.getName(), hostDto.surname,hostDto.country);
//    }
}
