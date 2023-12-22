package org.top.onlinestoreapi.service;

import org.top.onlinestoreapi.entity.Client;

import java.util.Optional;

public interface ClientService {
    Iterable<Client> getAllByUserRole();
    Optional<Client> getById(Integer id);
    Optional<Client> update(Client client);
    Optional<Client> findClientByUserLogin(String userLogin);
    Optional<Client> deleteById(Integer id);

}
