package fastcampus.java.Course2.part3;

import com.google.gson.Gson;
import fastcampus.java.Course2.part3.model.Member;

public class GsonToJson {
    public static void main(String[] args) {

        Member member = new Member("홍길동", 25, "hong@example.com");
        System.out.println(member); //Member{name='홍길동', age=25, email='hong@example.com'}

        Gson gson = new Gson();
        String json = gson.toJson(member);
        System.out.println(json); //{"name":"홍길동","age":25,"email":"hong@example.com"}
    }
}
