package com.workintech.s18d2.services;

import com.workintech.s18d2.repository.FruitRepository;
import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.exceptions.PlantException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FruitServiceImpl implements FruitService {
    private FruitRepository fruitRepository;

    @Autowired
    public FruitServiceImpl(FruitRepository fruitRepository) { this.fruitRepository = fruitRepository; }

    @Override public List<Fruit> getByPriceAsc() { return fruitRepository.getByPriceAsc(); }
    @Override public List<Fruit> getByPriceDesc() { return fruitRepository.getByPriceDesc(); }
    @Override public Fruit getById(Long id) {
        if(id < 0) throw new PlantException("ID 0'dan küçük olamaz", HttpStatus.BAD_REQUEST);
        return fruitRepository.findById(id).orElseThrow(() -> new PlantException("ID bulunamadı", HttpStatus.NOT_FOUND));
    }
    @Override public Fruit save(Fruit fruit) { return fruitRepository.save(fruit); }
    @Override public List<Fruit> searchByName(String name) { return fruitRepository.searchByName(name); }
    @Override public Fruit delete(Long id) {
        Fruit fruit = getById(id);
        fruitRepository.delete(fruit);
        return fruit;
    }
}
