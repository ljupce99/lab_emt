package finki.ukim.mk.lab_emt.web;

import finki.ukim.mk.lab_emt.model.Smestuvanje;
import finki.ukim.mk.lab_emt.model.dto.SmestuvanjeDto;
import finki.ukim.mk.lab_emt.service.SmestuvanjeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/smestuvanje")
public class SmestuvanjeController {
    private final SmestuvanjeService smestuvanjeService;

    public SmestuvanjeController(SmestuvanjeService smestuvanjeService) {
        this.smestuvanjeService = smestuvanjeService;
    }
    @GetMapping("/list")
    public List<Smestuvanje> getAllsmestuvanje() {
        return smestuvanjeService.listAll();
    }


    @PostMapping("/add")
    public Smestuvanje addSmestuvanje(@RequestBody SmestuvanjeDto smestuvanje) {
        return smestuvanjeService.save(smestuvanje);
    }


    @DeleteMapping("/delete/{id}")
    public String deleteSmestuvanje(@PathVariable Long id) {
        smestuvanjeService.delete(id);
        return "redirect:/api/smestuvanje/list";
    }


    @PutMapping("/edit/{id}")
    public Smestuvanje editSmestuvanje(@PathVariable Long id, @RequestBody SmestuvanjeDto smestuvanje) {
        return smestuvanjeService.update(id, smestuvanje).get();
    }

//    @PutMapping("/iznajmi/{id}")
//    public Smestuvanje iznajmiSmestuvanje(@PathVariable Long id) {
//        return smestuvanjeService.iznajmenoSmestuvanje(id).get();
//    }



}
