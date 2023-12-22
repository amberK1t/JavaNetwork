package org.top.onlinestoreapi.rdb;

import org.springframework.stereotype.Service;
import org.top.onlinestoreapi.entity.Client;
import org.top.onlinestoreapi.rdb.repository.ClientRepository;
import org.top.onlinestoreapi.service.ClientService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RdbClientService implements ClientService {
    private final ClientRepository clientRepository;
    public RdbClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    @Override
    public Iterable<Client> getAllByUserRole() {
        Iterable<Client> clients = clientRepository.findAll();
        List<Client> users = new ArrayList<>();
        for (Client client: clients) {
            if (Objects.equals(client.getUser().getRole(), "USER")) {
                users.add(client);
            }
        }
        return users;
    }

    @Override
    public Optional<Client> getById(Integer id) {
        return clientRepository.findById(id);
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
    public Optional<Client> findClientByUserLogin(String userLogin) {
        return clientRepository.findClientByUserLogin(userLogin);
    }

    @Override
    public Optional<Client> deleteById(Integer id) {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isPresent()) {
            clientRepository.deleteById(id);
        }
        return client;
    }
}
