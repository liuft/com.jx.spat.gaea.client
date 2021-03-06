/*
 *  Copyright Beijing 58 Information Technology Co.,Ltd.
 *
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package com.jx.spat.gaea.client.proxy.builder;

import com.jx.spat.gaea.client.utility.logger.ILog;
import com.jx.spat.gaea.client.utility.logger.LogFactory;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * ProxyStandard
 *
 * @author Service Platform Architecture Team (spat@58.com)
 */
public class ProxyStandard implements InvocationHandler, Serializable, IProxyStandard {

    private Class<?> interfaceClass;
    private MethodCaller methodCaller;
    private ILog logger = LogFactory.getLogger(ProxyStandard.class);
    
    /**
     * @param interfaceClass 接口类
     * @param serviceName 服务名
     * @param lookup 接口实现类
     */
    public ProxyStandard(Class<?> interfaceClass, String serviceName, String lookup) {
        this.interfaceClass = interfaceClass;
        this.methodCaller = new MethodCaller(serviceName, lookup);
    }
    
    /**
     * args 参数
     * method 方法
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        Object obj = methodCaller.doMethodCall(args, method);
        long end = System.currentTimeMillis();
        long total = end - start;
        if (total > 200) {
            logger.warn("method:" + method.getName() + " invoke time :" + total);
        }
        return obj;
    }
}
