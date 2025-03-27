package fastcampus.java.Course1.part2;

public class CharTest {
    public static void main(String[] args) {

        int a = 'A'; //65
        int b = 'B' + 1; //67
        System.out.println("b: " + (char)b); // 67 -> C

        // 1. '가'라는 한글 한 문자를 변수에 저장하고 출력하시오
        char han = '가';
        System.out.println("han: "+ han);
        int hanD = '가';
        System.out.println("hanD: "+ hanD);

        //2. 대문자 'A'를 문자 'a'로 변환하여 출력하시오
        char upper = 'A';
        char lower = (char)(upper + 32);
        System.out.println("lower: " + lower);

        //3. '1' + '2" = 3이 나오도록 프로그래밍 하시오
        char num1 = '1' - 48; // 1의 아스키코드 49
//        char num1 = '1' - '0';
        char num2 = '2' - 48; // 2의 아스키코드 50
//        char num2 = '2' - '0';
        // '0'의 아스키코드 값은 48이다.

        int sum = num1 + num2;
        System.out.println("sum: " + sum); // 3


        //4. '1'+'2'+'3'+'4'+'5'=15가 나오도록 프로그래밍 하시오
        char[] number = {'1','2','3','4','5'};
        int total = 0;

        for(int i = 0; i < number.length; i++){
            total += number[i] - 48;
        }
        System.out.println("방법1 " + total);


        //4. '1'+'2'+'3'+'4'+'5'=15가 나오도록 프로그래밍 하시오(방법2)
        int total2 = 0;
        for(int i = 1; i < 6; i++){
            total2 += (char)('0' + i) - 48;
        }
        System.out.println("방법2: " + total2);

    }
}
