package com.example.lib001;

public class PrimeNumberChecker{
    public static int isPrime(int num){

        for (int x = 2; x < num; x ++) {
            if (num % x == 0) {
                return 0;
            }
        }
        return 1;

    }
}