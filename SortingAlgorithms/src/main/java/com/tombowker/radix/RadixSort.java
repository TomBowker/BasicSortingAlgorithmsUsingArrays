/**
 * Sorting by Radix Sort
 * This sorting algorithm makes assumptions about the data. Data must have same radix and width, meaning the radix for
 * digits is 10 because (0, 1, 2, 3, 4, 5, 6, 7, 8, & 9) 0-9 make up the digits that can be written. For binary the radix
 * is two, 0 & 1. The radix for the alphabet is 26 because there are 26 letters in the alphabet. That is what makes a
 * radix. For width, it means how many of that thing in a group. For example the 1234 has a width of four, the word "hello"
 * has a width of five, and for the last example 0111011101110010 has a width of sixteen. Because of this the data must
 * be integers or strings. It sorts based on the individual digit or letter position starting at the rightmost position.
 * Must use a stable sort algorithm at each stage.
 * Counting sort is often used as the sort algorithm for radix sort, but the key difference it is a stable version of
 * counting sort.
 * At best its O(n) because we are making assumptions about the data. Even so, it often runs slower than O(nlogn)
 * algorithms because of the overhead involved.
 * In-place depends on which sort algorithm you use, and it is a stable algorithm as stated before.
 */
package com.tombowker.radix;

import com.tombowker.util.SortingUtil;

import java.util.Timer;
import java.util.TimerTask;

public class RadixSort {
    public static int[] sort(int[] data){
        Timer timer = new Timer();
        final int[] secondsPassed = {0};
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                secondsPassed[0]++;
            }
        };

        timer.schedule(timerTask, 0, 1);

        //radix sort algorithm
        radixSort(data, 10, 4);


        SortingUtil.printResults(data);
        timer.cancel();
        System.out.println("Time to process for " + RadixSort.class + " was: " + secondsPassed[0] + " milliseconds\n");

        return data;
    }

    private static void radixSort(int[] input, int radix, int width) {
        for(int i = 0; i < width; i++) {
            radixSingleSort(input, i, radix);
        }
    }

    private static void radixSingleSort(int[] input, int position, int radix) {
        int numItems = input.length;
        int[] countArray = new int[radix];

        //Count the array at position(x)
        for(int value: input) {
            countArray[getDigit(position, value, radix)]++;
        }

        //Adjust the count array
        for(int j = 1; j < radix; j++) {
            countArray[j] += countArray[j - 1];
        }

        //Copy values into temp array
        int[] temp = new int[numItems];
        for(int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
            temp[--countArray[getDigit(position, input[tempIndex], radix)]] = input[tempIndex];
        }

        //Copy back into input array
        for(int tempIndex = 0; tempIndex < numItems; tempIndex++) {
            input[tempIndex] = temp[tempIndex];
        }
    }

    private static int getDigit(int position, int value, int radix) {
        return value / (int) Math.pow(radix, position) % radix;
    }
}
