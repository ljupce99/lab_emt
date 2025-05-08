package finki.ukim.mk.lab_emt.web;

import finki.ukim.mk.lab_emt.dto.DisplayHostAndCountryDto;
import finki.ukim.mk.lab_emt.dto.DisplayHostDto;
import finki.ukim.mk.lab_emt.dto.DisplaySmestuvanjeAndHostDto;
import finki.ukim.mk.lab_emt.model.Host;
import finki.ukim.mk.lab_emt.repository.AccommodationsByHostViewsRepository;
import finki.ukim.mk.lab_emt.service.ApplicationServices.HostApplicationService;
import finki.ukim.mk.lab_emt.service.ApplicationServices.SmestuvanjeApplicationService;
import finki.ukim.mk.lab_emt.views.AccommodationsByHostViews;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/accommodations")
@Tag(name = "Accommodations api", description = "Endpoints for managing accommodations")
public class AccommodationsController {
    private final HostApplicationService hostApplicationService;
    private final SmestuvanjeApplicationService smestuvanjeApplicationService;

    public AccommodationsController(HostApplicationService hostApplicationService, SmestuvanjeApplicationService smestuvanjeApplicationService) {
        this.hostApplicationService = hostApplicationService;
        this.smestuvanjeApplicationService = smestuvanjeApplicationService;

    }

    @Operation(summary = "get list of all HostInContry")
    @GetMapping("/by-host")
    public List<AccommodationsByHostViews> getAllbyHost() {
        return hostApplicationService.findAll();
    }

    @Operation(summary = "get Accommodations by id")
    @GetMapping("/{id}")
    public DisplaySmestuvanjeAndHostDto gethostsbyid(@PathVariable Long id) {
        return smestuvanjeApplicationService.getHostById(id).get();
    }
}
