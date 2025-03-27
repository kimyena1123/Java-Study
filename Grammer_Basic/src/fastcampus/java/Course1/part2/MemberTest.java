package fastcampus.java.Course1.part2;

public class MemberTest {
    public static void main(String[] args) {

        // 한명의 헬스클럽 회의 데이터를 저장하고 출력하시오
        Member member = new Member();
        member.name = "김예나";
        member.age = 25;
        member.tel = "010-1111-111";
        member.email = "email@naver.com";
        member.addr="서울";
        member.weight = 46.5f;

        System.out.println(member.name + "\t" + member.age + "\t" + member.tel + "\t" + member.email + "\t" + member.addr + "\t" + member.weight);
    }
}
