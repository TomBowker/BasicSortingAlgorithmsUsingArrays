/**
 * Sorting by Counting
 * This makes assumptions about the data it will be using, meaning that it cannot work with floats, doubles, strings
 * etc... This algorithm does not use comparisons and will count the number of occurrences of each value. Again, this
 * only works with non-negative numbers, and values must be in a specific range;
 * This is not a in-place algorithm
 * O(n) this can be achieved because we're making assumptions about the data
 * can be stable, be this one is unstable
 */
package com.tombowker.counting;

import com.tombowker.util.SortingUtil;

import java.util.Timer;
import java.util.TimerTask;

public class CountingSort {
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

        //counting sort algorithm
        countingSort(data, 0, 100000);


        //SortingUtil.printResults(data);
        timer.cancel();
        System.out.println("Time to process for " + CountingSort.class + " was: " + secondsPassed[0] + " milliseconds\n");

        return data;
    }

    private static void countingSort(int[] input, int min, int max) {
        int[] countArray = new int[(max - min) + 1];

        //count each value
        for(int i = 0; i < input.length; i++) {
            countArray[input[i] - min]++;
        }

        //write the value to the array
        int j = 0;
        for(int i = min; i <= max; i++) {
            while(countArray[i - min] > 0){
                input[j++] = i;
                countArray[i - min]--;
            }
        }
    }
}
