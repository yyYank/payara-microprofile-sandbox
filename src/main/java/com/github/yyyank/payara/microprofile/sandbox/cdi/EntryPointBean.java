package com.github.yyyank.payara.microprofile.sandbox.cdi;

import com.hazelcast.util.executor.ManagedExecutorService;

import javax.annotation.Resource;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by yy_yank on 2016/12/07.
 */
@Dependent
public class EntryPointBean {

    @Inject
    ConcurrentBean concurrentBean;

//    @Resource(name = "concurrent/DefaultManagedExecutorService")
//    ManagedExecutorService executorService;

    public void exec() throws InterruptedException {
        FutureTask<Boolean> task = new FutureTask<>(() -> concurrentBean.listen());
//        executorService.submit(task);
//        executorService.awaitTermination(60L, TimeUnit.SECONDS);
    }
}
