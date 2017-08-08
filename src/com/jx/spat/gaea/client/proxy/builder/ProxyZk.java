package com.jx.spat.gaea.client.proxy.builder;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by xiaowei on 17/8/5.
 */
public class ProxyZk implements InvocationHandler,Serializable,IProxyStandard {
    private Class<?> interfacename;
    private String servicename;
    private String lookup;

    /**
     *
     * @param interfacename 接口名称
     * @param serviceName 服务名称
     * @param lookup 实现接口名称
     */
    public ProxyZk(Class<?> interfacename,String serviceName, String lookup){
        this.interfacename = interfacename;
        this.servicename = serviceName;
        this.lookup = lookup;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
    private Map<String,String> findService(String interfacename,String servicename,String lookupname){
        return null;
    }
}
