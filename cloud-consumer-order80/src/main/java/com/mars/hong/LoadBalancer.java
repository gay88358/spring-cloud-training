package com.mars.hong;

import org.springframework.cloud.client.ServiceInstance;

public interface LoadBalancer {
    ServiceInstance instance(String serviceId);
}
