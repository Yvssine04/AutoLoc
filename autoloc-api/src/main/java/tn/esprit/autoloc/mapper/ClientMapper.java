package tn.esprit.autoloc.mapper;

import org.mapstruct.Mapper;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.web.dto.ClientRequestDto;
import tn.esprit.autoloc.web.dto.ClientResponseDto;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    // RequestDto -> Entite (pour l'ajout)
    Client toEntity(ClientRequestDto dto);

    // Entite -> ResponseDto (pour la consultation)
    ClientResponseDto toResponseDto(Client client);
    // MapStruct genere automatiquement l'implementation !
}