package fastcampus.java.Course1.part2;

import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args) { // 정수 5개를 배열에 초기화하고 index 0번ㅉ때와 index 3번째 값을 더하여 출력하시오
        //방법1
        int[] arr1 = {10,20,30,40,50};

        //방법2
        int[] arr2;
        arr2 = new int[]{10,20,30,40,50};

        //방법3
        int[] arr = new int[5];
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        arr[3] = 40;
        arr[4] = 50;

        //배열 출력: for문 사용하거나 Arrays.toString() 메서드 사용
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " "); //10 20 30 40 50
        }
        System.out.println();
        System.out.println(Arrays.toString(arr)); //[10, 20, 30, 40, 50]

        System.out.println(arr[0] + arr[3]); //50
    }
}
