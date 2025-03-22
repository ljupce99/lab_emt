package finki.ukim.mk.lab_emt.service.imp;

import finki.ukim.mk.lab_emt.model.Smestuvanje;
import finki.ukim.mk.lab_emt.model.dto.SmestuvanjeDto;
import finki.ukim.mk.lab_emt.repository.SmestuvanjeRepository;
import finki.ukim.mk.lab_emt.service.HostService;
import finki.ukim.mk.lab_emt.service.SmestuvanjeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SmestuvanjeServiceimp implements SmestuvanjeService {
    private final SmestuvanjeRepository smestuvanjeRepository;
    private final HostService hostService;

    public SmestuvanjeServiceimp(SmestuvanjeRepository smestuvanjeRepository, HostService hostService) {
        this.smestuvanjeRepository = smestuvanjeRepository;
        this.hostService = hostService;
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
    public Smestuvanje save(SmestuvanjeDto country) {
        return smestuvanjeRepository.save(new Smestuvanje(country.getName(),country.getCategory(),hostService.findById(country.getHost()).get(),country.getNumRooms()));
    }

    @Override
    public void delete(Long id) {
        smestuvanjeRepository.deleteById(id);
    }

    @Override
    public Optional<Smestuvanje> update(Long id, SmestuvanjeDto country) {
        return smestuvanjeRepository.findById(id).map(exist->{
            exist.setName(country.getName());
            exist.setCategory(country.getCategory());
            exist.setHost(hostService.findById(country.getHost()).get());
            exist.setNumRooms(country.getNumRooms());
            return smestuvanjeRepository.save(exist);
        });
    }

    @Override
    public Optional<Smestuvanje> iznajmenoSmestuvanje(Long id) {
        return smestuvanjeRepository.findById(id).map(exist->{
            if(exist.getNumRooms()>0) {
                exist.setNumRooms(exist.getNumRooms()-1);
            }else {
                return null;
            }
            return smestuvanjeRepository.save(exist);
        });
    }
}
