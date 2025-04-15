package finki.ukim.mk.lab_emt.Datainit;

import finki.ukim.mk.lab_emt.service.DomainServices.CountryDomainService;
import finki.ukim.mk.lab_emt.service.DomainServices.HostDomainService;
import finki.ukim.mk.lab_emt.service.DomainServices.ReservationDomainService;
import finki.ukim.mk.lab_emt.service.DomainServices.SmestuvanjeDomainService;
import org.springframework.context.annotation.Bean;

public class Datainicalization {
    private final CountryDomainService countryDomainService;
    private final HostDomainService hostDomainService;
    private final SmestuvanjeDomainService smestuvanjeDomainService;
    private final ReservationDomainService reservationDomainService;

    public Datainicalization(CountryDomainService countryDomainService, HostDomainService hostDomainService, SmestuvanjeDomainService smestuvanjeDomainService, ReservationDomainService reservationDomainService) {
        this.countryDomainService = countryDomainService;
        this.hostDomainService = hostDomainService;
        this.smestuvanjeDomainService = smestuvanjeDomainService;
        this.reservationDomainService = reservationDomainService;
    }

    @Bean
    void init(){
//        countryService.save(new Country(1L,"mk","eu"));
//        hostService.save(new HostDto("ljupce",1l,"221277"))
    }
}
