package finki.ukim.mk.lab_emt.dto;

import finki.ukim.mk.lab_emt.model.Country;

import java.util.List;

public record DisplayCountryDto(Long id, String name, String continent) {

    public static DisplayCountryDto from(Country c) {
        return new DisplayCountryDto(c.getId(), c.getName(), c.getContinent());
    }

    public static List<DisplayCountryDto> from(List<Country> list) {
        return list.stream().map(DisplayCountryDto::from).toList();
    }
}

