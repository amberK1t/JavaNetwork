package org.top.hotelscatalog.rdb;

import org.springframework.stereotype.Service;
import org.top.hotelscatalog.entity.Hotel;
import org.top.hotelscatalog.rdb.repository.HotelRepository;
import org.top.hotelscatalog.service.HotelService;

import java.util.Optional;

// RdbHotelService - имплементация HotelService, работающая с СУБД
@Service
public class RdbHotelService implements HotelService {

    // репозиторий для выполнения операций
    private final HotelRepository hotelRepository;

    public RdbHotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public Iterable<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Optional<Hotel> findById(Integer id) {
        return hotelRepository.findById(id);
    }

    @Override
    public Optional<Hotel> save(Hotel hotel) {
        return Optional.of(hotelRepository.save(hotel));
    }

    @Override
    public Optional<Hotel> deleteById(Integer id) {
        Optional<Hotel> deleted = findById(id);
        if (deleted.isPresent()) {
            hotelRepository.deleteById(id);
        }
        return deleted;
    }

    @Override
    public Optional<Hotel> update(Hotel hotel) {
        // 1. проверить, есть ли объект с таким id
        Optional<Hotel> updated = findById(hotel.getId());
        if (updated.isPresent()) {
            // если есть, то обновить его
            updated = Optional.of(hotelRepository.save(hotel));
        }
        return updated;
    }
}
