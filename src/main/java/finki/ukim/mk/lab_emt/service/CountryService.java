package finki.ukim.mk.lab_emt.service;

import finki.ukim.mk.lab_emt.model.Country;
import finki.ukim.mk.lab_emt.model.dto.CountryDto;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    public List<Country> listAll();

    public Optional<Country> findById(Long id);
    public Country save(Country country);
    public void delete(Long id);
    public Optional<Country> update(Long id, CountryDto country);


}
