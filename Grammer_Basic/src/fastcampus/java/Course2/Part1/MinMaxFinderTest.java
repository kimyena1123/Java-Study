package fastcampus.java.Course2.Part1;

import fastcampus.java.Course2.Part1.model.MinMaxFinder;

public class MinMaxFinderTest {
    public static void main(String[] args) {
        int[] arr = {4, 5, 2, -1, 10, 43};

        int min = MinMaxFinder.findMin(arr);
        int max = MinMaxFinder.findMax(arr);

        System.out.println("Minimum value: " + min);
        System.out.println("maximum value: " + max);
    }
}
