package com.mars.hong;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLoadBalancer implements LoadBalancer{
    private final AtomicInteger count = new AtomicInteger(0);
    private final DiscoveryClient discoveryClient;

    MyLoadBalancer(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @Override
    public ServiceInstance instance(String serviceId) {
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances(serviceId);
        int index = nextCount() % serviceInstances.size();
        return serviceInstances.get(index);
    }

    private int nextCount() {
        // lightweight lock, round lock
        int current;
        int next;
        do {
            current = count.get();
            next = (current >= Integer.MAX_VALUE) ? 0 : current + 1;
        } while (!count.compareAndSet(current, next));
        System.out.println("***next: " + next);
        return next;
    }
}
