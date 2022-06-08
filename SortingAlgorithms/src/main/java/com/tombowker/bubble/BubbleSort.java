/**
 * Bubble Sort
 * Very commonly taught algorithm, however it degrades as it has to process more data. Bubble sort compares the left
 * position to the right. This then will in turn move the left position if it's greater to the right, or does nothing if
 * it's less than the right position. It keeps doing this until the last position, at that point it is sorted.
 * O(n^2)
 * in-place algorithm
 * It will take 100 steps to sort 10 items, 10,000 steps to sort 100 items, and etc...
 */
package com.tombowker.bubble;

import com.tombowker.util.SortingUtil;

import java.util.Timer;
import java.util.TimerTask;

public class BubbleSort {
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
            for(int i = 0; i < lastUnsortedIndex; i++) {
                if(data[i] > data[i + 1]) {
                    SortingUtil.swap(data, i, i + 1);
                }
            }
        }

        //SortingUtil.printResults(data);
        timer.cancel();
        System.out.println("Time to process for " + BubbleSort.class + " was: " + secondsPassed[0] + " milliseconds\n");

        return data;
    }
}
