package fastcampus.java.Course1.part3;

import fastcampus.java.Course1.model.CarDTO;

import java.util.Scanner;

public class CarTest {
    public static void main(String[] args) {
        //자동차의 정보를 [키보드로부터 입력] 받아서 [다른 메서드]로 이동해야 하는 경우를 생각해보자
        Scanner scan = new Scanner(System.in);

        System.out.print("자동차 일련변호: ");
        int carSn = scan.nextInt();

        scan.nextLine();

        System.out.print("자동차 이름: ");
        String carName = scan.nextLine();

        System.out.print("자동차 가격: ");
        int carPrice = scan.nextInt();

        scan.nextLine();

        System.out.print("자동차 소유자: ");
        String carOwner = scan.nextLine();

        System.out.print("자동차 년식: ");
        int carYear = scan.nextInt();

        scan.nextLine();

        System.out.print("자동차 타입: "); //G(휘발유), D(경유)
        String carType = scan.nextLine();

//        System.out.println(carSn + "\t" + carPrice + "\t" + carName + "\t" + carOwner + "\t" + carYear + "\t" + carType);

        //자동차 데이터를 이동하기 위한 바구니가 필요하-> (DTO, VO)
        //클래스로 CarDTO or CarVO를 설계한다
//        carInfoPrint(carSn, carName, carPrice, carOwner, carYear, carType);
        CarDTO car = new CarDTO();
        car.carSn = carSn;
        car.carName = carName;
        car.carPrice = carPrice;
        car.carOwner = carOwner;
        car.carYear = carYear;
        car.carType = carType;

        carInfoPrint(car);

    }
    //매개변수로 자동차의 정보를 받아서 출력하는 메서드를 정의하시오
    public static void carInfoPrint(CarDTO car){
        System.out.println(car.carSn + "\t" + car.carPrice + "\t" + car.carName + "\t" + car.carOwner + "\t" + car.carYear + "\t" + car.carType);
    }
}
