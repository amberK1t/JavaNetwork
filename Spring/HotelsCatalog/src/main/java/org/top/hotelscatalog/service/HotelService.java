package org.top.hotelscatalog.service;

import org.springframework.stereotype.Service;
import org.top.hotelscatalog.entity.Hotel;

import java.util.Optional;

// Сервис для работы с отелями
@Service
public interface HotelService {

    // получить все отели
    Iterable<Hotel> findAll();

    // получить по id
    Optional<Hotel> findById(Integer id);

    // добавить отель
    Optional<Hotel> save(Hotel hotel);

    // удалить отель
    Optional<Hotel> deleteById(Integer id);

    // обновить отель
    Optional<Hotel> update(Hotel hotel);
}
