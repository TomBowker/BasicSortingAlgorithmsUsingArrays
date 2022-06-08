/**
 * Insertion Sort
 * This sort starts with the left position assuming it has been sorted. It then traverses the array checking if it is
 * smaller to the others. How it does this is the array start with size 1, then 2 and so forth. Then it compares within
 * the smaller arrays who are the smallest and the largest ending up with a sorted array. This goes on until the last
 * position has traversed the array and has been inserted in its correct position.
 * O(n^2)
 * Stable and In-place algorithm
 */
package com.tombowker.insertion;

import com.tombowker.util.SortingUtil;

import java.util.Timer;
import java.util.TimerTask;

public class InsertionSort {
    public static int[] sort(int[] data) {
        Timer timer = new Timer();
        final int[] secondsPassed = {0};
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                secondsPassed[0]++;
            }
        };

        timer.schedule(timerTask, 0, 1);

        for(int firstUnsortedIndex = 1; firstUnsortedIndex < data.length; firstUnsortedIndex++) {
            int newElement = data[firstUnsortedIndex];
            int i;

            for(i = firstUnsortedIndex; i > 0 && data[i - 1] > newElement; i--) {
                data[i] = data[i - 1];
            }

            data[i] = newElement;
        }

        //SortingUtil.printResults(data);
        timer.cancel();
        System.out.println("Time to process for " + InsertionSort.class + " was: " + secondsPassed[0] + " milliseconds\n");

        return data;
    }
}
