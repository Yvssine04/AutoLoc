package tn.esprit.autoloc.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autoloc.service.IReservationService;
import tn.esprit.autoloc.web.dto.ReservationResponseDto;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/reservations")
public class ReservationDtoRestController {

    private final IReservationService reservationService;

    @GetMapping
    public List<ReservationResponseDto> getAllReservations() {
        return reservationService.retrieveAllReservationsDto();
    }

    @GetMapping("/client/{idClient}")
    public List<ReservationResponseDto> getReservationsByClient(@PathVariable Long idClient) {
        return reservationService.retrieveReservationsByClientDto(idClient);
    }
}