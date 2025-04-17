package finki.ukim.mk.lab_emt.service.ApplicationServices.imp;

import finki.ukim.mk.lab_emt.dto.CreateSmestuvanjeDto;
import finki.ukim.mk.lab_emt.dto.DisplaySmestuvanjeDto;
import finki.ukim.mk.lab_emt.model.Host;
import finki.ukim.mk.lab_emt.model.enums.Category;
import finki.ukim.mk.lab_emt.service.ApplicationServices.SmestuvanjeApplicationService;
import finki.ukim.mk.lab_emt.service.DomainServices.HostDomainService;
import finki.ukim.mk.lab_emt.service.DomainServices.SmestuvanjeDomainService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class SmestuvanjeApplicationServiceimp implements SmestuvanjeApplicationService {
    private  final SmestuvanjeDomainService smestuvanjeDomainService;
    private  final HostDomainService hostDomainService;

    public SmestuvanjeApplicationServiceimp(SmestuvanjeDomainService smestuvanjeDomainService, HostDomainService hostDomainService) {
        this.smestuvanjeDomainService = smestuvanjeDomainService;
        this.hostDomainService = hostDomainService;
    }

    @Override
    public List<DisplaySmestuvanjeDto> listAll() {
        return DisplaySmestuvanjeDto.from(smestuvanjeDomainService.listAll());
    }

    @Override
    public Optional<DisplaySmestuvanjeDto> findById(Long id) {
        return smestuvanjeDomainService.findById(id).map(DisplaySmestuvanjeDto::from);
    }

    @Override
    public Optional<DisplaySmestuvanjeDto> save(CreateSmestuvanjeDto country) {
        Optional<Host> host = hostDomainService.findById(country.hostId());
        Category cat=Category.values()[country.categoryId().intValue()];
        return smestuvanjeDomainService.save(country.toSmestuvanje(cat,host.get())).map(DisplaySmestuvanjeDto::from);
    }

    @Override
    public void delete(Long id) {
        smestuvanjeDomainService.delete(id);
    }

    @Override
    public Optional<DisplaySmestuvanjeDto> update(Long id, CreateSmestuvanjeDto country) {
        Optional<Host> host = hostDomainService.findById(country.hostId());
        Category cat=Category.values()[country.categoryId().intValue()];
        return smestuvanjeDomainService.update(id,country.toSmestuvanje(cat,host.get())).map(DisplaySmestuvanjeDto::from);
    }

    @Override
    public HashMap<String,Integer> Statistic() {
        return smestuvanjeDomainService.Statistic();
    }
}
