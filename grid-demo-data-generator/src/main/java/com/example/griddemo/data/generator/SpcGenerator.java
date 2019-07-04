package com.example.griddemo.data.generator;

import com.example.griddemo.data.model.SpcEntity;
import com.example.griddemo.data.repository.SpcRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SpcGenerator {

    private final SpcRepository spcRepository;

    public SpcGenerator(SpcRepository spcRepository) {
        this.spcRepository = spcRepository;
    }

    List<SpcEntity> generateSpcList() {
        List<SpcEntity> spcEntities = new ArrayList<>();

        spcEntities.add(generateSpc("Екатеринбург", "г. Екатеринбург"));
        spcEntities.add(generateSpc("Новосибирск", "г. Новосибирск"));
        spcEntities.add(generateSpc("Москва", "г. Москва"));
        spcEntities.add(generateSpc("Владимир", "г. Владимир"));
        spcEntities.add(generateSpc("Якутск", "г. Якутск"));
        spcEntities.add(generateSpc("Калининград", "г. Калининград"));
        spcEntities.add(generateSpc("Севастополь", "г. Севастополь"));

        spcRepository.saveAll(spcEntities);

        return spcEntities;
    }

    private SpcEntity generateSpc(String name, String address) {
        SpcEntity spcEntity = new SpcEntity();
        spcEntity.setName(name);
        spcEntity.setAddress(address);
        return spcEntity;
    }
}
