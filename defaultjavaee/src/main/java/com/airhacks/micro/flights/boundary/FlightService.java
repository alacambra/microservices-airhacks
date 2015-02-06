package com.airhacks.micro.flights.boundary;

import com.airhacks.micro.flights.control.TowerControl;
import com.airhacks.porcupine.execution.boundary.Dedicated;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.function.Consumer;
import java.util.function.Supplier;
import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.inject.Inject;

/**
 *
 * @author airhacks.com
 */
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class FlightService {

    @Inject
    TowerControl tc;

    @Inject
    @Dedicated
    ExecutorService mes;

    private String recent;

    @PostConstruct
    public void init() {
        this.recent = "-";
    }

    public String flight() {
        Supplier<String> flights = tc::getFlights;
        Consumer<String> flightConsumer = this::consumer;
        CompletableFuture.supplyAsync(flights, mes).
                thenAccept(flightConsumer);
        return recent;
    }

    public void consumer(String flight) {
        this.recent = flight;
    }

}
