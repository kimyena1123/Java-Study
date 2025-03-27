package fastcampus.java.Course2.Part2.model;

@FunctionalInterface
public interface PersonFactory {
    public Person create(String name, int age);
}
