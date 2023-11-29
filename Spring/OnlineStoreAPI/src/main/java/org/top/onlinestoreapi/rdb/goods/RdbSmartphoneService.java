package org.top.onlinestoreapi.rdb.goods;

import org.springframework.stereotype.Service;
import org.top.onlinestoreapi.entity.goods.Smartphone;
import org.top.onlinestoreapi.repository.goods.SmartphoneRepository;
import org.top.onlinestoreapi.service.goods.SmartphoneService;

import java.util.*;

@Service
public class RdbSmartphoneService implements SmartphoneService {

    private final SmartphoneRepository smartphoneRepository;
    public RdbSmartphoneService(SmartphoneRepository smartphoneRepository) {
        this.smartphoneRepository = smartphoneRepository;
    }

    @Override
    public Iterable<Smartphone> getAll() {
        return smartphoneRepository.findAll();
    }

    @Override
    public List<Smartphone> getAllLimit() {
        List<Smartphone> all = new ArrayList<>();
        for (Smartphone smart: smartphoneRepository.findAll()) {
            all.add(smart);
        }
        Collections.shuffle(all);
        return all.subList(0, 4);
    }


    @Override
    public Optional<Smartphone> addNew(Smartphone smartphone) {
        return Optional.of(smartphoneRepository.save(smartphone));
    }

    @Override
    public Optional<Smartphone> getById(Integer id) {
        return smartphoneRepository.findById(id);
    }

    @Override
    public Optional<Smartphone> deleteById(Integer id) {
        Optional<Smartphone> find = smartphoneRepository.findById(id);
        if (find.isPresent()) {
            smartphoneRepository.deleteById(id);
        }
        return find;
    }

    @Override
    public Optional<Smartphone> update(Smartphone smartphone) {
        Optional<Smartphone> find = smartphoneRepository.findById(smartphone.getId());
        if (find.isPresent()) {
            find = Optional.of(smartphoneRepository.save(smartphone));
        }
        return find;
    }
}
