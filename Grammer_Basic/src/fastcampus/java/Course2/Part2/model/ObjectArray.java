package fastcampus.java.Course2.Part2.model;

public class ObjectArray<T> {
    private T[] array;
    private int size = 0;

    public ObjectArray(int size){
        //제너릭 배열을 생성하는 방법은 배열을 생성한 후 형변환을 해야 한다
        array = (T[]) new Object[size];//다운캐스팅. 일단은 Object로 하고, 타입이 정해지면 (T[])로 해서 다운캐스팅한다
    }

    public void set(int index, T value){
        array[index] = value;
        size++;
    }

    public T get(int index){
        return array[index];
    }

    public int size(){
        return size;
    }

    public int length(){
        return array.length;
    }
}
