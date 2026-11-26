package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.web.dto.ReservationResponseDto;

import java.util.List;

public interface IReservationService {
    List<Reservation> retrieveAllReservations();
    Reservation retrieveReservation(Long reservationId);
    Reservation addReservation(Reservation v);
    void removeReservation(Long reservationId);
    Reservation modifyReservation(Reservation reservation);
    List<ReservationResponseDto> retrieveAllReservationsDto();
    List<ReservationResponseDto> retrieveReservationsByClientDto(Long idClient);
}