package com.github.lt;

import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int length = arr.length;
        int wall = 0;
        int point = length - 1;
        int temp = 0;
        while (wall < length) {
            while (point > wall) {
                if (arr[point] < arr[point - 1]) {
                    temp = arr[point];
                    arr[point] = arr[point - 1];
                    arr[point - 1] = temp;
                }
                point--;
            }
            point = length - 1;
            wall++;
        }
    }

    public static void main(String[] args) {
        int[] testArr = {23, 78, 45, 8, 32, 56};
        bubbleSort(testArr);
        System.out.println(Arrays.toString(testArr));
    }
}
