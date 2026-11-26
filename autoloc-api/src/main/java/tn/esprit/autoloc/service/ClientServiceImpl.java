package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.mapper.ClientMapper;
import tn.esprit.autoloc.repository.ClientRepository;
import tn.esprit.autoloc.web.dto.ClientRequestDto;
import tn.esprit.autoloc.web.dto.ClientResponseDto;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements IClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public List<Client> retrieveAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client retrieveClient(Long clientId) {
        return clientRepository.findById(clientId).get();
    }

    @Override
    public Client addClient(Client v) {
        return clientRepository.save(v);
    }

    @Override
    public void removeClient(Long clientId) {
        clientRepository.deleteById(clientId);
    }

    @Override
    public Client modifyClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    @Transactional
    public ClientResponseDto addClientDto(ClientRequestDto dto) {
        Client client = clientMapper.toEntity(dto);
        // Champ absent du DTO : rempli par le serveur
        client.setDateInscription(LocalDate.now());
        Client saved = clientRepository.save(client);
        return clientMapper.toResponseDto(saved);
    }

    @Override
    public ClientResponseDto retrieveClientDto(Long idClient) {
        Client client = clientRepository.findById(idClient)
                .orElseThrow(() -> new RuntimeException("Client non trouve"));
        return clientMapper.toResponseDto(client);
    }
}
