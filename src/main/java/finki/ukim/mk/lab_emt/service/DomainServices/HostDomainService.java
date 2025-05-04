package finki.ukim.mk.lab_emt.service.DomainServices;

import finki.ukim.mk.lab_emt.model.Host;
import finki.ukim.mk.lab_emt.model.HostNameProjection;

import java.util.List;
import java.util.Optional;

public interface HostDomainService {
    public List<Host> listAll();

    public Optional<Host> findById(Long id);
    public Optional<Host> save(Host country);
    public void delete(Long id);
    public Optional<Host> update(Long id, Host country);
}
