package org.top.hotelscatalog.rdb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.top.hotelscatalog.entity.Hotel;

// HotelRepository - репозиторий для работы с отелями
@Repository
public interface HotelRepository extends CrudRepository<Hotel, Integer> {
}
