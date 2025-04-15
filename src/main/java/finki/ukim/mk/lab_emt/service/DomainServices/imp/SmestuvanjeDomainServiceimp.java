package finki.ukim.mk.lab_emt.service.DomainServices.imp;

import finki.ukim.mk.lab_emt.model.Smestuvanje;
import finki.ukim.mk.lab_emt.repository.SmestuvanjeRepository;
import finki.ukim.mk.lab_emt.service.DomainServices.SmestuvanjeDomainService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SmestuvanjeDomainServiceimp implements SmestuvanjeDomainService {
    private final SmestuvanjeRepository smestuvanjeRepository;

    public SmestuvanjeDomainServiceimp(SmestuvanjeRepository smestuvanjeRepository) {
        this.smestuvanjeRepository = smestuvanjeRepository;
    }

    @Override
    public List<Smestuvanje> listAll() {
        return smestuvanjeRepository.findAll();
    }

    @Override
    public Optional<Smestuvanje> findById(Long id) {
        return smestuvanjeRepository.findById(id);
    }

    @Override
    public Optional<Smestuvanje> save(Smestuvanje country) {
        return Optional.of(smestuvanjeRepository.save(new Smestuvanje(country.getName(),country.getCategory(), country.getHost(),country.getNumRooms())));
    }

    @Override
    public void delete(Long id) {
        smestuvanjeRepository.deleteById(id);
    }

    @Override
    public Optional<Smestuvanje> update(Long id, Smestuvanje country) {
        return smestuvanjeRepository.findById(id).map(exist->{
            exist.setName(country.getName());
            exist.setCategory(country.getCategory());
            exist.setHost(country.getHost());
            exist.setNumRooms(country.getNumRooms());
            return smestuvanjeRepository.save(exist);
        });
    }

}
