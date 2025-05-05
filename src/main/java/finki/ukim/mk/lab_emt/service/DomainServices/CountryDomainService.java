package finki.ukim.mk.lab_emt.service.DomainServices;

import finki.ukim.mk.lab_emt.model.Country;
import finki.ukim.mk.lab_emt.views.HostsByCountryViews;

import java.util.List;
import java.util.Optional;

public interface CountryDomainService {
    public List<Country> listAll();

    public Optional<Country> findById(Long id);
    public Optional<Country> save(Country country);
    public void delete(Long id);
    public Optional<Country> update(Long id, Country country);

    public List<HostsByCountryViews> findAll();
    void refreshMaterializedView();

}
