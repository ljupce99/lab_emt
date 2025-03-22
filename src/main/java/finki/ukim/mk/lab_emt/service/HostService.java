package finki.ukim.mk.lab_emt.service;

import finki.ukim.mk.lab_emt.model.Host;
import finki.ukim.mk.lab_emt.model.dto.HostDto;

import java.util.List;
import java.util.Optional;

public interface HostService {
    public List<Host> listAll();

    public Optional<Host> findById(Long id);
    public Host save(HostDto country);
    public void delete(Long id);
    public Optional<Host> update(Long id, HostDto country);
}
