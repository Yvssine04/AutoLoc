package tn.esprit.autoloc.web.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.service.IClientService;
import tn.esprit.autoloc.web.dto.ClientRequestDto;
import tn.esprit.autoloc.web.dto.ClientResponseDto;

@RestController
@AllArgsConstructor
@RequestMapping("/api/clients")
public class ClientDtoRestController {

    private final IClientService clientService;

    // POST http://localhost:8080/api/clients
    @PostMapping
    public ClientResponseDto addClient(@Valid @RequestBody ClientRequestDto dto) {
        return clientService.addClientDto(dto);
    }

    // GET http://localhost:8080/api/clients/1
    @GetMapping("/{id}")
    public ClientResponseDto getClient(@PathVariable Long id) {
        return clientService.retrieveClientDto(id);
    }
}
