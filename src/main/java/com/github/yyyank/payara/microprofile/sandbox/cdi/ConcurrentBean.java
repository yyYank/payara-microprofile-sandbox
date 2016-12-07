package com.github.yyyank.payara.microprofile.sandbox.cdi;

import javax.enterprise.context.Dependent;
/**
 * Created by yy_yank on 2016/12/07.
 */
@Dependent
public class ConcurrentBean implements ConcurrentListener {

    @Override
    public boolean listen() {
        System.out.println("concurrent....." + Thread.currentThread().getId());
        return true;
    }
}
