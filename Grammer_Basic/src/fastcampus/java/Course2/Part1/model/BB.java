package fastcampus.java.Course2.Part1.model;

//BB는 노출X. CC는 노출O
public class BB implements CC{
    @Override
    public void x() {
        System.out.println("x method running");
    }

    @Override
    public void y() {
        System.out.println("y method running");
    }

    @Override
    public void z() {
        System.out.println("z method running");
    }
}
