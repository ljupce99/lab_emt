package finki.ukim.mk.lab_emt.jobs;

import finki.ukim.mk.lab_emt.service.DomainServices.CountryDomainService;
import finki.ukim.mk.lab_emt.service.DomainServices.HostDomainService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
    private final HostDomainService hostDomainService;
    private final CountryDomainService countryDomainService;

    public ScheduledTasks(HostDomainService hostDomainService, CountryDomainService countryDomainService) {

        this.hostDomainService = hostDomainService;
        this.countryDomainService = countryDomainService;
    }

    @Scheduled(cron = "* * * 1 * *")
    public void refreshMaterializedView() {
        hostDomainService.refreshMaterializedView();

        countryDomainService.refreshMaterializedView();
    }

}
