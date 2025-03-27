package fastcampus.java.Course2.part3;

import com.google.gson.Gson;
import fastcampus.java.Course2.part3.model.Member;

public class GsonFromJson {
    public static void main(String[] args) {
        String json = "{\"name\":\"홍길동\", \"age\":18,\"email\":\"hong@examile.com\"}";
        System.out.println(json); //{"name":"홍길동", "age":18,"email":"hong@examile.com"}

        Gson gson = new Gson();
        Member member = gson.fromJson(json, Member.class); // json을 어떤 객체 타입으로 바꿀 것인가

        System.out.println(member); //Member{name='홍길동', age=18, email='hong@examile.com'}
    }
}
