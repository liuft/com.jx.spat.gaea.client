package com.jx.spat.gaea.client.proxy;

import com.jx.spat.gaea.client.configuration.ServiceConfig;
import com.jx.spat.gaea.client.loadbalance.Dispatcher;
import com.jx.spat.gaea.client.utility.logger.ILog;
import com.jx.spat.gaea.client.utility.logger.LogFactory;

import java.util.HashMap;

/**
 * Created by xiaowei on 17/8/7.
 */
public class ServiceProxyZK {
    private Dispatcher dispatcher;
    private ServiceConfig config;
    private int sessionId = 1;
    private int requestTime = 0;//超时重连次数
    private int ioreconnect = 0;//IO服务切换次数
    private int count = 0;
    private static final ILog logger = LogFactory.getLogger(ServiceProxyZK.class);
    private static final Object locker = new Object();
    private static final HashMap<String, ServiceProxy> Proxys = new HashMap<String, ServiceProxy>();
    private ServiceProxyZK(){

    }
    public static ServiceProxyZK getServiceProxyZK(String servicename)throws Exception{
        return null;
    }


}
