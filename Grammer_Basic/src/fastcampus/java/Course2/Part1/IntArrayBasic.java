package fastcampus.java.Course2.Part1;

public class IntArrayBasic {
    public static void main(String[] args) {
        //정수 5개를 배열에 저장하고 출력하시오
        int[] array = new int[5]; //배열 생성 동작: 고정길이(단점) > 가변길이?
        array[0] = 1; //저장동작(입력,추가)
        array[1] = 2;
        array[2] = 3;
        array[3] = 4;
        array[4] = 5;

        //array.length: 길이를 구하는 동작
        System.out.print("array: ");
        for(int i = 0; i < array.length; i++) {
            int data=array[i];//데이터를 얻는 동작(가져오는 동작)
            System.out.print(data + " ");
        }
        System.out.println();

        //향상된 for문(foreach)
        for(int data: array){
            System.out.print(data + " ");
        }
    }
}
