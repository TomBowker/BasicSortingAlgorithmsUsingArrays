/**
 * Sorting by Quick Sort
 * This is a divide and conquer algorithm, and it will use recursion to achieve this. It uses a pivot element to
 * partition the array into two parts. Elements less than the pivot will be to the left and elements greater than the
 * pivot will be to the right. The pivot will then be in its correct sorted position. Then the pivot will be in its
 * correct sorted position. The left and right arrays may not be sorted in relation to each other. This process is
 * repeated for the left and the right array. Eventually, every element has been the pivot, so every element will be in
 * its correct sorted position. As with merge sort, we'll end up partitioning the array into a series of 1-element
 * arrays. Does this in-place, unlike merge sort.
 * The is O(nlogn) -base 2 because we are splitting the arrays into two. i.e. base 3 would be splitting it into three
 * parts. At worse this is O(n^2), but on average this is O(nlogn).
 * This is an unstable algorithm
 */
package com.tombowker.quick;

import com.tombowker.util.SortingUtil;

import java.util.Timer;
import java.util.TimerTask;

public class QuickSort {
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

        //quick sort algorithm
        quickSort(data, 0, data.length);

        //SortingUtil.printResults(data);
        timer.cancel();
        System.out.println("Time to process for " + QuickSort.class + " was: " + secondsPassed[0] + " milliseconds\n");

        return data;
    }

    private static void quickSort(int[] input, int start, int end) {
        if(end - start < 2) {
            return;
        }

        int pivotIndex = partition(input, start, end);
        quickSort(input, start, pivotIndex);
        quickSort(input, pivotIndex + 1, end);
    }

    private static int partition(int[] input, int start, int end) {
        int pivot = input[start];
        int i = start;
        int j = end;

        while(i < j) {
            // NOTE: This is an empty loop.
            while(i < j && input[--j] >= pivot);

            if(i < j) {
                input[i] = input[j];
            }

            // NOTE: This is an empty loop.
            while(i < j && input[++i] <= pivot);

            if(i < j) {
                input[j] = input[i];
            }
        }

        input[j] = pivot;

        return j;
    }
}
