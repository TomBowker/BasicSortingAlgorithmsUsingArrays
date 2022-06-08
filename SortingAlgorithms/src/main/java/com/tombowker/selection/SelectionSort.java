/**
 * Selection Sort
 * Similar to Bubble sort, but instead it will traverse the whole array comparing each value and selecting the position
 * where it is the largest number exists and repeats.
 * O(n^2)
 * In-place algorithm and it is an unstable algorithm
 */
package com.tombowker.selection;

import com.tombowker.util.SortingUtil;

import java.util.Timer;
import java.util.TimerTask;

public class SelectionSort {
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

        for(int lastUnsortedIndex = data.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            int largestValue = 0;

            for(int i = 1; i <= lastUnsortedIndex; i++) {
                if(data[i] > data[largestValue]) {
                    largestValue = i;
                }
            }

            SortingUtil.swap(data, largestValue, lastUnsortedIndex);
        }

        //SortingUtil.printResults(data);
        timer.cancel();
        System.out.println("Time to process for " + SelectionSort.class + " was: " + secondsPassed[0] + " milliseconds\n");

        return data;
    }
}
