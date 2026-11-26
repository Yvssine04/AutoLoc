package tn.esprit.autoloc.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.mapper.ReservationMapper;
import tn.esprit.autoloc.repository.ReservationRepository;
import tn.esprit.autoloc.web.dto.ReservationResponseDto;

import java.util.List;


@Service
@AllArgsConstructor
public class ReservationServiceImpl implements IReservationService {

    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;

    @Override
    public List<Reservation> retrieveAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation retrieveReservation(Long reservationId) {
        return reservationRepository.findById(reservationId).get();
    }

    @Override
    public Reservation addReservation(Reservation v) {
        return reservationRepository.save(v);
    }

    @Override
    public void removeReservation(Long reservationId) {
        reservationRepository.deleteById(reservationId);
    }

    @Override
    public Reservation modifyReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }


    @Override
    @Transactional
    public List<ReservationResponseDto> retrieveAllReservationsDto() {
        return reservationMapper.toResponseDtoList(reservationRepository.findAll());
    }

    @Override
    @Transactional
    public List<ReservationResponseDto> retrieveReservationsByClientDto(Long idClient) {
        return reservationMapper.toResponseDtoList(reservationRepository.findByClientIdClient(idClient));
    }
}