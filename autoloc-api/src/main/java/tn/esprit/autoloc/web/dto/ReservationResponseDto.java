package tn.esprit.autoloc.web.dto;

import lombok.*;
import tn.esprit.autoloc.domain.StatutReservation;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationResponseDto {
    private Long idReservation;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private StatutReservation statut;
    // Infos du client
    private String nomClient;
    private String prenomClient;
    // Infos du vehicule
    private String marqueVehicule;
    private String modeleVehicule;
    private String immatriculationVehicule;
}