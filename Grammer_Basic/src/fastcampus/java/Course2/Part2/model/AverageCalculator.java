package fastcampus.java.Course2.Part2.model;

public class AverageCalculator <T extends Number> {
    private T[] numbers;

    public AverageCalculator(T[] numbers){
        this.numbers = numbers;
    }

    public double calculateAverage(){
        double sum = 0.0;

        for(T number: numbers){
            //제너릭 타입 T는 컴파일 시점에 정확한 타입을 알 수 없다.
            //따라서 연산을 수행하려면 Number의 메서드(doubleValue(), intValue(), floatValue() 등)를 사용하여 기본형(primitive type)으로 변환해야 한다
            sum += number.doubleValue();
        }

        return sum / numbers.length;
    }
}
