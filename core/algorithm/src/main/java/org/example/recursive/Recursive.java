package org.example.recursive;

public class Recursive {
    public static int sumOfArray(int[] list, int n) {
        if (n <= 0) {
            return 0;
        }

        return sumOfArray(list, n - 1) + list[n - 1];
    }
}

class Main {
    public static void main(String[] args) {
        int arr[] = {2, 5, 6, 8, 9, 12};
        int sum = Recursive.sumOfArray(arr, arr.length);
        System.out.println(sum);
    }
}
