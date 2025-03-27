package fastcampus.java.Course1.part3;

import fastcampus.java.Course1.model.MemberDTO;

public class AccessModifier {
    public static void main(String[] args) {
        MemberDTO dto = new MemberDTO();
        dto.name = "홍길동";
        dto.phone = "010-1111-4144";

        System.out.println(dto.name + "\t" + dto.phone);
    }
}
