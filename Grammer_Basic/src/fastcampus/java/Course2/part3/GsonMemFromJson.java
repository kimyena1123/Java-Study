package fastcampus.java.Course2.part3;

import com.google.gson.Gson;
import fastcampus.java.Course2.part3.model.Person;

public class GsonMemFromJson {
    public static void main(String[] args) {
        String json = "{\"name\":\"홍길동\",\"age\":25,\"email\":\"hong@example.com\",\"address\":{\"city\":\"서울\",\"country\":\"한국\"}}";

        Gson gson = new Gson();
        Person person = gson.fromJson(json, Person.class);
        System.out.println(person); //Person{name='홍길동', age=25, email='hong@example.com', address=Address{city='서울', country='한국'}}
    }
}
