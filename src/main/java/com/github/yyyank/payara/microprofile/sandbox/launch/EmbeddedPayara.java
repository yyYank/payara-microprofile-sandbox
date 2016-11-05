package com.github.yyyank.payara.microprofile.sandbox.launch;

import fish.payara.micro.BootstrapException;
import fish.payara.micro.PayaraMicro;

/**
 * Created by yy_yank on 2016/11/05.
 */
public class EmbeddedPayara {

    public static void main(String[] args) throws BootstrapException {
        PayaraMicro.getInstance().addDeployment("build/libs/Sandbox.war").bootStrap();
    }
}