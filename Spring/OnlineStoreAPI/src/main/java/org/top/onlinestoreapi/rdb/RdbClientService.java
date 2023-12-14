package org.top.onlinestoreapi.rdb;

import org.springframework.stereotype.Service;
import org.top.onlinestoreapi.entity.Client;
import org.top.onlinestoreapi.rdb.repository.ClientRepository;
import org.top.onlinestoreapi.service.ClientService;
import java.util.Optional;

@Service
public class RdbClientService implements ClientService {
    private final ClientRepository clientRepository;
    public RdbClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    @Override
    public Iterable<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> getById(Integer id) {
        return clientRepository.findById(id);
    }

    @Override
    public Optional<Client> add(Client client) {
        return Optional.of(clientRepository.save(client));
    }

    @Override
    public Optional<Client> update(Client client) {
        Optional<Client> find = clientRepository.findById(client.getId());
        if (find.isPresent()) {
            clientRepository.save(client);
        }
        return find;
    }

    @Override
    public Optional<Client> deleteById(Integer id) {
        Optional<Client> find = clientRepository.findById(id);
        if (find.isPresent()) {
            clientRepository.deleteById(id);
        }
        return find;
    }
}
