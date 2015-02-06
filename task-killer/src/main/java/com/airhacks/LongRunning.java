package com.airhacks;

import java.util.concurrent.Future;
import javax.annotation.Resource;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

/**
 *
 * @author airhacks.com
 */
@Stateless
public class LongRunning {

    @Resource
    SessionContext sc;

    @Asynchronous
    public Future<String> asynchronous() {
        boolean wasCancelCalled = sc.wasCancelCalled();
        return new AsyncResult<>("42");
    }

}
