package fastcampus.java.Course2.Part1.model;

public class MinMaxFinder {

    public static int findMin(int[] arr){

        int min = arr[0];

        for(int i = 0; i < arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }

    public static int findMax(int[] arr){
        int max = arr[0];

        for (int content : arr) {
            if (content > max) {
                max = content;
            }
        }
        return max;
    }
}
