package tn.esprit.autoloc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.web.dto.ReservationResponseDto;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservationMapper {

    // Champs recuperes depuis les relations (reservation.client, reservation.vehicule)
    @Mapping(target = "nomClient", source = "client.nom")
    @Mapping(target = "prenomClient", source = "client.prenom")
    @Mapping(target = "marqueVehicule", source = "vehicule.marque")
    @Mapping(target = "modeleVehicule", source = "vehicule.modele")
    @Mapping(target = "immatriculationVehicule", source = "vehicule.immatriculation")
    ReservationResponseDto toResponseDto(Reservation reservation);

    // Conversion d'une liste : MapStruct reutilise la methode du dessus
    List<ReservationResponseDto> toResponseDtoList(List<Reservation> reservations);
}