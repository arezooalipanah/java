package org.example.recursive;

import java.util.Arrays;

public class MaxItemArray {
    public static int finaMax(int[] list) {
        if (list.length == 2) {
            return list[0] > list[1] ? list[0] : list[1];
        }

        int subMAx = finaMax(Arrays.copyOfRange(list, 1, list.length));

        return list[0] > subMAx ? list[0] : subMAx;
    }
}

class Main3 {
    public static void main(String[] args) {
        int arr[] = {2, 5, 6, 8, 27, 12, 15};
        int count = MaxItemArray.finaMax(arr);
        System.out.println(count);
    }
}
