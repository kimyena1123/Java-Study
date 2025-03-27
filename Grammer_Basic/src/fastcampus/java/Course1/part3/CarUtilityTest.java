package fastcampus.java.Course1.part3;

import fastcampus.java.Course1.model.CarDTO;
import fastcampus.java.Course1.model.CarUtility;

import static fastcampus.java.Course1.model.CarUtility.carPrint;

public class CarUtilityTest {
    public static void main(String[] args) {
        //자동차 정보를 출력하는 동작을 가지고 있는 Utility 클래스를 설계하시오
        int carSn = 1110;
        String carName = "BMW828i";
        int carPrice = 50000;
        String carOwner = "홍길동";
        int carYear = 2015;
        String carType = "G"; //'G' -> char

        CarDTO car = new CarDTO();
        car.carSn = carSn;
        car.carName = carName;
        car.carPrice = carPrice;
        car.carOwner = carOwner;
        car.carYear = carYear;
        car.carType = carType;
        CarUtility carUtil = new CarUtility();
        carUtil.carPrint(car);
    }

}
