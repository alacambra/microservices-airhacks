package com.airhacks.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 *
 * @author airhacks.com
 */
public class HelloCommand extends HystrixCommand<String> {

    private final String name;

    public HelloCommand(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("HelloCommand"));
        this.name = name;
    }

    @Override
    protected String run() {
        return "Hello " + name + "!";
    }
}
