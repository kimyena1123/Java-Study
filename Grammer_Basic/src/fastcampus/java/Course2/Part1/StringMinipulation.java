package fastcampus.java.Course2.Part1;

public class StringMinipulation {
    public static void main(String[] args) {

        String str = new String("HelloWorld");

        char firstChar = str.charAt(0);
        char secondChar = str.charAt(1);
        System.out.println("firChar: " + firstChar + "\nsecondChar: " + secondChar);

        String replacedString = str.replaceAll("l", "L");
        System.out.println("교체된 후의 문자열: " + replacedString);
        System.out.println("원래 문자: "+ str);

        int index = str.indexOf("W");
        System.out.println("W의 index 위치: " + index);

        int index2 = str.indexOf("Wr");
        System.out.println("index2 확인: " + index2); // 없으면 -1 반환한다

        for(int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
        }

        int length  = str.length();
        System.out.println("문자 길이: " + length);

        String upperCase = str.toUpperCase();
        System.out.println(upperCase);

        String lowerCase = str.toLowerCase();
        System.out.println(lowerCase);

        String substring = str.substring(5);
        System.out.println(substring);

        String substring2 = str.substring(5, 8); // 5,6,7 자리의 문자가 나옴
        System.out.println(substring2);
    }
}
