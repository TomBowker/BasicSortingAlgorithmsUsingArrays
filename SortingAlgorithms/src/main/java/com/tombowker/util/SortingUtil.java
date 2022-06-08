/**
 * Sorting Utility
 * This is used to support the sorting algorithms.
 * printResults print out the array
 * swap performs basic value swapping
 * setTestData sets the array to be out of order just to be reorganized again ;)
 */
package com.tombowker.util;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class SortingUtil {
    public static void printResults(int[] array) {
        for (int j : array) {
            System.out.println(j);
        }
    }

    public static void swap(int[] array, int i, int j) {
        if(i == j) {
            return;
        }

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    //create a read a text file in and return a array of ints "data/numberDataSet.txt"
    public static int[] setTestData() throws IOException {
        String home = "/Users/thomasbowker/Documents/Programming/Coding/Java-Projects/SortingAlgorithms/src/main/";
        Scanner scanner = new Scanner(new File(home + "resources/data/numberDataSet.txt"));

        List<Integer> list = new ArrayList<>();

        while(scanner.hasNext()) {
            int token = scanner.nextInt();
            list.add(token);
        }

        scanner.close();

        int[] data = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            data[i] = list.get(i);
        }

        return data;
    }
}
