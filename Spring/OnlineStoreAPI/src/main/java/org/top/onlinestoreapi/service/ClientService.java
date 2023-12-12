package org.top.onlinestoreapi.service;

import org.top.onlinestoreapi.entity.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    Iterable<Client> getAll();
    Optional<Client> getById(Integer id);
    Optional<Client> add(Client client);
    Optional<Client> update(Client client);
    Optional<Client> deleteById(Integer id);

}
