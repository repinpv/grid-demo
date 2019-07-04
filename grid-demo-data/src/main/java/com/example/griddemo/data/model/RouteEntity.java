package com.example.griddemo.data.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class RouteEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String number;
    private LocalDate date;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="SPC_ID")
    private SpcEntity spc;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="COLLECTOR_ID")
    private CollectorEntity collector;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="CAR_ID")
    private CarEntity car;

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public SpcEntity getSpc() {
        return spc;
    }

    public void setSpc(SpcEntity spc) {
        this.spc = spc;
    }

    public CollectorEntity getCollector() {
        return collector;
    }

    public void setCollector(CollectorEntity collector) {
        this.collector = collector;
    }

    public CarEntity getCar() {
        return car;
    }

    public void setCar(CarEntity car) {
        this.car = car;
    }
}
