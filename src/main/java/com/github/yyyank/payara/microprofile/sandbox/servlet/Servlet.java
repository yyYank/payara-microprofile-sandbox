package com.github.yyyank.payara.microprofile.sandbox.servlet;

import com.github.yyyank.payara.microprofile.sandbox.cdi.EntryPointBean;
import com.hazelcast.util.executor.ManagedExecutorService;

import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by yy_yank on 2016/12/07.
 */
@WebServlet(urlPatterns = "/cdi-sample")
public class Servlet extends HttpServlet {


    @Inject
    EntryPointBean eb;

    @Override
    protected void doGet(final HttpServletRequest pReq, final HttpServletResponse pResp) throws ServletException, IOException {
        InitialContext ic = null;
        try {

            ic = new InitialContext();
            ic.createSubcontext("concurrent");
            ic.createSubcontext("concurrent/DefaultManagedExecutorService");
            ic.bind("concurrent/DefaultManagedExecutorService", new ManagedExecutorService(){
                @Override
                public void execute(Runnable command) {

                }

                @Override
                public void shutdown() {

                }

                @Override
                public List<Runnable> shutdownNow() {
                    return null;
                }

                @Override
                public boolean isShutdown() {
                    return false;
                }

                @Override
                public boolean isTerminated() {
                    return false;
                }

                @Override
                public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
                    return false;
                }

                @Override
                public <T> Future<T> submit(Callable<T> task) {
                    return null;
                }

                @Override
                public <T> Future<T> submit(Runnable task, T result) {
                    return null;
                }

                @Override
                public Future<?> submit(Runnable task) {
                    return null;
                }

                @Override
                public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
                    return null;
                }

                @Override
                public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
                    return null;
                }

                @Override
                public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
                    return null;
                }

                @Override
                public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
                    return null;
                }

                @Override
                public String getName() {
                    return null;
                }

                @Override
                public long getCompletedTaskCount() {
                    return 0;
                }

                @Override
                public int getMaximumPoolSize() {
                    return 0;
                }

                @Override
                public int getPoolSize() {
                    return 0;
                }

                @Override
                public int getQueueSize() {
                    return 0;
                }

                @Override
                public int getRemainingQueueCapacity() {
                    return 0;
                }
            });
        } catch (NamingException e) {
            e.printStackTrace();
        }
        try {
            eb.exec();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pResp.setContentType("text/plain");
        pResp.getWriter().println("Hello servlet");
    }
}
