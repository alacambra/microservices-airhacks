package com.airhacks.micro.statistics;

import com.airhacks.porcupine.execution.entity.Statistics;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author airhacks.com
 */
@Stateless
@Path("statistics")
public class StatisticsResource {

    @Inject
    Instance<List<Statistics>> statistics;

    @GET
    public List<Statistics> get() {
        return statistics.get();
    }
}
