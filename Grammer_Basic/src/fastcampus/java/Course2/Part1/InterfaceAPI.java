package fastcampus.java.Course2.Part1;

import fastcampus.java.Course2.Part1.model.BB;
import fastcampus.java.Course2.Part1.model.CC;

public class InterfaceAPI {
    public static void main(String[] args) {
        //CC(인터페이스)를 이용하여 BB(클래스)를 동작시키는 프로그램 <- 인터페이스 기반의 프로그래밍
        CC c = new BB();

        //CC로 BB를 동작시킴
        c.x(); // BB 클래스의 X 메서드 동작한 -> 동적바인딩
        c.y();
        c.z();

    }
}
