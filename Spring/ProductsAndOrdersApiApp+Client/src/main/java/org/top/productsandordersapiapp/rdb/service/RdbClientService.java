package org.top.productsandordersapiapp.rdb.service;

import org.springframework.stereotype.Service;
import org.top.productsandordersapiapp.entity.Client;
import org.top.productsandordersapiapp.rdb.repository.ClientRepository;
import org.top.productsandordersapiapp.service.ClientService;

import java.util.List;
import java.util.Optional;

@Service
public class RdbClientService implements ClientService {

    private final ClientRepository clientRepository;

    public RdbClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Optional<Client> add(Client client) {
        // Клиента можно добавить в том случае, если имя клиента и email уникальны
        // 1. Проверить уникальность email
        Optional<Client> existing = clientRepository.findByEmail(client.getEmail());
        if (existing.isPresent()) { // Если есть клиент с таким email, то нельзя добавлять
            return Optional.empty();
        }
        return Optional.of(clientRepository.save(client));
    }

    @Override
    public List<Client> getAll() {
        return (List<Client>) clientRepository.findAll();
    }

    @Override
    public Optional<Client> getById(Integer id) {
        return clientRepository.findById(id);
    }

    @Override
    public Boolean deleteById(Integer id) {
        Optional<Client> deleted = clientRepository.findById(id);
        if (deleted.isPresent()) {
            clientRepository.deleteById(id);
        }
        return deleted.isPresent();
    }

    @Override
    public Optional<Client> update(Client client) {
        Optional<Client> updated = clientRepository.findById(client.getId());
        if (updated.isPresent()) {
            if (client.getEmail().equals(updated.get().getEmail())) {
                clientRepository.save(client);
                return Optional.of(client);
            } else {
                if (clientRepository.findByEmail(client.getEmail()).isEmpty()) {
                    clientRepository.save(client);
                    return Optional.of(client);
                }
            }
        }
        return Optional.empty();
    }
}
