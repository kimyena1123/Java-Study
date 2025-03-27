package fastcampus.java.Course2.Part2;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        //key-value 형태의 데이터를 관리하는 Map 객체 생성
        Map<String, Integer> studentScores = new HashMap<>();

        //데이터 추가
        studentScores.put("Kim", 95);
        studentScores.put("Lee", 85);
        studentScores.put("Park", 90);
        studentScores.put("Choi", 80);

        //데이터 조회
        System.out.println("kim's score: " + studentScores.get("Kim"));
        System.out.println("lee's score: " + studentScores.get("Lee"));
        System.out.println();

        //데이터 수정
        studentScores.put("Park", 99);
        System.out.println("park's score: " + studentScores.get("Park"));
        System.out.println();


        //데이터 삭제
        studentScores.remove("Choi");
        System.out.println("Choi's socre after removal: " + studentScores.get("Choi"));
        System.out.println();


        //전체 데이터 출력
        for(Map.Entry<String, Integer> data : studentScores.entrySet()){
            System.out.println(data.getKey() + "'s socre: " + data.getValue());
        }
    }
}
