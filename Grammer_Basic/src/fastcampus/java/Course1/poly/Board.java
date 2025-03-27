package fastcampus.java.Course1.poly;

public class Board extends Object{ //Object 클래스 안에는 toString이라는 메서드가 있기 떄문에, 부모(Object)가진 toString을 사용할 수 있다.
    private String title;


    //setter
    public void setTile(String title){
        this.title = title;
    }

    //getter
    public String getTitle(){
        return title;
    }

    //Object 클래스의 toString은 생성된 메모리의 번지를 문자열로 바꿔서 출력해주는 역할이다.
    //그래서 자식 클래스에서 오버라이딩을 안하면 메모리의 번지가 나올거다.
    //그래서 오버라이딩을 해서 내가 원하는 결과가 출력되도록 오버라이딩한다.
    @Override //Object 클래스(부모)클래스의 메서드를 오버라이딩
    public String toString(){
        //부모 클래스의 toString과 내가 재정의한 toString을 하고 싶다면, super 이용
        System.out.println(super.toString()); // 상위 클래스의 메서드 호출
        return title;
    }
}
