package fastcampus.java.Course1.part4;

public class EmployeeTest {
    public static void main(String[] args) {
        //일반 사원 한명의 객체를 생성하고 데이터를 저장 후 출력하시오
//        RempVO vo = new RempVO();
//        vo.name = "김예나";
//        vo.age = 25;
//        vo.phone = "010-5457-1396";
//        vo.empDate = "2025.09.01";
//        vo.dept="개발팀";
//        vo.marriage=false;

//        System.out.println(vo.name + "\t" + vo.age + "\t" + vo.phone + "\t" + vo.empDate + "\t" + vo.dept + "\t" + vo.marriage);
//        System.out.println();
//        System.out.println(vo.toString());

        //생성자를 통해서 초기화하기
        RempVO vo2 = new RempVO("김예나", 25, "010-5457-1496", "2025.09.01", "전산팀", false);
        System.out.println(vo2);
    }
}
