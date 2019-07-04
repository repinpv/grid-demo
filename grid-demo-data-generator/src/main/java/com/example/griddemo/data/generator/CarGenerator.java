package com.example.griddemo.data.generator;

import com.example.griddemo.data.model.CarEntity;
import com.example.griddemo.data.repository.CarRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarGenerator {

    private final CarRepository carRepository;

    public CarGenerator(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    List<CarEntity> generateCarList() {
        List<CarEntity> carEntities = new ArrayList<>();

        carEntities.add(generateCar("Волга"));
        carEntities.add(generateCar("УАЗ Хантер"));
        carEntities.add(generateCar("Газель"));
        carEntities.add(generateCar("КАМАЗ"));
        carEntities.add(generateCar("ВАЗ 2107"));
        carEntities.add(generateCar("УАЗ Патриот"));
        carEntities.add(generateCar("Тигр"));

        carRepository.saveAll(carEntities);

        return carEntities;
    }

    private CarEntity generateCar(String name) {
        CarEntity carEntity = new CarEntity();
        carEntity.setName(name);
        return carEntity;
    }
}
