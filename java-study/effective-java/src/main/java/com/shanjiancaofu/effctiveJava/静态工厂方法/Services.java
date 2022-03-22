package com.shanjiancaofu.effctiveJava.静态工厂方法;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Services {
    private static final String DEFAULT_PROVIDER_NAME = "hello";

    private Services() {
    }

    private static final Map<String, Provider> providers = new ConcurrentHashMap<>();

    public static void registerDefaultProvider(Provider p) {
        registerProvider(DEFAULT_PROVIDER_NAME, p);
    }

    public static void registerProvider(String name, Provider p) {
        providers.put(name, p);
    }

    public static Service newInstance() {
        return newInstance(DEFAULT_PROVIDER_NAME);
    }

    public static Service newInstance(String name) {


        Provider provider = providers.get(name);
        if (provider == null) {
            throw new IllegalArgumentException("NO Provider with name: " + name);
        }
        return provider.newService();
    }
}
