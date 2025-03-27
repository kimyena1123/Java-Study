package fastcampus.java.Course2.Part1;

import java.util.Random;

public class RandomAPI {
    public static void main(String[] args) {
        Random rand = new Random();

        int[] arr = new int[10];
        int i = 0;

        while(i < arr.length) {
            int num = rand.nextInt(45) + 1; //1부터 45사이의 난수를 반환
//            int num = rand.nextInt(45); //0이상 34 미만의 난수를 반환
            boolean isDuplicate = false;

            //배열의 이전 인덱스과 비교해 중복되는지 확인한다
            for(int j = 0; j < i; j++) {
                if(arr[j] == num) {
                    isDuplicate = true;
                    break;
                }
            }

            //중복되지 않으면 배열에 추가한다
            if(!isDuplicate) {
                arr[i++] = num; //후위연선자 -> 예) arr[0]이 값을 넣은 후에, i값 +1된다.
            }
        }

        for(int num : arr) {
            System.out.print(num + " ");
        }
    }
}
