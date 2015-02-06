package com.airhacks;

import java.util.concurrent.Future;
import javax.inject.Inject;

/**
 *
 * @author airhacks.com
 */
public class SleepyClient {

    @Inject
    LongRunning lr;

    public void invoke() {
        Future<String> async = lr.asynchronous();
        //wasCancellCalled return "true" after the call below
        async.cancel(true);

    }

}
