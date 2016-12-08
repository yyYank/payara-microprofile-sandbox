package com.github.yyyank.payara.microprofile.sandbox.servlet;

import com.github.yyyank.payara.microprofile.sandbox.cdi.EntryPointBean;
import com.hazelcast.jmx.ManagedExecutorServiceMBean;
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
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
//        InitialContext ic = null;
//        try {
//            eb.exec();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        response.setContentType("text/plain");
        response.getWriter().println("Hello servlet");
    }
}
