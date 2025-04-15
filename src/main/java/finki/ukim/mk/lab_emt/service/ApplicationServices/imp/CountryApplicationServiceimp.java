package finki.ukim.mk.lab_emt.service.ApplicationServices.imp;

import finki.ukim.mk.lab_emt.dto.CreateCountryDto;
import finki.ukim.mk.lab_emt.dto.DisplayCountryDto;
import finki.ukim.mk.lab_emt.service.ApplicationServices.CountryApplicationService;
import finki.ukim.mk.lab_emt.service.DomainServices.CountryDomainService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CountryApplicationServiceimp implements CountryApplicationService {
    private final CountryDomainService countryDomainService;

    public CountryApplicationServiceimp(CountryDomainService countryDomainService) {
        this.countryDomainService = countryDomainService;
    }


    @Override
    public List<DisplayCountryDto> listAll() {
        return DisplayCountryDto.from(countryDomainService.listAll());
    }

    @Override
    public Optional<DisplayCountryDto> findById(Long id) {
        return countryDomainService.findById(id).map(DisplayCountryDto::from);
    }

    @Override
    public Optional<DisplayCountryDto> save(CreateCountryDto cc) {
        return countryDomainService.save(cc.toCountry()).map(DisplayCountryDto::from);
    }

    @Override
    public void delete(Long id) {
        countryDomainService.delete(id);
    }

    @Override
    public Optional<DisplayCountryDto> update(Long id, CreateCountryDto cc) {
        return countryDomainService.update(id, cc.toCountry()).map(DisplayCountryDto::from);
    }
}
