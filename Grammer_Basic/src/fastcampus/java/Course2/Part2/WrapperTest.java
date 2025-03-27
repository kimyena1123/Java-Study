package fastcampus.java.Course2.Part2;

public class WrapperTest {
    public static void main(String[] args) {

        // 정수형 변수에 10을 저장하세요
        int value = 10; // 기본 자료형(primitive data type)
//        Integer objectValue = new Integer(value); // 사용자 정의 자료형 boxing
        Integer objetValue = value; //Auto-boxing
        System.out.println(objetValue.intValue()); //Unboxing(Integer->int)

        Integer objectValue2 = 20; // Auto-boxing
        int value2 = objectValue2; //Auto-Unboxing
        System.out.println(value2);

        float floatValue = 10.5f;
        Float objectFloatValue = floatValue; //new FLoat(10.5f); <- Auto-boxing
        System.out.println(objectFloatValue.floatValue());

        Float objectFloatValue2 = 49.1f;
        float floatValue2 = objectFloatValue2; //auto-boxing
        System.out.println(floatValue2);
    }

}
