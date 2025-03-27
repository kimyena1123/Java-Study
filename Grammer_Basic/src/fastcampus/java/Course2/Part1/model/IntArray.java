package fastcampus.java.Course2.Part1.model;

import java.util.Arrays;

public class IntArray { //정수 3개를 배열에 저장하고 출력하시오

    private static final int DEFAULT_CAPACITY = 5; // 수정 불가(final) =>  상수

    private int[] elements;
    private int size = 0;

    //생성 동작 IntArray()
    //저장하는 동작 add()
    //가져오는 동작 get()
    //크기를 구하는 동작 size()

    public IntArray(){
        elements = new int[DEFAULT_CAPACITY]; //배열 생성
    }

    public int size(){
        return size;
    }

    public int get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("범위 초과"); //리스트와 같은 자료형들에서 인덱스의 범위를 벗어나는 경우 에러 발
        }
        return elements[index];
    }

    public void add(int element){
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
