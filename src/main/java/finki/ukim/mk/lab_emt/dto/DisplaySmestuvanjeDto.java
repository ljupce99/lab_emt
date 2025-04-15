package finki.ukim.mk.lab_emt.dto;

import finki.ukim.mk.lab_emt.model.Smestuvanje;

import java.util.List;

public record DisplaySmestuvanjeDto(Long id, String name, String category, String hostName, Integer numRooms) {

    public static DisplaySmestuvanjeDto from(Smestuvanje s) {
        return new DisplaySmestuvanjeDto(
                s.getId(),
                s.getName(),
                s.getCategory().name(), // assuming Category is enum
                s.getHost().getName() + " " + s.getHost().getSurname(),
                s.getNumRooms()
        );
    }

    public static List<DisplaySmestuvanjeDto> from(List<Smestuvanje> list) {
        return list.stream().map(DisplaySmestuvanjeDto::from).toList();
    }
}

