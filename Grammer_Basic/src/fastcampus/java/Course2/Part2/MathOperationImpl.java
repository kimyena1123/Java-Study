package fastcampus.java.Course2.Part2;

import fastcampus.java.Course2.Part2.model.MathOperation;

//인터페이스를 구현한 구현체를 외부에 만들어놓고 사용하는 방법
public class MathOperationImpl implements MathOperation {

    @Override
    public int operation(int x, int y) {
        return x + y;
    }
}
