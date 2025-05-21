package finki.ukim.mk.lab_emt.web;

import finki.ukim.mk.lab_emt.dto.*;
import finki.ukim.mk.lab_emt.model.Host;
import finki.ukim.mk.lab_emt.model.enums.Category;
import finki.ukim.mk.lab_emt.repository.AccommodationsByHostViewsRepository;
import finki.ukim.mk.lab_emt.service.ApplicationServices.HostApplicationService;
import finki.ukim.mk.lab_emt.service.ApplicationServices.SmestuvanjeApplicationService;
import finki.ukim.mk.lab_emt.views.AccommodationsByHostViews;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/accommodations")
@Tag(name = "Accommodations api", description = "Endpoints for managing accommodations")
public class AccommodationsController {
    private final HostApplicationService hostApplicationService;
    private final SmestuvanjeApplicationService smestuvanjeApplicationServiceimp;

    public AccommodationsController(HostApplicationService hostApplicationService, SmestuvanjeApplicationService smestuvanjeApplicationService) {
        this.hostApplicationService = hostApplicationService;
        this.smestuvanjeApplicationServiceimp = smestuvanjeApplicationService;

    }

    @Operation(summary = "get list of all HostInContry")
    @GetMapping("/by-host")
    public List<AccommodationsByHostViews> getAllbyHost() {
        return hostApplicationService.findAll();
    }

    @Operation(summary = "get Accommodations by id")
    @GetMapping("/{id}")
    public DisplaySmestuvanjeAndHostDto gethostsbyid(@PathVariable Long id) {
        return smestuvanjeApplicationServiceimp.getHostById(id).get();
    }


    @Operation(summary = "get list of all smestuvanje")
    @GetMapping("/list")
    public List<DisplaySmestuvanjeDto> getAllsmestuvanje() {
        return smestuvanjeApplicationServiceimp.listAll();
    }

    @Operation(summary = "add new smestuvanje to app")
    @PostMapping("/add")
    public DisplaySmestuvanjeDto addSmestuvanje(@RequestBody CreateSmestuvanjeDto smestuvanje) {
        return smestuvanjeApplicationServiceimp.save(smestuvanje).get();
    }

    @Operation(summary = "delete smestuvanje with id")
    @DeleteMapping("/delete/{id}")
    public void deleteSmestuvanje(@PathVariable Long id) {
        smestuvanjeApplicationServiceimp.delete(id);
//        return "redirect:/api/smestuvanje/list";
    }

    @Operation(summary = "edit smestuvanje with id")
    @PutMapping("/edit/{id}")
    public DisplaySmestuvanjeDto editSmestuvanje(@PathVariable Long id, @RequestBody CreateSmestuvanjeDto smestuvanje) {
        return smestuvanjeApplicationServiceimp.update(id, smestuvanje).get();
    }


    @Operation(summary = "Statistic from category")
    @GetMapping("/stac")
    public HashMap<String,Integer> getStatistic() {
        return smestuvanjeApplicationServiceimp.Statistic();
    }
}
