package finki.ukim.mk.lab_emt.web;

import finki.ukim.mk.lab_emt.model.HostNameProjection;
import finki.ukim.mk.lab_emt.service.ApplicationServices.CountryApplicationService;
import finki.ukim.mk.lab_emt.service.ApplicationServices.HostApplicationService;
import finki.ukim.mk.lab_emt.views.AccommodationsByHostViews;
import finki.ukim.mk.lab_emt.views.HostsByCountryViews;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/hosts")
@Tag(name = "Hosts api", description = "Endpoints for managing hosts")
public class HostsController {
    private final CountryApplicationService countryApplicationService;
    private final HostApplicationService hostApplicationService;

    public HostsController(CountryApplicationService countryApplicationService, HostApplicationService hostApplicationService) {
        this.countryApplicationService = countryApplicationService;
        this.hostApplicationService = hostApplicationService;
    }

    @Operation(summary = "get list of all byCountry")
    @GetMapping("/by-country")
    public List<HostsByCountryViews> getAllbyCountry() {
        return countryApplicationService.findAll();
    }

    @Operation(summary = "get list of all host names and surname")
    @GetMapping("/names")
    public List<HostNameProjection> getAllNameSurname() {
        return hostApplicationService.findAllNameSurname();
    }

}
