package fastcampus.java.Course1.model;

public class CarUtility {

    //매개변수로 자동차의 정보를 입력받아서 출력하는 메서드를 정의하시오
    public static void carPrint(CarDTO car){
        System.out.println(car.carSn + "\t" + car.carPrice + "\t" + car.carName + "\t" + car.carOwner + "\t" + car.carYear + "\t" + car.carType);
    }
}
