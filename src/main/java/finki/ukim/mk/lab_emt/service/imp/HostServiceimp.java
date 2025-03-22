package finki.ukim.mk.lab_emt.service.imp;

import finki.ukim.mk.lab_emt.model.Host;
import finki.ukim.mk.lab_emt.model.dto.HostDto;
import finki.ukim.mk.lab_emt.repository.HostRepository;
import finki.ukim.mk.lab_emt.service.CountryService;
import finki.ukim.mk.lab_emt.service.HostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostServiceimp implements HostService {
    private final HostRepository hostRepository;
    private final CountryService countryService;

    public HostServiceimp(HostRepository hostRepository, CountryService countryService) {
        this.hostRepository = hostRepository;
        this.countryService = countryService;
    }

    @Override
    public List<Host> listAll() {
        return hostRepository.findAll();
    }

    @Override
    public Optional<Host> findById(Long id) {
        return hostRepository.findById(id);
    }

    @Override
    public Host save(HostDto country) {
        return hostRepository.save(new Host(country.getName(), country.getSurname(), countryService.findById(country.getCountry()).get()));
    }

    @Override
    public void delete(Long id) {
        hostRepository.deleteById(id);
    }

    @Override
    public Optional<Host> update(Long id, HostDto country) {
        return hostRepository.findById(id).map(exist->{
            exist.setName(country.getName());
            exist.setSurname(country.getSurname());
            exist.setCountry(countryService.findById(country.getCountry()).get());
            return hostRepository.save(exist);
        });
    }
}
