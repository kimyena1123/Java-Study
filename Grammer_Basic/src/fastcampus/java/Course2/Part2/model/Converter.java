package fastcampus.java.Course2.Part2.model;

@FunctionalInterface
public interface Converter<F, T> {
    T convert(F from);
}
