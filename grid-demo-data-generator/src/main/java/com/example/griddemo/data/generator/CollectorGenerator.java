package com.example.griddemo.data.generator;

import com.example.griddemo.data.model.CarEntity;
import com.example.griddemo.data.model.CollectorEntity;
import com.example.griddemo.data.repository.CollectorRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CollectorGenerator {

    private final CollectorRepository collectorRepository;

    public CollectorGenerator(CollectorRepository collectorRepository) {
        this.collectorRepository = collectorRepository;
    }

    List<CollectorEntity> generateCollectorList() {
        List<CollectorEntity> collectorEntities = new ArrayList<>();

        collectorEntities.add(generateCollector("Петров"));
        collectorEntities.add(generateCollector("Иванов"));
        collectorEntities.add(generateCollector("Сидоров"));
        collectorEntities.add(generateCollector("Гусаров"));
        collectorEntities.add(generateCollector("Смактуновский"));

        collectorRepository.saveAll(collectorEntities);

        return collectorEntities;
    }

    private CollectorEntity generateCollector(String name) {
        CollectorEntity collectorEntity = new CollectorEntity();
        collectorEntity.setName(name);
        return collectorEntity;
    }

}
