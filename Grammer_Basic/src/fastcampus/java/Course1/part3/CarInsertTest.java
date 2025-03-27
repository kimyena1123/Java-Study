package fastcampus.java.Course1.part3;

import fastcampus.java.Course1.model.CarDAO;
import fastcampus.java.Course1.model.CarDTO;

import java.util.Scanner;

public class CarInsertTest {
    public static void main(String[] args) {
        //자동차 정보를 키보드로부터 입력을 받아 DB에 저장을 하시오(JDBC)
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

        CarDTO car = new CarDTO();
        car.carSn = carSn;
        car.carName = carName;
        car.carPrice = carPrice;
        car.carOwner = carOwner;
        car.carYear = carYear;
        car.carType = carType;

        CarDAO dao = new CarDAO();
        dao.carInsert(car);
        dao.carSelect(car);
    }
}
