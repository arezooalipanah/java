package org.example.recursive;

public class SumOfArray {
    public static int calcSum(int[] list, int n) {
        if (n <= 0) {
            return 0;
        }

        return calcSum(list, n - 1) + list[n - 1];
    }
}

class Main1 {
    public static void main(String[] args) {
        int arr[] = {2, 5, 6, 8, 9, 12, 15};
        int sum = SumOfArray.calcSum(arr, arr.length);
        System.out.println(sum);
    }
}
