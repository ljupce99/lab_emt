package finki.ukim.mk.lab_emt.web;

import finki.ukim.mk.lab_emt.dto.CreateHostDto;
import finki.ukim.mk.lab_emt.dto.DisplayHostDto;
import finki.ukim.mk.lab_emt.service.ApplicationServices.HostApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/host")
@Tag(name = "Host api", description = "Endpoints for managing Host")

public class HostControllre {
    private final HostApplicationService hostApplicationService;

    public HostControllre(HostApplicationService hostApplicationService) {
        this.hostApplicationService = hostApplicationService;
    }

    @Operation(summary = "get list of all Host")
    @GetMapping("/list")
    public List<DisplayHostDto> getAllhosts() {
        return hostApplicationService.listAll();
    }

    @Operation(summary = "add new host on app")
    @PostMapping("/add")
    public DisplayHostDto addHost(@RequestBody CreateHostDto host) {
        return hostApplicationService.save(host).get();
    }

}
