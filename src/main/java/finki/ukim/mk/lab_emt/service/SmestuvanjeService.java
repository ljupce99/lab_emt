package finki.ukim.mk.lab_emt.service;

import finki.ukim.mk.lab_emt.model.Smestuvanje;
import finki.ukim.mk.lab_emt.model.dto.SmestuvanjeDto;

import java.util.List;
import java.util.Optional;

public interface SmestuvanjeService {
    public List<Smestuvanje> listAll();

    public Optional<Smestuvanje> findById(Long id);
    public Smestuvanje save(SmestuvanjeDto country);
    public void delete(Long id);
    public Optional<Smestuvanje> update(Long id, SmestuvanjeDto country);

//    public Optional<Smestuvanje> iznajmenoSmestuvanje(Long id);
}
