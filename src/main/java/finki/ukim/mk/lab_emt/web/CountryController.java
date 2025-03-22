package finki.ukim.mk.lab_emt.web;

import finki.ukim.mk.lab_emt.model.Country;
import finki.ukim.mk.lab_emt.model.dto.CountryDto;
import finki.ukim.mk.lab_emt.service.CountryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/country")
public class CountryController {
    private final CountryService countryService;


    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }
    @GetMapping("/list")
    public List<Country> getAllCountries() {
        return countryService.listAll();
    }
    @PostMapping("/add")
    public Country addCountry(@RequestBody Country country) {
        return countryService.save(country);
    }
//    @DeleteMapping("/delete/{id}")
//    public String deleteCountry(@PathVariable Long id) {
//        countryService.delete(id);
//        return "redirect:/api/country/list";
//    }
//    @PostMapping("/edit/{id}")
//    public Country editCountry(@PathVariable Long id, @RequestBody CountryDto country) {
//        return countryService.update(id,country).get();
//    }
}
