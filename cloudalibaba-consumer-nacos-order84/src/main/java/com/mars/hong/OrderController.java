package com.mars.hong;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@AllArgsConstructor
public class OrderController {
    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Resource
    private final PaymentService paymentService;

    @Resource
    private final RestTemplate restTemplate;

    @GetMapping("/consumer/fallback/{id}")
    @SentinelResource(value = "fallback") //no fallback method
    // @SentinelResource(value = "fallback", fallback = "handleFallback") // contains fallback method
    // @SentinelResource(value = "fallback", blockHandler = "blockHandler") // contains fallback block method
    // @SentinelResource(value = "fallback", fallback = "handleFallback", blockHandler = "blockHandler",  exceptionsToIgnore = IllegalArgumentException.class) // contains fallback and block method
    public String fallback(@PathVariable("id") Long id) {
        String result =  paymentService.findPayments(id).getBody().getName();

//        if (id == 5) {
//            throw new IllegalArgumentException("bad argument");
//        } else if (id == 2) {
//            throw new NullPointerException("No data");
//        }

        return result;
    }

    public String blockHandler(@PathVariable("id") Long id, BlockException blockException) {
        return "blockHandler too many exception error QQ";
    }

    public String handleFallback(@PathVariable("id") Long id) {
        return "fallback QQ";
    }

}
