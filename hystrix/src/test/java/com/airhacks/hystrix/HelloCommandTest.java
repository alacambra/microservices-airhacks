package com.airhacks.hystrix;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import rx.Observable;

/**
 *
 * @author airhacks.com
 */
public class HelloCommandTest {

    static final String EXPECTED_MESSAGE = "Hello duke!";

    @Test
    public void queue() throws InterruptedException, ExecutionException {
        Future<String> future = new HelloCommand("duke").queue();
        String result = future.get();
        assertThat(result, is(EXPECTED_MESSAGE));
    }

    @Test
    public void observe() throws InterruptedException {
        AtomicReference<String> result = new AtomicReference<>();
        CountDownLatch latch = new CountDownLatch(1);
        Observable<String> observe = new HelloCommand("duke").observe();
        observe.subscribe((String value) -> {
            result.set(value);
            latch.countDown();
        });
        latch.await();
        assertThat(result.get(), is(EXPECTED_MESSAGE));
    }

    @Test
    public void synchronous() {
        String message = new HelloCommand("duke").execute();
        assertThat(message, is(EXPECTED_MESSAGE));
    }

}
