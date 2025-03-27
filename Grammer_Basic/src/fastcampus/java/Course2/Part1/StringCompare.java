package fastcampus.java.Course2.Part1;

public class StringCompare {
    public static void main(String[] args) {

        //문자열 비교 예제 코드
        String str1 = "Hello";
        String str2 = "World";

        if(str1.equals(str2)){ // 같으면 true, 다르면 false
            System.out.println("두 문자열은 같습니다.");
        }else{
            System.out.println("두 문자열은 다릅니다");
        }

        String str3 = "apple"; // a는 97
        String str4 = "banana"; // b는 98

        int result = str3.compareTo(str4);
        if(result == 0){
            System.out.println("두 문자열은 같습니다");
        }else if(result > 0){
            System.out.println("str3이 str4보다 앞에 있습니다");
        }else{
            System.out.println("str3이 str4보다 뒤에 있습니다.");
        }

        String str = "abcd";

        // 1) 비교대상에 문자열이 포함되어있을 경우
        System.out.println( str.compareTo("abcd") );  // 0 (같은 경우는 숫자나 문자나 0을 리턴)
        System.out.println( str.compareTo("ab") );  //  2
        System.out.println( str.compareTo("a") );  //  3
        System.out.println( str.compareTo("c") );  //  -2
        System.out.println( "".compareTo(str) );  //  -4

        // 2) 비교대상과 전혀 다른 문자열인 경우
        System.out.println( str.compareTo("zefd") );  //  -25
        System.out.println( str.compareTo("zEFd") );  //  -25
        System.out.println( str.compareTo("ABCD") );  //  32
    }
}
