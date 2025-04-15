package finki.ukim.mk.lab_emt.service.ApplicationServices;

import finki.ukim.mk.lab_emt.dto.CreateCountryDto;
import finki.ukim.mk.lab_emt.dto.DisplayCountryDto;

import java.util.List;
import java.util.Optional;

public interface CountryApplicationService {
    public List<DisplayCountryDto> listAll();

    public Optional<DisplayCountryDto> findById(Long id);
    public Optional<DisplayCountryDto> save(CreateCountryDto cc);
    public void delete(Long id);
    public Optional<DisplayCountryDto> update(Long id, CreateCountryDto cc);


}
