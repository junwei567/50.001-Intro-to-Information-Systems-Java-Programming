package com.example.lib001;

import java.util.*;

public class IteratingExamples {

    public static int Act2Iterator(List<Integer> integers) {
        int sum = 0;

        // Insert code here to sum up input using an Iterator ...
        Iterator<Integer> intList = integers.iterator();
        while (intList.hasNext()) {
            sum += intList.next();
        }

        return sum;
    }

    public static int Act2ForEach(List<Integer> integers) {
        int sum = 0;
        for (int i: integers) {
            sum += i;
        }

        return sum;
    }
}
