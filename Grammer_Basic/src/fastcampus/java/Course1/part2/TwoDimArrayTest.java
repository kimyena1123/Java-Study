package fastcampus.java.Course1.part2;

public class TwoDimArrayTest {
    public static void main(String[] args) {
    // Q. 2행 4열의 [정수형] [배열을 생성]하시오
        int[][] array = new int[2][4];

        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                array[i][j] = 10;
            }
        }

        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                System.out.println(array[i][j]);
            }
        }

    }
}
