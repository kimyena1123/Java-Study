package fastcampus.java.Course1.model;

public class CarDAO {
    //CRUD
    public void carInsert(CarDTO car){
        //DB연결, insert SQL
        System.out.println("car 정보가 DB에 저장이 되었습니다");
    }

    public void carSelect(CarDTO car){
        System.out.println("정보 가져옴");
    }

}
