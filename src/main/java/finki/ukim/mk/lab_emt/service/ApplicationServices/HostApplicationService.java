package finki.ukim.mk.lab_emt.service.ApplicationServices;

import finki.ukim.mk.lab_emt.dto.CreateHostDto;
import finki.ukim.mk.lab_emt.dto.DisplayHostAndCountryDto;
import finki.ukim.mk.lab_emt.dto.DisplayHostDto;
import finki.ukim.mk.lab_emt.model.HostNameProjection;
import finki.ukim.mk.lab_emt.views.AccommodationsByHostViews;

import java.util.List;
import java.util.Optional;

public interface HostApplicationService {
    public List<DisplayHostDto> listAll();

    public Optional<DisplayHostDto> findById(Long id);
    public Optional<DisplayHostDto> save(CreateHostDto ch);
    public void delete(Long id);
    public Optional<DisplayHostDto> update(Long id, CreateHostDto ch);

    public List<HostNameProjection> findAllNameSurname();

    public List<AccommodationsByHostViews> findAll();

    public Optional<DisplayHostAndCountryDto> getHostById(Long id);
}
