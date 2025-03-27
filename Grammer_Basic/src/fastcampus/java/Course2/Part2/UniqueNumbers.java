package fastcampus.java.Course2.Part2;

import java.util.HashSet;
import java.util.Set;

public class UniqueNumbers {
    public static void main(String[] args) {

        int[] numbers = {1,2,3,4,5,2,4,6,7,1,1,3};

        //HashSet 객체 생성
        Set<Integer> uniqueNumbers = new HashSet<>();

        //중복되지 않은 숫자들을 HashSet에 추가
        for(int number: numbers){
            uniqueNumbers.add(number);
        }

        //중복되지 않은 숫자들 출력
        System.out.print("Unique Numbers: ");
        for(int number: uniqueNumbers){
            System.out.print(number + " ");
        }
    }
}
