package org.example.recursive;

import java.util.Arrays;

public class CountNumberInArray {
    public static int doCount(int[] list) {
        if (list.length == 0) {
            return 0;
        }
        return 1 + doCount(Arrays.copyOfRange(list, 1, list.length));
    }
}

class Main2 {
    public static void main(String[] args) {
        int arr[] = {2, 5, 6, 8, 9, 12, 15};
        int count = CountNumberInArray.doCount(arr);
        System.out.println(count);
    }
}
