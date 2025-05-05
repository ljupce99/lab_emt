package finki.ukim.mk.lab_emt.service.DomainServices.imp;

import finki.ukim.mk.lab_emt.model.Country;
import finki.ukim.mk.lab_emt.repository.CountryRepository;
import finki.ukim.mk.lab_emt.repository.HostsByCountryViewsRepository;
import finki.ukim.mk.lab_emt.service.DomainServices.CountryDomainService;
import finki.ukim.mk.lab_emt.views.HostsByCountryViews;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryDomainServiceimp implements CountryDomainService {
    private final CountryRepository countryRepository;
    private final HostsByCountryViewsRepository hostsByCountryViewsRepository;


    public CountryDomainServiceimp(CountryRepository countryRepository, HostsByCountryViewsRepository hostsByCountryViewsRepository) {
        this.countryRepository = countryRepository;
        this.hostsByCountryViewsRepository = hostsByCountryViewsRepository;
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
    public Optional<Country> save(Country country) {

        return Optional.of(countryRepository.save(country));
    }

    @Override
    public void delete(Long id) {

        countryRepository.deleteById(id);
    }

    @Override
    public Optional<Country> update(Long id, Country country) {
        return countryRepository.findById(id).map(existingContry ->{
            existingContry.setId(country.getId());
            existingContry.setName(country.getName());
            existingContry.setContinent(country.getContinent());
            return countryRepository.save(existingContry);
        });
    }

    @Override
    public List<HostsByCountryViews> findAll() {
        return hostsByCountryViewsRepository.findAll();
    }

    @Override
    public void refreshMaterializedView() {
        hostsByCountryViewsRepository.refreshMaterializedView();
    }
}
