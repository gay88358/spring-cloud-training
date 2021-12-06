package com.mars.hong;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateController {
//    @GetMapping("/byResource")
//    @SentinelResource(value = "byResource", blockHandler = "fallbackGetResult")
//    public String getResult() {
//        return "get result";
//    }
//
//    public String fallbackGetResult() {
//        return "fallback QQ";
//    }

    @GetMapping("/d")
//    @SentinelResource(value = "byResource")
    public String getResultUrl() {
        return "get result";
    }

    @GetMapping("/rateLimit/customBlockHandler")
    @SentinelResource(value = "customBlockHandler",
            blockHandlerClass = CustomBlockHandler.class,
    blockHandler = "handleException1")
    public String getCustomBlockHandler() {
        return "custom defined";
    }
}
