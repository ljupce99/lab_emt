package finki.ukim.mk.lab_emt.listeners;

import finki.ukim.mk.lab_emt.events.CountryCreatedEvent;
import finki.ukim.mk.lab_emt.service.DomainServices.CountryDomainService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CountryEventHandlers {
    private final CountryDomainService countryDomainService;

    public CountryEventHandlers(CountryDomainService countryDomainService) {
        this.countryDomainService = countryDomainService;
    }
    @EventListener
    public void onCountryCreate(CountryCreatedEvent event) {
        countryDomainService.refreshMaterializedView();
    }

}
