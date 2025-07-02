package com.acme.center.platform.quotes.domain.model.aggregates;

import com.acme.center.platform.quotes.domain.model.commands.CreateQuoteCommand;
import com.acme.center.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Quote extends AuditableAbstractAggregateRoot<Quote> {

    private String origin;
    private String destination;
    private String driver;
    private String driverImage;
    private BigDecimal price;
    private LocalDate date;
    private LocalTime time;
    private int seats;
    private String licensePlate;
    private String carBrand;
    private String image;

    public Quote() {}

    public Quote(String origin, String destination, String driver, String driverImage, BigDecimal price, LocalDate date, LocalTime time, int seats, String licensePlate, String carBrand, String image) {
        this.origin = origin;
        this.destination = destination;
        this.driver = driver;
        this.driverImage = driverImage;
        this.price = price;
        this.date = date;
        this.time = time;
        this.seats = seats;
        this.licensePlate = licensePlate;
        this.carBrand = carBrand;
        this.image = image;
    }

    public Quote(CreateQuoteCommand command) {
        this.origin = command.origin();
        this.destination = command.destination();
        this.driver = command.driver();
        this.driverImage = command.driverImage();
        this.price = command.price();
        this.date = command.date();
        this.time = command.time();
        this.seats = command.seats();
        this.licensePlate = command.licensePlate();
        this.carBrand = command.carBrand();
        this.image = command.image();
    }

    public String getOrigin() { return origin; }
    public String getDestination() { return destination; }
    public String getDriver() { return driver; }
    public String getDriverImage() { return driverImage; }
    public BigDecimal getPrice() { return price; }
    public LocalDate getDate() { return date; }
    public LocalTime getTime() { return time; }
    public int getSeats() { return seats; }
    public String getLicensePlate() { return licensePlate; }
    public String getCarBrand() { return carBrand; }
    public String getImage() { return image; }
}
