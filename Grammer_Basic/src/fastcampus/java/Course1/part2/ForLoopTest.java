package fastcampus.java.Course1.part2;

public class ForLoopTest {
    public static void main(String[] args) {
        //1. 반복문을 사용하여 알파벳 대문자와 아스키코드 값을 출력하시오
        char var = 'A';
        System.out.println(var + " " + (int)var);

        for(int i = 65; i <= 90; i++){
            System.out.println(i + " " + (char)i);
        }

        System.out.println();

        for(char c='A'; c<='Z'; c++){
            System.out.println(c+ " " + (int)c);
        }


        //2. 향상된 for문으로 출력하시오
        int[] numbers = {1,2,3,4,5,6,7,8,9,10};

        for(int number: numbers){
            System.out.print(number+" ");
        }

        System.out.println();

        for(int i = 0; i < numbers.length; i++){
            System.out.println ("i: " + numbers[i]);
        }

        int cnt = 0;
        while(cnt < numbers.length){
            System.out.println("while문 사용>> " + numbers[cnt]);
            cnt++;
        }

        //while문 사용: 0~5까지의 수를 출력하기
        int a = 0;
        while(a < 6){
            System.out.println(a);
            a++;
        }

        //do~while문 사용: 1~10까지 출력
        int b= 1;
        do{
            System.out.println(b);
            b++;
        }while(b <= 10);


    }
}
