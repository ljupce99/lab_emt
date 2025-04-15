package finki.ukim.mk.lab_emt.service.ApplicationServices.imp;

import finki.ukim.mk.lab_emt.dto.CreateHostDto;
import finki.ukim.mk.lab_emt.dto.DisplayHostDto;
import finki.ukim.mk.lab_emt.model.Country;
import finki.ukim.mk.lab_emt.service.ApplicationServices.HostApplicationService;
import finki.ukim.mk.lab_emt.service.DomainServices.CountryDomainService;
import finki.ukim.mk.lab_emt.service.DomainServices.HostDomainService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostApplicationServiceimp implements HostApplicationService {
    private final HostDomainService hostDomainService;
    private final CountryDomainService countryDomainService;

    public HostApplicationServiceimp(HostDomainService hostDomainService, CountryDomainService countryDomainService) {
        this.hostDomainService = hostDomainService;
        this.countryDomainService = countryDomainService;
    }


    @Override
    public List<DisplayHostDto> listAll() {
        return DisplayHostDto.from(hostDomainService.listAll());
    }

    @Override
    public Optional<DisplayHostDto> findById(Long id) {
        return hostDomainService.findById(id).map(DisplayHostDto::from);
    }

    @Override
    public Optional<DisplayHostDto> save(CreateHostDto ch) {
        Optional<Country> country=countryDomainService.findById(ch.countryId());
        return hostDomainService.save(ch.toHost(country.get())).map(DisplayHostDto::from);
    }

    @Override
    public void delete(Long id) {
        hostDomainService.delete(id);
    }

    @Override
    public Optional<DisplayHostDto> update(Long id, CreateHostDto ch) {
        Optional<Country> country=countryDomainService.findById(ch.countryId());
        return hostDomainService.update(id,ch.toHost(country.get())).map(DisplayHostDto::from);
    }
}
