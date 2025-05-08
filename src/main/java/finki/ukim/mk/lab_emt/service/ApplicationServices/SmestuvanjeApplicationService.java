package finki.ukim.mk.lab_emt.service.ApplicationServices;


import finki.ukim.mk.lab_emt.dto.CreateSmestuvanjeDto;
import finki.ukim.mk.lab_emt.dto.DisplayHostAndCountryDto;
import finki.ukim.mk.lab_emt.dto.DisplaySmestuvanjeAndHostDto;
import finki.ukim.mk.lab_emt.dto.DisplaySmestuvanjeDto;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface SmestuvanjeApplicationService {
    public List<DisplaySmestuvanjeDto> listAll();

    public Optional<DisplaySmestuvanjeDto> findById(Long id);
    public Optional<DisplaySmestuvanjeDto> save(CreateSmestuvanjeDto country);
    public void delete(Long id);
    public Optional<DisplaySmestuvanjeDto> update(Long id, CreateSmestuvanjeDto country);

    public HashMap<String,Integer> Statistic();

    public Optional<DisplaySmestuvanjeAndHostDto> getHostById(Long id);
}
