package com.mars.hong;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA() {
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        log.info("Test");
//        System.out.println(Thread.currentThread().getName() + " ");
        return "---testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "---testB";
    }

    @GetMapping("/testD")
    public String testD() {
        int a = 10 / 0;
        return "---testD";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "fallbackHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        int a = 10 / 0;
        return "-----testHotKey";
    }

    public String fallbackHotKey(@RequestParam(value = "p1", required = false) String p1,
                                 @RequestParam(value = "p2", required = false) String p2,
                                 BlockException blockException) {
        return "----fallback hot key Q_Q";
    }
}
