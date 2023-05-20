package com.sorting;

public class SelectionSort {
    public static void swap(int[] arr, int i, int j) {
        if (i == j)
            return;
        int temp = 0;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {20, 35, -15, 7, 55, 1, -22};
        for (int i = arr.length - 1; i > 0; --i)//i = last unsorted index
        {
            int largest = 0;
            for (int j = 0; j <= i; ++j) {
                if (arr[j] > arr[largest])
                    largest = j;
            }
            swap(arr, largest, i);
        }
        for (int i = 0; i < arr.length; ++i)
            System.out.println(arr[i]);
    }
}
