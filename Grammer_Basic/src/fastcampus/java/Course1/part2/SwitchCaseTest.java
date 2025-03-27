package fastcampus.java.Course1.part2;

public class SwitchCaseTest {
    public static void main(String[] args) {
        // switch~case문을 이용해 요일에 해당하는 운동을 출력하시오
        String day = "Tuesday";

        switch(day){
            case "Sunday":
                System.out.println("야구");
                break;
            case "Monday":
                System.out.println("농구");
                break;
            case "Tuesday":
            case "Wednesday":
                System.out.println("수영");
                break;
            default:
                System.out.println("휴식");
        }
    }
}
