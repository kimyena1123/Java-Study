package fastcampus.java.Course1.part2;

public class BreakContinueTest {
    public static void main(String[] args) {
        char[] arrays = {'s','h','u','t','d','o','w','n'};
        //o라는 문자를 만나면 반복을 중지하시오

        System.out.println("=========== first ============");
        for(char array : arrays){
            if(array == 'o'){
                break;
            }
            System.out.print(array);
        }
        System.out.println();

        System.out.println("=========== second ============");

        for(int i = 0; i < arrays.length; i++){
            if(arrays[i] == 'o'){
                break;
            }
            System.out.print(arrays[i]);
        }
        System.out.println();

        //1~10까지의 숫자 중 3의 배수의 개수를 구하여 출력하시오
        int cnt = 0;
        for(int i = 1; i <= 10; i++){
            if(i % 3 == 0)
                cnt++;
        }
        System.out.println("3의 배수 개수: " + cnt + "개");
    }
}
