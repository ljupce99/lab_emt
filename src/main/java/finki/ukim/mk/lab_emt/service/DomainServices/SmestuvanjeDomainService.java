package finki.ukim.mk.lab_emt.service.DomainServices;

import finki.ukim.mk.lab_emt.model.Smestuvanje;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface SmestuvanjeDomainService {
    public List<Smestuvanje> listAll();
    public Optional<Smestuvanje> findById(Long id);
    public Optional<Smestuvanje> save(Smestuvanje country);
    public void delete(Long id);
    public Optional<Smestuvanje> update(Long id, Smestuvanje country);

    public HashMap<String,Integer> Statistic();



}
