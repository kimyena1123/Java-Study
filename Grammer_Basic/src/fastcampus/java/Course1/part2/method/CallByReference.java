package fastcampus.java.Course1.part2.method;

import java.util.Scanner;

public class CallByReference {
    public static void main(String[] args) {
        // 매개변수로 정수형 배열을 받아서 배열의 총합을 구해 리턴하는 메서드 정의

        Scanner scan = new Scanner(System.in);
        int[] array = new int[3]; // 3개의 값만 저장할 수 있음

        System.out.print("정수 3개를 입력하시오: ");
        for(int i = 0; i < array.length; i++){
            array[i] = scan.nextInt();
        }

        System.out.print("배열에 저장된 값: ");
        for(int content: array){
            System.out.print(content + " ");
        }

        System.out.println();

        int result = add(array);
        System.out.println("총합: " + result);
    }

    public static int add(int[] array){
        int sum = 0;
        System.out.print("메서드에서 받은 배열 확인: ");
        for(int content: array){
            System.out.print(content + " ");
            sum += content;
        }
        System.out.println();

        return sum;
    }
}
