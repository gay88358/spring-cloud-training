package com.mars.hong;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class FlowLimitControllerTest {

//    @Test
//    void spiral_order_matrix() {
//
//    }

    @Test
    public void spiral_order_matrix2() {
        int[][] m = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

        Solution s = new Solution();

        List<Integer> result = s.spiralOrder(m);
        assertEquals(Arrays.asList(1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10), result);
    }

    @Test
    public void spiral_order_matrix() {
        int[][] m = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };

        Solution s = new Solution();

        List<Integer> result = s.spiralOrder(m);
        assertEquals(Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7), result);
    }

    @Test
    public void first_row() {
        int[][] m = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        Solution s = new Solution();

        List<Integer> result = s.spiralOrder(m);
        assertEquals(Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5), result);
    }

    public static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            return spiralOrder(matrix, 0, matrix[0].length, 0, matrix.length);
        }

        public List<Integer> spiralOrder(int[][] matrix, int top, int right, int left, int bottom) {
            List<Integer> result = new ArrayList<>();

            while (left < right && top < bottom) {
                for (int i = left; i < right; i++) {
                    result.add(matrix[top][i]);
                }
                top += 1;
                if (top == bottom) {
                    return result;
                }
                for (int i = top; i < bottom; i++) {
                    result.add(matrix[i][right - 1]);
                }
                right -= 1;
                if (right == left) {
                    return result;
                }
                for (int i = right - 1; i >= left; i--) {
                    result.add(matrix[bottom - 1][i]);
                }
                bottom -= 1;
                if (top == bottom) {
                    return result;
                }
                for (int i = bottom - 1; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left += 1;
                if (left == right) {
                    return result;
                }
            }
//
//            List<Integer> result = new ArrayList<>();
//            for (int i = left; i < right; i++) {
//                result.add(matrix[top][i]);
//            }
//            top += 1;
//            if (top == bottom) {
//                return result;
//            }
//
//            for (int i = top; i < bottom; i++) {
//                result.add(matrix[i][right - 1]);
//            }
//            right -= 1;
//            if (right == left) {
//                return result;
//            }
//            for (int i = right - 1; i >= left; i--) {
//                result.add(matrix[bottom - 1][i]);
//            }
//            bottom -= 1;
//            if (top == bottom) {
//                return result;
//            }
//            for (int i = bottom - 1; i >= top; i--) {
//                result.add(matrix[i][left]);
//            }
//            left += 1;
//            if (left == right) {
//                return result;
//            }
//            result.addAll(spiralOrder(matrix, top, right, left, bottom));
            return result;
        }
    }
}