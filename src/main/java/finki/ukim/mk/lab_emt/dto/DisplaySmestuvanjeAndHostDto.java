package finki.ukim.mk.lab_emt.dto;

import finki.ukim.mk.lab_emt.model.Smestuvanje;

import java.util.List;

public record DisplaySmestuvanjeAndHostDto(Long id, String name, String category, DisplayHostAndCountryDto hostName, Integer numRooms,boolean iznajmeno) {

    public static DisplaySmestuvanjeAndHostDto from(Smestuvanje s) {
        return new DisplaySmestuvanjeAndHostDto(
                s.getId(),
                s.getName(),
                s.getCategory().name(),
                DisplayHostAndCountryDto.from(s.getHost()),
                s.getNumRooms(),
                s.isIznajmeno()
        );
    }

    public static List<DisplaySmestuvanjeDto> from(List<Smestuvanje> list) {
        return list.stream().map(DisplaySmestuvanjeDto::from).toList();
    }
}

