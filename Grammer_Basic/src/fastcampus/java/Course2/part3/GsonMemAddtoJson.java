package fastcampus.java.Course2.part3;

import com.google.gson.Gson;
import fastcampus.java.Course2.part3.model.Address;
import fastcampus.java.Course2.part3.model.Person;

public class GsonMemAddtoJson {
    public static void main(String[] args) {

        Address address = new Address("서울", "한국");
        Person person = new Person("홍길동", 25, "hong@example.com", address);

        //Person -> JSON
        Gson gson = new Gson();
        String json = gson.toJson(person);
        System.out.println(json); //{"name":"홍길동","age":25,"email":"hong@example.com","address":{"city":"서울","country":"한국"}}
    }
}
