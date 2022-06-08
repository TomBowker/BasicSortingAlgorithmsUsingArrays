package com.tombowker.main;

import com.tombowker.bubble.BubbleSort;
import com.tombowker.counting.CountingSort;
import com.tombowker.insertion.InsertionSort;
import com.tombowker.merge.MergeSort;
import com.tombowker.quick.QuickSort;
import com.tombowker.radix.RadixSort;
import com.tombowker.selection.SelectionSort;
import com.tombowker.shell.ShellSort;
import com.tombowker.util.SortingUtil;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] radixArray = {2000, 3576, 1534, 7543, 5512, 1345, 2267, 1234, 1000, 3200, 4578, 1289, 2457, 5467, 7500};
        int[] data = SortingUtil.setTestData();

        System.out.println("Bubble Sort...");
        BubbleSort.sort(data);
        data = SortingUtil.setTestData();

        System.out.println("Selection Sort...");
        SelectionSort.sort(data);
        data = SortingUtil.setTestData();

        System.out.println("Insertion Sort...");
        InsertionSort.sort(data);
        data = SortingUtil.setTestData();

        System.out.println("Shell Sort...");
        ShellSort.sort(data);
        data = SortingUtil.setTestData();

        System.out.println("Merge Sort...");
        MergeSort.sort(data);
        data = SortingUtil.setTestData();

        System.out.println("Quick Sort...");
        QuickSort.sort(data);
        data = SortingUtil.setTestData();

        System.out.println("Counting Sort...");
        CountingSort.sort(data);

        System.out.println("Radix Sort...");
        RadixSort.sort(radixArray);
    }
}
