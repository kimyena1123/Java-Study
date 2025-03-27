//package fastcampus.java.Course2.Part1;
//
//import com.google.gson.Gson;
//import fastcampus.java.Course2.Part1.model.Person;
//
//public class GsonToAPI {
//    public static void main(String[] args) {
//        Person person = new Person("김예나", 25);
//        Gson json = new Gson();
//        String contentToJson = json.toJson(person);
//        System.out.println(contentToJson); // {"name":"김예나","age":25}
//
//        Person person2 = json.fromJson(contentToJson, Person.class); //contentToJson 타입을 Person.class 타입으로 변환하겠다!
//        System.out.println(person2.getName());
//        System.out.println(person2.getAge());
//        System.out.println(person2.toString());
//
//    }
//}
