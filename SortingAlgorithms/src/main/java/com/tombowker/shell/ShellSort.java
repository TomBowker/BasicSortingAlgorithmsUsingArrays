/**
 * Shell Sort
 * This is a variation of the insertion sort. Shell sort starts with using a larger gap value and reduces the gap as the
 * algorithm runs vs insertion sort has a gap value of one. This has a goal of reducing the amount of shifting. At the
 * last stage where the gap value is now one, the sorting algorithm runs an insertion sort, however it has a lot less of
 * shifting. Depending on the gap value, this sorting algorithm can have the time complexity change on it. The gap value
 * is calculated using (3^k - 1) / 2 typically, however in this algorithm the base gap is based on the length of the
 * array divide by two. In each iteration we keep dividing the gap by two.
 * This is an unstable and in-place algorithm
 * At worst O(n^2), but can perform much better than that.
 */
package com.tombowker.shell;

import com.tombowker.util.SortingUtil;

import java.util.Timer;
import java.util.TimerTask;

public class ShellSort {
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

        for(int gap = data.length / 2; gap > 0; gap /= 2) {
            for(int i = gap; i < data.length; i++) {
                int newElement = data[i];
                int j = i;

                while(j >= gap && data[j - gap] > newElement) {
                    data[j] = data[j - gap];
                    j -= gap;
                }

                data[j] = newElement;
            }
        }


        //SortingUtil.printResults(data);
        timer.cancel();
        System.out.println("Time to process for "+ ShellSort.class + " was: " + secondsPassed[0] + " milliseconds\n");

        return data;
    }
}
