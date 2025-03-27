package fastcampus.java.Course1.part2;

public class LoopLoopTest {
    public static void main(String[] args) {
        int[][] array = {
                {1,2,3,4,5},
                {6,7,8,9,10}
        };

        //위 배열 출력하기
        for(int i = 0; i<array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        //이중 반복문을 사용하여 구구단을 출력하시오
        //7단까지만 출력하기

        for(int i = 2; i < 8; i++){
            System.out.printf("\n========== %d단 구구단 ==========\n", i);
            for(int j = 1; j < 10; j++){
                System.out.printf("%d X %d = %d\n", i, j, i*j);
            }
            System.out.printf("========== %d단 구구단 끝 ==========", i);
        }
        System.out.println();
        System.out.println();
        System.out.println();


        //방법2
        for(int i = 2; i <= 9; i++){
            System.out.print(i+"단"+"\t\t");
        }
        System.out.println();

        for(int i = 1; i <= 9; i++){
            for(int j = 2; j<= 9; j++){
                System.out.print(j+"X"+i+"="+(j*i)+"\t");
            }
            System.out.println();
        }
    }
}
