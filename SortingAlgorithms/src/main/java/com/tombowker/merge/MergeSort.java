/**
 * Sorting by Merge Sort
 * This is a divide and conquer algorithm, and it uses a recursive algorithm. It consists of two phases, first splitting
 * and second, merging. The Splitting phase leads to faster sorting during the merging phase. Splitting allows us to not
 * create new arrays.
 * In the splitting phase the process starts with an unsorted array. This array will be spilt into two arrays which are
 * unsorted, with the first array on the left and the second array on the right. We split the arrays again into two
 * arrays each. This process repeats itself until all the arrays have one element each. Then each array is sorted.
 * The merging phase has arrays combining every left/right pairs of sibling arrays into a sorted array. After the first
 * merge there will be a bunch of 2-element sorted arrays. Then merge those sorted arrays again to end up with a bunch
 * of 4-element sorted arrays and repeat this process until there is a completed sorted array.
 * O(nlogn) - base 2
 * Not an in-place algorithm, so if memory is an issue then use something else
 * Stable algorithm
 */
package com.tombowker.merge;

import com.tombowker.util.SortingUtil;

import java.util.Timer;
import java.util.TimerTask;

public class MergeSort {
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

        //merge sort algorithm
        split(data, 0, data.length);

        //SortingUtil.printResults(data);
        timer.cancel();
        System.out.println("Time to process for " + MergeSort.class + " was: " + secondsPassed[0] + " milliseconds\n");

        return data;
    }

    private static void split(int[] input, int start, int end) {
        //breaking statement for recursive loop
        if(end - start < 2) {
            return;
        }

        //break the array in half
        int mid = (start + end) / 2;

        split(input, start, mid);
        split(input, mid, end);
        merge(input, start, mid, end);
    }

    private static void merge(int[] input, int start, int mid, int end) {
        if(input[mid - 1] <= input[mid]) {
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;
        int[] temp = new int[end - start];

        while(i < mid && j < end) {
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }

        System.arraycopy(input, i, input, (start + tempIndex), (mid - i));
        System.arraycopy(temp, 0, input, start, tempIndex);
    }
}
