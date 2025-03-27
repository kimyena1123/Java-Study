package fastcampus.java.Course2.Part1.model;

// OracleDriver는 Oracle 회사에서 만들어서 제공을 하면 된다
public class OracleDriver implements Connection{

    @Override
    public void getConnection(String url, String username, String password) {
        System.out.println("url, username, password 정보를 이용해 Oracle DB 접속 시도");
    }
}
