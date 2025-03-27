package fastcampus.java.Course2.Part2;

import java.util.HashMap;

public class CharacterCount {
    public static void main(String[] args) {
        //주어진 문자열에서 문자 하나씩 몇 번 나오는지 출력하시오

        String str = "Hello, World!";
        HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();
        char[] strArray = str.toCharArray();

        for(char data : strArray){
            if(charCountMap.containsKey(data)){
                charCountMap.put(data, charCountMap.get(data) + 1);
            }else{
                charCountMap.put(data, 1);
            }
        }

        System.out.println("Character Counts: ");
        for(char data: charCountMap.keySet()){
            System.out.println(data + " : " + charCountMap.get(data));
        }
    }
}
