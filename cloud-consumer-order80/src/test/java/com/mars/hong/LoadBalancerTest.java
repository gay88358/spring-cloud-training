package com.mars.hong;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LoadBalancerTest {
    int fib(int n) {
        int first = 1;
        int second = 1;
        for (int i = 2; i <= n; i++) {
            int temp = first;
            first = first + second;
            second = temp;
        }
        return first;
    }

    @Test
    public void fib_number() {
        assertEquals(fib(0), 1);
        assertEquals(fib(1), 1);
        assertEquals(fib(2), 2);
        assertEquals(fib(3), 3);
        assertEquals(fib(4), 5);
    }
}