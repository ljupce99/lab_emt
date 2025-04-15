package finki.ukim.mk.lab_emt.dto;

import finki.ukim.mk.lab_emt.model.Host;

import java.util.List;

public record DisplayHostDto(Long id, String name, String surname, String country) {

    public static DisplayHostDto from(Host h) {
        return new DisplayHostDto(
                h.getId(),
                h.getName(),
                h.getSurname(),
                h.getCountry().getName()
        );
    }

    public static List<DisplayHostDto> from(List<Host> list) {
        return list.stream().map(DisplayHostDto::from).toList();
    }
}
