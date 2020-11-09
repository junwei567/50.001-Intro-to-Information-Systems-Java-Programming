package com.example.lib001;

import java.util.Arrays;
public class Fibonacci {
    public static String fibonacci(int n) {
        int x1 = 0, x2 = 1, x3;
        int[] arr = new int[n];

        if (n == 1) {
            arr[0] = 0;
        } else if (n == 2) {
            arr[0] = 0;
            arr[1] = 1;
        } else {
            arr[0] = 0;
            arr[1] = 1;
            for (int i = 2; i < n; i++) {
                x3 = x2 + x1;
                arr[i] = x3;
                x1 = x2;
                x2 = x3;
            }
        }

        String result = Arrays.toString(arr);
        return result.substring(1, result.length() - 1).replaceAll("\\s", "");

    }
}
