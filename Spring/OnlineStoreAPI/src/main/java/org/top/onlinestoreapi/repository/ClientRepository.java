package org.top.onlinestoreapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.top.onlinestoreapi.entity.Client;

public interface ClientRepository extends CrudRepository<Client, Integer> {
}
