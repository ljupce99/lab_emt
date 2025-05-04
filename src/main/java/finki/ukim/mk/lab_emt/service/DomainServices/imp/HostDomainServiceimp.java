package finki.ukim.mk.lab_emt.service.DomainServices.imp;

import finki.ukim.mk.lab_emt.model.Host;
import finki.ukim.mk.lab_emt.model.HostNameProjection;
import finki.ukim.mk.lab_emt.repository.HostRepository;
import finki.ukim.mk.lab_emt.service.DomainServices.HostDomainService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostDomainServiceimp implements HostDomainService {
    private final HostRepository hostRepository;

    public HostDomainServiceimp(HostRepository hostRepository) {
        this.hostRepository = hostRepository;

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
    public Optional<Host> save(Host country) {
        return Optional.of(hostRepository.save(new Host(country.getName(), country.getSurname(),country.getCountry() )));
    }

    @Override
    public void delete(Long id) {
        hostRepository.deleteById(id);
    }

    @Override
    public Optional<Host> update(Long id, Host country) {
        return hostRepository.findById(id).map(exist->{
            exist.setName(country.getName());
            exist.setSurname(country.getSurname());
            exist.setCountry(country.getCountry());
            return hostRepository.save(exist);
        });
    }


}
