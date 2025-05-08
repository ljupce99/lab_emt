package finki.ukim.mk.lab_emt.dto;

import finki.ukim.mk.lab_emt.model.Host;

import java.util.List;

public record DisplayHostAndCountryDto(Long id, String name, String surname, DisplayCountryDto country) {

    public static DisplayHostAndCountryDto from(Host h) {
        return new DisplayHostAndCountryDto(
                h.getId(),
                h.getName(),
                h.getSurname(),
                DisplayCountryDto.from(h.getCountry())
        );
    }

    public static List<DisplayHostDto> from(List<Host> list) {
        return list.stream().map(DisplayHostDto::from).toList();
    }
}
