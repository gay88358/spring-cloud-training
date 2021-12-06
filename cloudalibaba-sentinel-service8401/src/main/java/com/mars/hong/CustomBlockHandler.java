package com.mars.hong;


import com.alibaba.csp.sentinel.slots.block.BlockException;

public class CustomBlockHandler {
    public static String handleException1(BlockException blockException) {
        return "global exception handler---1";
    }

    public static String handleException2(BlockException blockException) {
        return "global exception handler---2";
    }
}
