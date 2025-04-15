package finki.ukim.mk.lab_emt.web;

import finki.ukim.mk.lab_emt.dto.CreateCountryDto;
import finki.ukim.mk.lab_emt.dto.DisplayCountryDto;
import finki.ukim.mk.lab_emt.service.ApplicationServices.CountryApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/country")
@Tag(name = "Country api", description = "Endpoints for managing country")
public class CountryController {
    private final CountryApplicationService applicationService;

    public CountryController(CountryApplicationService applicationService) {
        this.applicationService = applicationService;
    }
    @Operation(summary = "get list of all Countries")
    @GetMapping("/list")
    public List<DisplayCountryDto> getAllCountries() {
        return applicationService.listAll();
    }
    @Operation(summary = "add new Country")
    @PostMapping("/add")
    public DisplayCountryDto addCountry(@RequestBody CreateCountryDto country) {
        return applicationService.save(country).get();
    }

}
