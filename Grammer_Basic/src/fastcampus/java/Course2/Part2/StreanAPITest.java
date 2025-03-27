package fastcampus.java.Course2.Part2;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StreanAPITest {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5};
        int evenSum = 0;

        for(int number : numbers){
            if(number % 2 == 0){
                evenSum += number;
            }
        }
        System.out.println("for문으로 합계 구하기: " + evenSum);

        //Stream으로 해보자
        int streamIntSum = Arrays.stream(numbers)
                .filter(n -> n % 2 == 0) // n->n%2==0 : 람다식(lambda)
                .sum();

        System.out.println("stream으로 합계구하기: " + streamIntSum);

        //stream으로 바꾼 후에, 짝수만 골라서 그걸 다시 배열로 바꾸기
        int[] streamIntSumToArray = Arrays.stream(numbers)
                .filter(n->n%2==0)
                .toArray();

        for(int data : streamIntSumToArray){

            System.out.println(data);
        }
    }
}
