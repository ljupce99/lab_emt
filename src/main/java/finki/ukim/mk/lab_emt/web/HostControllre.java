package finki.ukim.mk.lab_emt.web;

import finki.ukim.mk.lab_emt.model.Host;
import finki.ukim.mk.lab_emt.model.dto.HostDto;
import finki.ukim.mk.lab_emt.service.DomainServices.HostDomainService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/host")
public class HostControllre {
    private final HostDomainService hostDomainService;

    public HostControllre(HostDomainService hostDomainService) {
        this.hostDomainService = hostDomainService;
    }
    @GetMapping("/list")
    public List<Host> getAllhosts() {
        return hostDomainService.listAll();
    }
    @PostMapping("/add")
    public Host addHost(@RequestBody HostDto host) {
        return hostDomainService.save(host);
    }

//    @DeleteMapping("/delete/{id}")
//    public String deleteHost(@PathVariable Long id) {
//        hostService.delete(id);
//        return "redirect:/api/host/list";
//    }
//    @PostMapping("/edit/{id}")
//    public Host editHost(@PathVariable Long id, @RequestBody HostDto host) {
//        return hostService.update(id,host).get();
//    }

}
