package org.top.onlinestoreapi.rdb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.top.onlinestoreapi.entity.Client;

import java.util.Optional;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {
    Optional<Client> findClientByUserLogin(String login);
}
