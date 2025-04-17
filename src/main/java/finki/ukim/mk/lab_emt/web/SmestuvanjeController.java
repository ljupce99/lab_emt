package finki.ukim.mk.lab_emt.web;

import finki.ukim.mk.lab_emt.dto.CreateSmestuvanjeDto;
import finki.ukim.mk.lab_emt.dto.DisplaySmestuvanjeDto;
import finki.ukim.mk.lab_emt.service.ApplicationServices.imp.SmestuvanjeApplicationServiceimp;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/smestuvanje")
@Tag(name = "smestuvanje", description = "Endpoints for managing smestuvanje")
public class SmestuvanjeController {
    private final SmestuvanjeApplicationServiceimp smestuvanjeApplicationServiceimp;

    public SmestuvanjeController(SmestuvanjeApplicationServiceimp smestuvanjeApplicationServiceimp) {
        this.smestuvanjeApplicationServiceimp = smestuvanjeApplicationServiceimp;
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
