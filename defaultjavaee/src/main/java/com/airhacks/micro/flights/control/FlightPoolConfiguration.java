package com.airhacks.micro.flights.control;

import com.airhacks.porcupine.configuration.control.ExecutorConfigurator;
import com.airhacks.porcupine.execution.control.ExecutorConfiguration;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.Specializes;

/**
 *
 * @author airhacks.com
 */
@Specializes
public class FlightPoolConfiguration extends ExecutorConfigurator {

    @Produces
    @Override
    public ExecutorConfiguration defaultConfigurator() {
        return new ExecutorConfiguration.Builder().
                queueCapacity(10).callerRunsPolicy().
                corePoolSize(1).maxPoolSize(5).build();
    }

}
