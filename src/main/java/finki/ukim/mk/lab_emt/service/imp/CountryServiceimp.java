package finki.ukim.mk.lab_emt.service.imp;

import finki.ukim.mk.lab_emt.model.Country;
import finki.ukim.mk.lab_emt.model.dto.CountryDto;
import finki.ukim.mk.lab_emt.repository.CountryRepository;
import finki.ukim.mk.lab_emt.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceimp implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceimp(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> listAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public Country save(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public void delete(Long id) {
        countryRepository.deleteById(id);
    }

    @Override
    public Optional<Country> update(Long id, CountryDto country) {
        return countryRepository.findById(id).map(existingContry ->{
            existingContry.setName(country.getName());
            existingContry.setContinent(country.getContinent());
            return countryRepository.save(existingContry);
        });
    }
}
