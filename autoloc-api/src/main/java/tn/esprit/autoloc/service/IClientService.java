package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.web.dto.ClientRequestDto;
import tn.esprit.autoloc.web.dto.ClientResponseDto;

import java.util.List;

public interface IClientService {
    ClientResponseDto addClientDto(ClientRequestDto dto);
    ClientResponseDto retrieveClientDto(Long idClient);
    List<Client> retrieveAllClients();
    Client retrieveClient(Long clientId);
    Client addClient(Client v);
    void removeClient(Long clientId);
    Client modifyClient(Client client);
}