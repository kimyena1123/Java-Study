package fastcampus.java.Course1.part2;

public class TwoDimArrayInit {

    public static void main(String[] args) {
        // 2차원 배열의 초기화(행 단위로 초기화)와 반복문을 활용한 원소 접근
        int[][] array = {
                {1,2,3,4}, // 행1 열4
                {5,6,7,8} // 행2 열4
        };


        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();


        //가변길이 배열 만들기
        char[][] array2 = new char[5][];
        array2[0] = new char[1];
        array2[1] = new char[2];
        array2[2] = new char[3];
        array2[3] = new char[4];
        array2[4] = new char[5];

        for(int i = 0; i < array2.length; i++){
            for(int j = 0; j < array2[i].length; j++){
                array2[i][j] = '*';
                System.out.print(array2[i][j] + " ");
            }
            System.out.println();
        }

    }


}
