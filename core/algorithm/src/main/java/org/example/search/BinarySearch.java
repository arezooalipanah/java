package org.example.search;

import java.util.List;
import java.util.Optional;

public class BinarySearch {

    public static Optional<Integer> binarySearch(int[] list, int item) {
        int low = 0;
        int high = list.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int guess = list[mid];
            if (guess == item) {
                return Optional.of(mid);
            }
            if (guess < item) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return Optional.empty();
    }
}

class Main {
    private static int $;
    public static void main(String[] args) {
        Optional<Integer> item = BinarySearch.binarySearch(new int[]{5, 8, 9, 12, 13}, 5);
//        System.out.println("item is : " + item.isPresent(() -> ));

        String a_b;
        System.out.print($);
        System.out.print(a_b);

    }
}