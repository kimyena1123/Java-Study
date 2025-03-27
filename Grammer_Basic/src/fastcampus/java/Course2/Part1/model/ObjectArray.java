package fastcampus.java.Course2.Part1.model;

import java.util.Arrays;

public class ObjectArray {
    private static final int DEFAULT_CAPACITY = 5;
    public String length;

    private Object[] elements; //다형성 배열
    private int size = 0;

    public ObjectArray(){
//        elements = new Object[DEFAULT_CAPACITY];
        this(DEFAULT_CAPACITY); //this(5): 생성자 안에서 다른생성자를 호출할 때 사용
    }

    public ObjectArray(int capacity){
        elements = new Object[capacity]; //원하는 크기의 배열 생성
    }

    public int length(){
        return elements.length;
    }

    public int size(){
        return size;
    }

    public Object get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        return elements[index];
    }

    public void add(Object element){ //다형성 인수
        if(size == elements.length){
            ensureCapacity();
        }
        elements[size++] = element;
    }

    private void ensureCapacity(){
        int newCapacity = elements.length * 2;
        elements = Arrays.copyOf(elements, newCapacity);
    }
}
