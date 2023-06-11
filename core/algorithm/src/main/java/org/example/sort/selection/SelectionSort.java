package org.example.sort.selection;

import java.util.Arrays;

public class SelectionSort {

    private static int findSmallest(Integer[] list) {
        int smallest = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i]  != null && list[i] < smallest) {
                smallest = list[i];
                index = i;
            }
        }
        return index;
    }


    public static Integer[] sort(Integer[] list) {
        Integer[] sortedList = new Integer[list.length];
        int index =0;
        for (int i = 0; i < list.length; i++) {
            int smallest = findSmallest(list);
            sortedList[index++] = list[smallest];
            list[smallest] = null;
        }

        return sortedList;
    }
}

class Main {
    public static void main(String[] args) {
        Integer[] sort = SelectionSort.sort(new Integer[]{5,3,6,2,10});
        System.out.println(Arrays.toString(sort));
    }
}
