package com.example.griddemo.data.generator;

import com.example.griddemo.data.model.CarEntity;
import com.example.griddemo.data.model.CollectorEntity;
import com.example.griddemo.data.model.RouteEntity;
import com.example.griddemo.data.model.SpcEntity;
import com.example.griddemo.data.repository.RouteRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class DataGenerator {

    private static final int COUNT = 10000;
    private static final List<String> ROUTE_NUMBERS = Arrays.asList("111-1", "222-2", "333-3", "444-4", "555-5");
    private static final LocalDate BEGIN_DATE = LocalDate.of(2019, 1, 10);

    private final RouteRepository routeRepository;
    private final SpcGenerator spcGenerator;
    private final CarGenerator carGenerator;
    private final CollectorGenerator collectorGenerator;

    private final Random random = new Random();

    public DataGenerator(RouteRepository routeRepository,
                         SpcGenerator spcGenerator,
                         CarGenerator carGenerator,
                         CollectorGenerator collectorGenerator) {
        this.routeRepository = routeRepository;
        this.spcGenerator = spcGenerator;
        this.carGenerator = carGenerator;
        this.collectorGenerator = collectorGenerator;
    }

    @PostConstruct
    public void generateData() {
        List<SpcEntity> spcEntities = spcGenerator.generateSpcList();
        List<CarEntity> carEntities = carGenerator.generateCarList();
        List<CollectorEntity> collectorEntities = collectorGenerator.generateCollectorList();

        LocalDate currentDate = BEGIN_DATE;
        int count = 0;
        while (count < COUNT) {

            for (String routeNumber : ROUTE_NUMBERS) {
                if (random.nextBoolean()) {
                    RouteEntity routeEntity = new RouteEntity();

                    routeEntity.setNumber(routeNumber);
                    routeEntity.setDate(currentDate);

                    SpcEntity spc = getRandomElement(spcEntities);
                    CollectorEntity collector = getRandomElement(collectorEntities);
                    CarEntity car = getRandomElement(carEntities);

                    routeEntity.setSpc(spc);
                    routeEntity.setCollector(collector);
                    routeEntity.setCar(car);

                    routeRepository.save(routeEntity);

                    count++;
                    if (count >= COUNT) {
                        break;
                    }
                }
            }

            currentDate = currentDate.plusDays(1);
        }

    }

    private <T> T getRandomElement(List<T> list) {
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}
